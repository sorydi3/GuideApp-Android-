package com.example.android.guideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AtmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new FragmentsAtms()).commit();
    }
}
