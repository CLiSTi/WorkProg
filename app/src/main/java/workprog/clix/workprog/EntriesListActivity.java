package workprog.clix.workprog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by CLiST on 0020, September 20, 2017.
 */

public class EntriesListActivity extends Activity {

    Button insertButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries_list);

        insertButton = (Button) findViewById(R.id.button);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntriesListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmResults<BodyMeasure> realmResults = realm.where(BodyMeasure.class).findAll();
        final BodyMeasure[] list = new BodyMeasure[realmResults.size()];
        realmResults.toArray(list);

        realm.commitTransaction();

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.entries_list);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        BodyMeasureListAdapter bodyMeasureListAdapter = new BodyMeasureListAdapter(list,
                new BodyMeasureListAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(View view, final int Position, boolean doRemove) {
                        if (!doRemove)
                            recyclerView.smoothScrollToPosition(Position);
                        else {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    int id = list[Position].getId();
                                    RealmResults results = realm.where(BodyMeasure.class).equalTo("id", id).findAll();
                                    results.deleteAllFromRealm();
                                }
                            });
                            recyclerView.smoothScrollToPosition(Position - 1);
                        }
                    }
                });
        recyclerView.setAdapter(bodyMeasureListAdapter);
        recyclerView.smoothScrollToPosition(list.length);
    }
}
