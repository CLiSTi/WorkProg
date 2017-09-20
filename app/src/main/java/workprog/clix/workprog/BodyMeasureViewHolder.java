package workprog.clix.workprog;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by CLiST on 0020, September 20, 2017.
 */

class BodyMeasureViewHolder extends RecyclerView.ViewHolder{

    private TextView tvBodyMass, tvBodyFat, tvBodyWater,
            tvBodyMuscles, tvBoneMass, tvKilocalories, tvDate;

    public BodyMeasureViewHolder(View itemView) {
        super(itemView);

        tvBodyMass = (TextView) itemView.findViewById(R.id.tvBodyMass);
        tvBodyFat = (TextView) itemView.findViewById(R.id.tvBodyFat);
        tvBodyWater = (TextView) itemView.findViewById(R.id.tvBodyWater);
        tvBodyMuscles = (TextView) itemView.findViewById(R.id.tvBodyMuscles);
        tvBoneMass = (TextView) itemView.findViewById(R.id.tvBoneMass);
        tvKilocalories = (TextView) itemView.findViewById(R.id.tvKilocalories);
        tvDate = (TextView) itemView.findViewById(R.id.tvDate);
    }

    public void setValues(BodyMeasure bodyMeasure) {
        Context context = itemView.getContext();
        Resources resources = context.getResources();

        String bMassString = resources.getString(R.string.body_mass) + bodyMeasure.getBodyWeight();
        String bFatString = resources.getString(R.string.body_fat) + bodyMeasure.getBodyFat();
        String bWaterString = resources.getString(R.string.body_water) + bodyMeasure.getBodyWater();
        String bMusclesString = resources.getString(R.string.body_muscles) + bodyMeasure.getBodyMuscles();
        String bBoneString = resources.getString(R.string.bone_mass) + bodyMeasure.getBodyBone();
        String bKcString = resources.getString(R.string.kilocalories) + bodyMeasure.getDailyKilocaries();
        String bDate = bodyMeasure.getDate().toString();

        tvBodyMass.setText(bMassString);
        tvBodyFat.setText(bFatString);
        tvBodyWater.setText(bWaterString);
        tvBodyMuscles.setText(bMusclesString);
        tvBoneMass.setText(bBoneString);
        tvKilocalories.setText(bKcString);
        tvDate.setText(bDate);
    }

}
