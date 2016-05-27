package com.parallelyk.birthdayreminder.activity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.parallelyk.birthdayreminder.R;
import com.parallelyk.birthdayreminder.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class AddFriendActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Context mContext;
    private ArrayList<HashMap<String,Object>> mData = new ArrayList<>();
    private MainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        mContext = this;
        init();
    }

    private void init(){
        getContactData();
        adapter = new MainAdapter(mContext,mData);
        mRecyclerView = (RecyclerView) findViewById(R.id.add_friend_listview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(adapter);
    }

    private void getContactData(){

        Cursor cursor = mContext.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                int phoneCount = cursor.getInt(cursor
                        .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                String number=null;
                String contactId = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.Contacts._ID));
                if (phoneCount > 0) {
                    // 获得联系人的电话号码
                    Cursor phones = mContext.getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID
                                    + " = " + contactId, null, null);
                    if (phones.moveToFirst()) {
                        number = phones
                                .getString(phones
                                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }
                    phones.close();
                }
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("name",name);
                hashMap.put("dayleft",number);
                hashMap.put("birthday","birthday");
                mData.add(hashMap);
            }while (cursor.moveToNext());
        }

    }

}
