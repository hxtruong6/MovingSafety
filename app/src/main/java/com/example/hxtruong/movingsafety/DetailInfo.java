package com.example.hxtruong.movingsafety;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
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
        Context context = panel_IMG_back.getContext();
        int bgId = context.getResources().getIdentifier(helper.getAvatarLink(), "drawable", context.getPackageName());
        Glide.with(getApplicationContext()).load(bgId).into(panel_IMG_back);

        TextView name = findViewById(R.id.nameTextView);
        name.setText(helper.getName());

        TextView distance = findViewById(R.id.distanceTextView);
        String distanceText = Integer.toString((int) helper.getDistanceToCurrenLocation());
        distance.setText(distanceText + " meters");

        TextView address = findViewById(R.id.addressTextView);
        address.setText(helper.getAddress());

        TextView phone = findViewById(R.id.phoneTextView);
        phone.setText("Phone: " + helper.getPhoneNumber());

    }

    public void callBtnOnClick(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + helper.getPhoneNumber()));
        startActivity(intent);
    }

    public void messBtnOnClick(View view) {
        // Create the text message with a string
        Uri sms_uri = Uri.parse("smsto:" + helper.getPhoneNumber());
        Intent sendIntent = new Intent(Intent.ACTION_SEND, sms_uri);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Please help me!!! Call me right now. 0975244614");
        sendIntent.setType("text/plain");

        // Create intent to show the chooser dialog
        Intent chooser = Intent.createChooser(sendIntent, "Send message with.... Please choose one");
        // Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    public void commentBtnOnClick(View view) {
    }

    public void saveBtnOnClick(View view) {
    }
}
