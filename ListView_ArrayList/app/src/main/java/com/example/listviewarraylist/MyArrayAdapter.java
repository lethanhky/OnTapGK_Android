package com.example.listviewarraylist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien>{
    Activity context = null;
    ArrayList<NhanVien> myArray = null;
    int layoutId;
    public MyArrayAdapter(Activity context,int TextViewResourceId, ArrayList<NhanVien> object)
    {
        super(context,TextViewResourceId,object);
        this.context= context;
        this.layoutId = TextViewResourceId;
        this.myArray = object;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId,null);
        if(myArray.size() > 0 && position >= 0)
        {
            final TextView txtDisplay = (TextView)convertView.findViewById(R.id.tv_item);
            final  NhanVien nv = myArray.get(position);
            txtDisplay.setText(nv.toString());
            final ImageView imgitem = (ImageView)convertView.findViewById(R.id.imgitem);
            if(nv.isGender()){
                imgitem.setImageResource(R.drawable.images);
            }else {
                imgitem.setImageResource(R.drawable.giricom);
            }
        }
        return convertView;

    }
}
