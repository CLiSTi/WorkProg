package workprog.clix.workprog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.realm.*;

public class MainActivity extends AppCompatActivity {

    private Button ready_button;
    private CustomViewNumberEntry cv_weight, cv_fat, cv_water, cv_muscles, cv_bone, cv_kilocaries;
    private float bodyWeight, bodyFat, bodyWater, bodyMuscles, bodyBone;
    private int dailyKilocaries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm realm = Realm.getDefaultInstance();

        cv_weight     = (CustomViewNumberEntry) findViewById(R.id.cv_weight);
        cv_fat        = (CustomViewNumberEntry) findViewById(R.id.cv_fat_ratio);
        cv_water      = (CustomViewNumberEntry) findViewById(R.id.cv_water_ratio);
        cv_muscles    = (CustomViewNumberEntry) findViewById(R.id.cv_muscle_ratio);
        cv_bone       = (CustomViewNumberEntry) findViewById(R.id.cv_bone_ratio);
        cv_kilocaries = (CustomViewNumberEntry) findViewById(R.id.cv_kilocalories);

        ready_button = (Button) findViewById(R.id.main_activity_ready_button);
        ready_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateIndexes();
                Toast.makeText(getApplicationContext(),
                        "Weight: " + bodyWeight + "\n" +
                                "Body Fat: " + bodyFat + "\n" +
                                "Body Water: " + bodyWater + "\n" +
                                "Body Muscles: " + bodyMuscles + "\n" +
                                "Bone Mass: " + bodyBone + "\n" +
                                "Daily Kilocalories: " + dailyKilocaries
                        , Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void updateIndexes() {

        try {
            bodyWeight = Float.parseFloat(cv_weight.getText());
        }
        catch (NumberFormatException ex){
            bodyWeight = 0;
        }

        try {
            bodyFat = Float.parseFloat(cv_fat.getText());
        }
        catch (NumberFormatException ex){
            bodyFat = 0;
        }

        try {
            bodyWater = Float.parseFloat(cv_water.getText());
        }
        catch (NumberFormatException ex){
            bodyWater = 0;
        }

        try {
            bodyMuscles = Float.parseFloat(cv_muscles.getText());
        }
        catch (NumberFormatException ex){
            bodyMuscles = 0;
        }

        try {
            bodyBone = Float.parseFloat(cv_bone.getText());
        }
        catch (NumberFormatException ex){
            bodyBone = 0;
        }

        try {
            dailyKilocaries = Integer.parseInt(cv_kilocaries.getText());
        }
        catch (NumberFormatException ex){
            dailyKilocaries = 0;
        }
    }

}
