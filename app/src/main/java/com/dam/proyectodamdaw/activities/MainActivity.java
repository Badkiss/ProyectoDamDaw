package com.dam.proyectodamdaw.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectodamdaw.Parameters;
import com.dam.proyectodamdaw.activities.Model.Model;
import com.dam.proyectodamdaw.activities.Model.MyRecyclerViewAdapter;
import com.dam.proyectodamdaw.activities.Model.Root;
import com.dam.proyectodamdaw.api.Connector;
import com.dam.proyectodamdaw.base.BaseActivity;
import com.dam.proyectodamdaw.base.CallInterface;
import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.base.ImageDownloader;

public class MainActivity extends BaseActivity implements CallInterface, View.OnClickListener {
private Root root;
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.weather_view);

    }

    @Override
    protected void onResume() {
        super.onResume();
        showProgress();
        executeCall(this);
    }

    @Override
    public void doInBackground() {
    root= (Root) Connector.getConector().get(Root.class,"forecast?lat=39.5940799&lon=-0.5594087&appid=7d6681aa36fec24e73f595038b445af3&lang=es");
    }

    @Override
    public void doInUI() {
        hideProgress();
        recyclerView=findViewById(R.id.recycler);
        MyRecyclerViewAdapter my =new MyRecyclerViewAdapter(this,root);
        LinearLayoutManager lin =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lin);
        recyclerView.setAdapter(my);
        my.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
    Root root= Model.getInstance().getList().get(recyclerView.getChildAdapterPosition(view));
    }
}