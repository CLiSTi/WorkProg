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

public class CustomNumberEdit extends LinearLayout {

    private String labelValue, textValue;
    //private int backgroundCol1, backgroundCol2, textColor1, textColor2;
    public TextView label;
    public EditText editText;


    public CustomNumberEdit(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomViewDataEntry, 0, 0);
        try {
            labelValue = typedArray.getString(
                    R.styleable.CustomViewDataEntry_cm_labelvalue);
/*            backgroundCol1 = typedArray.getInt(
                    R.styleable.CustomViewDataEntry_cm_background1, R.color.color1);
            backgroundCol2 = typedArray.getInt(
                    R.styleable.CustomViewDataEntry_cm_background2, R.color.color2);
            textColor1 = typedArray.getInt(
                    R.styleable.CustomViewDataEntry_cm_textcolor1, R.color.white);
            textColor2 = typedArray.getInt(
                    R.styleable.CustomViewDataEntry_cm_textcolor2, R.color.black);*/
        } finally {
            typedArray.recycle();
        }

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_number_edit, this, true);

       /* RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.relativeLayout);
        relativeLayout.setBackgroundColor(backgroundCol1);*/

        label = (TextView)  view.findViewById(R.id.textView);
        label.setText(labelValue);
        //label.setTextColor(textColor1);

        editText = (EditText) view.findViewById(R.id.editText);
        //editText.setBackgroundColor(backgroundCol2);
        //editText.setTextColor(textColor2);
    }

    public void setLabelText(String string) {
        labelValue = string;
        label.setText(string);
    }

    public String getText() {
        return editText.getText().toString();
    }
}
