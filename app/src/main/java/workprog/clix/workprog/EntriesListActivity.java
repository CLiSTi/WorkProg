package workprog.clix.workprog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by CLiST on 0020, September 20, 2017.
 */

public class EntriesListActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries_list);

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmResults<BodyMeasure> realmResults = realm.where(BodyMeasure.class).findAll();
        BodyMeasure[] list = new BodyMeasure[realmResults.size()];
        realmResults.toArray(list);
        for (BodyMeasure element: list) {
            Log.i("XPC", element.toString());
        }

        realm.commitTransaction();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.entries_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        BodyMeasureListAdapter bodyMeasureListAdapter = new BodyMeasureListAdapter(list);
        recyclerView.setAdapter(bodyMeasureListAdapter);

    }
}
