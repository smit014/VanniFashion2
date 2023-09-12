package com.example.vannifashion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    String[] sarilist = {"banarasi ", "net ", "georgetta ", "kanjivaram ", "bandhani", "dola silk", "chiffon ", "silk ", "leheriya","kanchipuram","organza"};

    public static int[] imglist = {R.drawable.banarasi1, R.drawable.net1, R.drawable.georgette2jpg, R.drawable.kanjivarm1, R.drawable.banarasi2, R.drawable.kanchipuram2, R.drawable.kanchipuram3, R.drawable.kanchipuram4, R.drawable.kanchipuram5,R.drawable.kanchipuram1,R.drawable.organza1};

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