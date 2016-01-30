package com.android_visibility_issue;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.facebook.react.bridge.ReactContext;

public class MyView extends FrameLayout {

    private String TAG = MyView.class.getSimpleName();
    private ReactContext mReactContext;

    public MyView(Context context) {
        super(context);
        mReactContext = (ReactContext) context;
        initView(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout, this);
        Button bt1 = (Button) view.findViewById(R.id.btn_test1);
        final Button bt2 = (Button) view.findViewById(R.id.btn_test2);
        bt1.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                bt2.setVisibility(View.VISIBLE);
                Toast.makeText(mReactContext, "Button 2 should be shown! But not shown! Why?", Toast.LENGTH_LONG).show();
            }
        });
    }
}
