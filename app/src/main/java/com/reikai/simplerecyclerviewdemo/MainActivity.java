package com.reikai.simplerecyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListRecyclerViewAdapter.ItemClickListener {

    ListRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data for the Recycler View
        ArrayList<String> itemsList = new ArrayList<>();
        itemsList.add("Item 1");
        itemsList.add("Item 2");
        itemsList.add("Item 3");
        itemsList.add("Item 4");
        itemsList.add("Item 5");
        itemsList.add("Item 6");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // Set up recycler view
        RecyclerView recyclerView = findViewById(R.id.rvList);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new ListRecyclerViewAdapter(this, itemsList);
        adapter.setClickLister(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnItemClick(View view, int position) {
        Toast.makeText(this, "Clicked " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}
