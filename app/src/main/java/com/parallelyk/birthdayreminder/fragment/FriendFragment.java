package com.parallelyk.birthdayreminder.fragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parallelyk.birthdayreminder.R;
import com.parallelyk.birthdayreminder.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FriendFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FriendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FriendFragment extends MainFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    private MainAdapter adapter;
    private RecyclerView mRecyclerView;
    private Context mContext;
    private ArrayList<HashMap<String,Object>> mData = new ArrayList<>();
    public FriendFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FriendFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FriendFragment newInstance(String param1, String param2) {
        FriendFragment fragment = new FriendFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mContext = getContext();
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        init(view);
        sendRemind();
        return view;
    }

    private void init(View view){
        getData();
        adapter = new MainAdapter(mContext,mData);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.friend_listview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(adapter);
    }

    private void getData(){
        mData.clear();
        for(int i = 0;i<20;i++){
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("name","名字"+i);
            hashMap.put("dayleft","还有xx天生日"+i);
            hashMap.put("birthday","公历6月6日"+i);
            mData.add(hashMap);
        }
    }

    private void sendRemind(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,04,27,16,16);
        Intent intent = new Intent("com.BirthdayReminder.birthday_Remind");
        PendingIntent pi=PendingIntent.getBroadcast(getActivity(), 0, intent,0);
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
        //alarmManager.set(AlarmManager.RTC_WAKEUP,10000,pi);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
