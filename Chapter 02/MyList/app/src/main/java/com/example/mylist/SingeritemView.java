package com.example.mylist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class SingeritemView extends LinearLayout {

    TextView textView;
    TextView textView2;
    ImageView imageView;

    //기본 생성자
    public SingeritemView(Context context) {
        super(context);
        init(context);
    }

    //기본 생성자
    public SingeritemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    //초기화를 위한 메서드 생성 - 인플레이션(메모리 객체화해서 붙여주는 역할)
    private void init(Context context){
        
        //인플레이션
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
    public void setName(String name){
        textView.setText(name);
    }
    public void setMobile(String mobile){
        textView2.setText(mobile);
    }
    public void setImage(int resID){imageView.setImageResource(resID);}
}
