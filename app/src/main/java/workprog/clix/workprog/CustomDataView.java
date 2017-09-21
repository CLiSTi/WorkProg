package workprog.clix.workprog;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by CLiST on 0020, September 20, 2017.
 */

public class CustomDataView extends LinearLayout {

    private String labelText, valueText;
    public TextView label, value;


    public CustomDataView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomDataView, 0, 0);
        try {
            labelText = typedArray.getString(
                    R.styleable.CustomDataView_cmLabelText);
            valueText = typedArray.getString(
                    R.styleable.CustomDataView_cmValueText);
        } finally {
            typedArray.recycle();
        }

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_data_view, this, true);


        label = (TextView) view.findViewById(R.id.labelText);
        label.setText(labelText);

        value = (TextView) view.findViewById(R.id.valueText);
        value.setText(valueText);
    }

    public void setLabelText(String string) {
        labelText = string;
        label.setText(string);
    }

    public void setValueText(String string) {
        valueText = string;
        value.setText(string);
    }
}
