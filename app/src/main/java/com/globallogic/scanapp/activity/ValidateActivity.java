package com.globallogic.scanapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.globallogic.scanapp.R;

public class ValidateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);


        boolean success = getIntent().getExtras().getBoolean("VALID");
        ImageView img = (ImageView) findViewById(R.id.imageView);
        TextView text = (TextView) findViewById(R.id.textView);

        if (success) {
            img.setImageResource(R.drawable.success);
            text.setText("Success");

        }else{
            img.setImageResource(R.drawable.unsuccess);
            text.setText("Fail");
        }
    }
}
