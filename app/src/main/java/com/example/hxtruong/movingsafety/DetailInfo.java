package com.example.hxtruong.movingsafety;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class DetailInfo extends AppCompatActivity {
    public static final String EXTRA_DETAIL_MESSAGE = "com.example.hxtruong.DETAIL_INFO";
    private Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);

        helper = getIntent().getExtras().getParcelable(EXTRA_DETAIL_MESSAGE);
        displayInfoStore();
    }

    private void displayInfoStore() {
        ImageView panel_IMG_back = findViewById(R.id.splashImageView);
        Glide.with(this).load(R.drawable.bg).into(panel_IMG_back);

        TextView name = findViewById(R.id.nameTextView);
        name.setText(helper.getName());

        TextView distance = findViewById(R.id.distanceTextView);
        String distanceText = Integer.toString((int)helper.getDistanceToCurrenLocation());
        distance.setText(distanceText + " meters");

    }

    public void callBtnOnClick(View view) {
    }

    public void messBtnOnClick(View view) {
    }

    public void commentBtnOnClick(View view) {
    }

    public void saveBtnOnClick(View view) {
    }
}
