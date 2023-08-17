package com.example.vannifashion;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vannifashion.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] sareeName = {"Rose","Lotus","Lily","Jasmine",
                "Tulip","Orchid","Levender","RoseMarry","Sunflower","Carnation"};
        int[] sareeImages = {R.drawable.banarasi1,R.drawable.banarasi2,R.drawable.banarasi3,R.drawable.banarasi4,R.drawable.banarasi5,R.drawable.banarasi6,R.drawable.banarasi1,
                R.drawable.banarasi2,R.drawable.banarasi2,R.drawable.banarasi2};

        GridAdapter gridAdapter = new GridAdapter(MainActivity.this,sareeName,sareeImages);
//         binding.gridView.setAdapter(gridAdapter);




    }
}