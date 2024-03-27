package com.example.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.CallLog;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Recents#} factory method to
 * create an instance of this fragment.
 */
public class Recents extends Fragment {


    public Recents() {

        // Required empty public constructor
    }
    RecyclerView Recycler_recent;
    ArrayList<contact_model> recentList=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_recents,container,false);
        Recycler_recent=rootView.findViewById(R.id.RecyclerView_recents);
        fetchRecentCalls();

        Recycler_adapter adapter=new Recycler_adapter(getContext(),recentList);
        Recycler_recent.setLayoutManager(new LinearLayoutManager(getContext()));
        Recycler_recent.setAdapter(adapter);

        return rootView;
    }
    private void fetchRecentCalls(){
        ContentResolver contentResolver=requireActivity().getContentResolver();
        String[] projection = {
                CallLog.Calls._ID,
                CallLog.Calls.NUMBER,
                CallLog.Calls.DATE,
                CallLog.Calls.DURATION,
                CallLog.Calls.TYPE
        };

        String selection = null;
        String [] selectionArgs = null;
        String sortOrder = CallLog.Calls.DATE+" DESC";
        Cursor cursor=contentResolver.query(CallLog.Calls.CONTENT_URI,projection,selection,selectionArgs,sortOrder);
        if(cursor!=null){
            try{
                while(cursor.moveToNext()){
                    int numbe = cursor.getColumnIndex(CallLog.Calls.NUMBER);
                    int dat=cursor.getColumnIndex(CallLog.Calls.DATE);
                    int typ= cursor.getColumnIndex(CallLog.Calls.TYPE);
                    String number = cursor.getString(numbe);
                    long date= cursor.getLong(dat);
                    int type=cursor.getInt(typ);
                    recentList.add(new contact_model(R.drawable.caller_button,number,Integer.toString(type)));
                }
            } finally {
                cursor.close();
            }
        }
    }
}