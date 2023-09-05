package com.example.vannifashion;

import static com.example.vannifashion.MainActivity.imglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MySAdapter extends ArrayAdapter {

    Context context;
    String[] slist;

    TextView itemtext;
    ImageView itemimg;

    public MySAdapter(Context mainpage, int resourse, String[] sarilist) {
        super(mainpage, resourse, sarilist);
        this.context = mainpage;
        this.slist = sarilist;
    }

    @Override
    public int getCount() {
        return slist.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View cview = LayoutInflater.from(context).inflate(R.layout.cardview,parent,false);

        itemimg = cview.findViewById(R.id.itemImg);
        itemtext = cview.findViewById(R.id.itemText);

        itemtext.setText(slist[position]);
        itemimg.setImageResource(imglist[position]);

        return cview;
    }
}
