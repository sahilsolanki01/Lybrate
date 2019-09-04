package com.solanki.sahil.lybrate.ui.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.solanki.sahil.lybrate.R;
import com.solanki.sahil.lybrate.ui.list.adapter.MyRecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ListViewModel> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        arrayList = new ArrayList<>();
        setData();
        mAdapter = new MyRecyclerViewAdapter(arrayList);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void setData() {

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        Log.e("jlfebfblfjqb(*&&&", "setData: " + data);
        try {
            JSONObject object = new JSONObject(data);
            JSONArray jsonArray = object.getJSONArray("restaurants");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONObject jsonObject2 = jsonObject.getJSONObject("restaurant");
                String name = jsonObject2.getString("name");
                String cuisine = jsonObject2.getString("cuisines");
                String cost = jsonObject2.getString("average_cost_for_two");
                JSONObject jsonObject3 = jsonObject2.getJSONObject("location");
                String address = jsonObject3.getString("address");

                ListViewModel listViewModel = new ListViewModel();
                listViewModel.name = name;
                listViewModel.address = address;
                listViewModel.cuisine = cuisine;
                listViewModel.cost = "Avg Cost for 2 : " + cost;
                listViewModel.view_type = -1;
                arrayList.add(listViewModel);

            }

            arrayList = Common.sortList(arrayList);
            arrayList = Common.addCuisine(arrayList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
