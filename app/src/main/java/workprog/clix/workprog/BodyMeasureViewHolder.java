package workprog.clix.workprog;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by CLiST on 0020, September 20, 2017.
 */

class BodyMeasureViewHolder extends RecyclerView.ViewHolder{

    private CustomDataView tvBodyMass, tvBodyFat, tvBodyWater,
            tvBodyMuscles, tvBoneMass, tvKilocalories;
    private TextView tvDate;
    private Button removeButton;
    private BodyMeasureListAdapter.OnItemClickListener mListener;

    public BodyMeasureViewHolder(View itemView, final BodyMeasureListAdapter.OnItemClickListener mListener) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v, getAdapterPosition(), false);
            }
        });
        this.mListener   = mListener;
        tvBodyMass       = (CustomDataView) itemView.findViewById(R.id.tvBodyMass);
        tvBodyFat        = (CustomDataView) itemView.findViewById(R.id.tvBodyFat);
        tvBodyWater      = (CustomDataView) itemView.findViewById(R.id.tvBodyWater);
        tvBodyMuscles    = (CustomDataView) itemView.findViewById(R.id.tvBodyMuscles);
        tvBoneMass       = (CustomDataView) itemView.findViewById(R.id.tvBoneMass);
        tvKilocalories   = (CustomDataView) itemView.findViewById(R.id.tvKilocalories);
        tvDate           = (TextView) itemView.findViewById(R.id.tvDate);
        removeButton     = (Button) itemView.findViewById(R.id.removeButton);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v, getAdapterPosition(), true);
            }
        });
    }

    public void setValues(BodyMeasure bodyMeasure) {
        Context context = itemView.getContext();
        Resources resources = context.getResources();

        //resources.getString(R.string.body_fat)

        String bMassString      = Float.toString(bodyMeasure.getBodyWeight());
        String bFatString       = Float.toString(bodyMeasure.getBodyFat());
        String bWaterString     = Float.toString(bodyMeasure.getBodyWater());
        String bMusclesString   = Float.toString(bodyMeasure.getBodyMuscles());
        String bBoneString      = Float.toString(bodyMeasure.getBodyBone());
        String bKcString        = Float.toString(bodyMeasure.getDailyKilocaries());
        String bDate            = bodyMeasure.getDate().toString();

        tvBodyMass.setValueText(bMassString);
        tvBodyFat.setValueText(bFatString);
        tvBodyWater.setValueText(bWaterString);
        tvBodyMuscles.setValueText(bMusclesString);
        tvBoneMass.setValueText(bBoneString);
        tvKilocalories.setValueText(bKcString);
        tvDate.setText(bDate);
    }

}
