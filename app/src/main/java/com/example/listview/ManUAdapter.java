package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ManUAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<ManU> ManUList;

    public ManUAdapter(Context context, int layout, List<ManU> manUList) {
        this.context = context;
        this.layout = layout;
        ManUList = manUList;
    }

    @Override
    public int getCount() {
        return ManUList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertView = inflater.inflate(layout, null);
        TextView tvTencauthu = (TextView) convertView.findViewById(R.id.tencauthu);
        TextView tvGiacauthu = (TextView) convertView.findViewById(R.id.giacauthu);
        ImageView imgCauthu = (ImageView) convertView.findViewById(R.id.imgMU);



        tvTencauthu.setText(ManUList.get(i).tenCauThu);
        tvGiacauthu.setText(ManUList.get(i).giaCauthu);
        imgCauthu.setImageResource(ManUList.get(i).hinhAnh);

        return convertView;



    }
}
