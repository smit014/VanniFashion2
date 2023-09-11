package com.example.vannifashion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    String[] sarilist = {"banarasi ", "net ", "georgetta ", "kanjivaram ", "bandhani", "dola silk", "chiffon ", "silk ", "leheriya"};

    public static int[] imglist = {R.drawable.banarasi1, R.drawable.net1, R.drawable.georgetta1, R.drawable.kanjivarm1, R.drawable.banarasi2, R.drawable.banarasi3, R.drawable.banarasi4, R.drawable.banarasi5, R.drawable.banarasi6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview);

        Intent intent = new Intent(MainActivity.this, ViewActivity.class);

        MySAdapter mysadapter = new MySAdapter(getApplicationContext(), R.layout.cardview, sarilist);
        gridView.setAdapter(mysadapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            intent.putExtra("pos", position);
            startActivity(intent);
        });
    }
}