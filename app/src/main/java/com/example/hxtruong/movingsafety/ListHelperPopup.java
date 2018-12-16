package com.example.hxtruong.movingsafety;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ListHelperPopup extends Activity {
    public static final String EXTRA_POPUP_MESSAGE = "com.example.hxtruong.ListHelperPopup";
    private ListView listView;
    protected View view;
    private Helper[] helperArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_helper_pop_up);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width * 0.8f), (int) (height * 0.7f));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);
        String listSerializedToJson = getIntent().getExtras().getString(EXTRA_POPUP_MESSAGE);
        Log.d("xxx01 ", listSerializedToJson);
        helperArray = new Gson().fromJson(listSerializedToJson, Helper[].class); // in this
        displayListHelpers();
    }

    private void displayListHelpers() {
        listView = (ListView) findViewById(R.id.listView);
        ListHelperAdapter listHelperAdapter = new ListHelperAdapter();
        listView.setAdapter(listHelperAdapter);
    }

    class ListHelperAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return helperArray.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.list_helper, null);
            TextView helperName = view.findViewById(R.id.helperName);
            String name = helperArray[position].getName();
            Log.d("xxx02 ", helperName + name);

            helperName.setText(name);
            return view;
        }
    }
}
