package com.example.vannifashion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    Context context;
    String[] sareeName;
    int[] image;

    LayoutInflater inflater;

    public GridAdapter(Context context, String[] sareeName, int[] image) {
        this.context = context;
        this.sareeName = sareeName;
        this.image = image;
    }

    @Override
    public int getCount() {
        return sareeName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){

            convertView = inflater.inflate(R.layout.cardview,null);

        }

        ImageView imageView = convertView.findViewById(R.id.itemImg);
        TextView textView = convertView.findViewById(R.id.itemText);

        imageView.setImageResource(image[position]);
        textView.setText(sareeName[position]);

        return convertView;
    }
}
