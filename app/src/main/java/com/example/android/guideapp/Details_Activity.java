package com.example.android.guideapp;

import java.util.ArrayList;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Details_Activity extends AppCompatActivity {
    private ArrayList<Info> mArrayList;
    private int mPOSITION;
    private String name1;
    private String direction;
    private String mNumber;
    private int image;
    private String info4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
        Bundle bundle = new Bundle();
        bundle = this.getIntent().getExtras();
        mArrayList = bundle.getParcelableArrayList("ArrayList");
        mPOSITION = bundle.getInt("position");
        name1 = mArrayList.get(mPOSITION).getmName();
        direction = mArrayList.get(mPOSITION).getmDirection();
        info4 = mArrayList.get(mPOSITION).getDetails();
        image = mArrayList.get(mPOSITION).getmImage();
        mNumber = mArrayList.get(mPOSITION).getmNumber();
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(name1);
        TextView number = (TextView) findViewById(R.id.number1111);
        number.setText(mNumber);
        TextView direction1 = (TextView) findViewById(R.id.direction1111);
        direction1.setText(direction);
        TextView info = (TextView) findViewById(R.id.info11);
        info.setText(info4);
        ImageView image1 = (ImageView) findViewById(R.id.backdrop);
        image1.setImageResource(image);
    }
}
