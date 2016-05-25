package com.parallelyk.birthdayreminder.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.parallelyk.birthdayreminder.R;
import com.parallelyk.birthdayreminder.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private ArrayList<HashMap<String,Object>> mData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initTestData();
        initView();


    }
    public void initView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle("生日");
        setSupportActionBar(toolbar);

        MainAdapter adapter = new MainAdapter(MainActivity.this,mData);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }

    public void initTestData(){
        for (int i = 0;i<20;i++){
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("name","name"+i);
            hashMap.put("dayleft","dayleft"+i);
            hashMap.put("birthday","birthday"+i);
            mData.add(hashMap);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_main, menu);
        return true;
    }


}
