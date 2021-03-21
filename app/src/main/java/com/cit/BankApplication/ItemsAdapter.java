package com.cit.BankApplication;

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

public class ItemsAdapter extends ArrayAdapter<Items> {


    private  Context mContext;
    private int mResource;
        //use arraylist
    public ItemsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Items> objects) {
        super(context, resource, objects);

        this.mContext=context;
        this.mResource =resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.list_row,parent,false);
        ImageView imageView=  convertView.findViewById(R.id.image);
        TextView txtFacture =convertView.findViewById(R.id.sFacture);
        TextView txtPrice =convertView.findViewById(R.id.sPrice);
        TextView txtDate = convertView.findViewById(R.id.sdate);

        imageView.setImageResource(getItem(position).getImage());
        txtFacture.setText(getItem(position).getOperation());
        txtPrice.setText(getItem(position).getMontant());
        txtDate.setText(getItem(position).getDate());

        return convertView;
    }
}
