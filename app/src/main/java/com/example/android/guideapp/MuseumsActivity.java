package com.example.android.guideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
public class MuseumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new FragmentsMuseums()).commit();
    }
}
