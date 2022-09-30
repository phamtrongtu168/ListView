package com.example.listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<ManU> arrayList;
    private ManUAdapter adapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        listView= (ListView) findViewById(R.id.lvManU);
        arrayList = new ArrayList<>();
        arrayList.add(new ManU("Harry Marguire","80.000.000$",R.drawable.marguine));
        arrayList.add(new ManU("Antony Matheus dos Santos","100.000.000$",R.drawable.antony));
        arrayList.add(new ManU("Jadon Malik Sancho","60.000.000$",R.drawable.sancho));
        arrayList.add(new ManU("Frederico Rodrigues","30.000.000$",R.drawable.fred1));
        arrayList.add(new ManU("Cristiano Ronaldo","120.000.000$",R.drawable.cr77));
        adapter = new ManUAdapter(this,R.layout.cauthu,arrayList);


        listView.setAdapter(adapter);

    listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view,final int position, long l) {
            AlertDialog.Builder dialog  = new AlertDialog.Builder(context);
            dialog.setTitle("Xac Nhan");
            dialog.setMessage("Ban co dong y xoa khong ?");
            dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    arrayList.remove(position);

                    adapter.notifyDataSetChanged();

                }
            });
            dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog = dialog.create();
            alertDialog.show();
            return false;

        }
    });
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent x = new Intent(MainActivity.this, ProfileManU.class);
            startActivity(x);
        }
    });


    }

}