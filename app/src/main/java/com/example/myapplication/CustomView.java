package com.example.myapplication;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
public class CustomView extends ConstraintLayout implements View.OnClickListener, View.OnLongClickListener {


    private Button btn;
    private int[] colors = getContext().getResources().getIntArray(R.array.colors);
    private int number ;
    String numText;
    public CustomView(Context context) {
        this(context, null);
    }
    public CustomView(Context context,  AttributeSet attrs) {
        this(context, attrs, R.attr.customViewStyle);
    }
    public CustomView(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }


    public void init(Context context, AttributeSet attrs, int defStyle) {
        View v = inflate(context, R.layout.activity_custom, null);
        btn =  v.findViewById(R.id.btn);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomView, defStyle,0);

        if (a.hasValue(R.styleable.CustomView_number)) {
            numText = a.getString(R.styleable.CustomView_number);
            btn.setText(numText);
            number = Integer.parseInt(numText);
        }else{
            checkNumber();}
        btn.setBackgroundColor(colors[number]);
        btn.setOnClickListener(this);
        btn.setOnLongClickListener(this);
        addView(v);


    }
    @Override
    public void onClick(View v) {
        number++;
        btn.setBackgroundColor(colors[number]);
        btn.setText(number + "");
    }
    @Override
    public boolean onLongClick(View v) {
        number--;
        btn.setBackgroundColor(colors[number]);
        btn.setText(number + "");
        return true;
    }
    private void checkNumber(){
        if(!btn.getText().equals("")){
            number=Integer.parseInt(btn.getText().toString());}
        else
            number=0;

    }
}