package com.example.hxtruong.movingsafety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailInfo extends AppCompatActivity {
    public static final String EXTRA_DETAIL_MESSAGE = "com.example.hxtruong.DETAIL_INFO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);
        String message = (String) getIntent().getExtras().getSerializable(EXTRA_DETAIL_MESSAGE);
        ((TextView) findViewById(R.id.nameTextView)).setText(message);

    }
}
