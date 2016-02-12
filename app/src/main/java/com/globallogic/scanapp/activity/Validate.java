package com.globallogic.scanapp.activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.globallogic.scanapp.R;

public class Validate extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);

        boolean success = true;
        if (success == true) {
            ImageView img = (ImageView) findViewById(R.id.imageView);
            img.setImageResource(R.drawable.success);

        }


    }




}
