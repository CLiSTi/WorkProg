package workprog.clix.workprog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by CLiST on 0020, September 20, 2017.
 */

class BodyMeasureListAdapter extends RecyclerView.Adapter<BodyMeasureViewHolder> {

    private BodyMeasure[] bodyMeasures;

    public BodyMeasureListAdapter(BodyMeasure[] bodyMeasures) {
        this.bodyMeasures = bodyMeasures;
    }

    @Override
    public BodyMeasureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bodymeasure_element, parent, false);
        return new BodyMeasureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BodyMeasureViewHolder holder, int position) {
        holder.setValues(bodyMeasures[position]);
    }

    @Override
    public int getItemCount() {
        return bodyMeasures.length;
    }
}
