package com.parallelyk.birthdayreminder.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.parallelyk.birthdayreminder.R;
import com.parallelyk.birthdayreminder.adapter.MainFragmentPagerAdapter;
import com.parallelyk.birthdayreminder.fragment.FriendFragment;
import com.parallelyk.birthdayreminder.fragment.MainFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener ,
        MainFragment.OnFragmentInteractionListener {//AppCompatActivity继承至FragmentActivity

    private RecyclerView mRecyclerView;
    private Toolbar toolbar;
    private ViewPager mViewPager;
    private MainFragmentPagerAdapter adapter;
    private TextView mTv_friend,mTv_discover,mTv_me;

    private ArrayList<Fragment> mFragLists = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initTestData();
        //getContactData();
        initView();
        adapter = new MainFragmentPagerAdapter(getSupportFragmentManager(),mFragLists);
        mViewPager.setAdapter(adapter);


    }
    public void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle("生日小助手");
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent ;
                switch (item.getItemId()) {
                    case R.id.action_search:
                        break;
                    case R.id.action_add:
                        intent = new Intent(MainActivity.this,AddFriendActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });

        mViewPager = (ViewPager) findViewById(R.id.vp_main);
        mTv_friend = (TextView) findViewById(R.id.friend_text_main);
        mTv_discover = (TextView) findViewById(R.id.discover_text_main);
        mTv_me = (TextView) findViewById(R.id.me_text_main);

        Fragment friendFragment = FriendFragment.newInstance("friend", null);
        Fragment discoverFragment = MainFragment.newInstance("discover",null);
        Fragment meFragment = MainFragment.newInstance("me",null);

        mFragLists.add(friendFragment);
        mFragLists.add(discoverFragment);
        mFragLists.add(meFragment);




    }

    private void initControl(){

    }


    private void initData(){

    }


//    public void initTestData(){
//        for (int i = 0;i<20;i++){
//            HashMap<String,Object> hashMap = new HashMap<>();
//            hashMap.put("name","name"+i);
//            hashMap.put("dayleft","dayleft"+i);
//            hashMap.put("birthday","birthday"+i);
//            mData.add(hashMap);
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_main, menu);
        return true;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//        Intent intent ;
//        switch (item.getItemId()) {
//            case R.id.action_search:
//
//                break;
//            case R.id.action_add:
//                intent = new Intent(this,AddFriendActivity.class);
//                startActivity(intent);
//                break;
//
//        }
//        return false;
//    }
}
