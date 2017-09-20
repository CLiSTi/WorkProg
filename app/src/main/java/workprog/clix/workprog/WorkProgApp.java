package workprog.clix.workprog;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by CLiST on 0020, September 20, 2017.
 */

public class WorkProgApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
