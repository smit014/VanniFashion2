package com.example.vannifashion;

import static com.example.vannifashion.MainActivity.imglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ViewActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        img = findViewById(R.id.itemImg1);

        int pos = getIntent().getIntExtra("pos",0);

        img.setImageResource(imglist[pos]);

    }
}