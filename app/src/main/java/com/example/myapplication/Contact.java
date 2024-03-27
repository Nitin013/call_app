package com.example.myapplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class Contact extends Fragment {


    public Contact() {
        // Required empty public constructor
    }
    ArrayList<contact_model> contact_list=new ArrayList<>();
    RecyclerView recycler_contact;
    String Number=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_contact, container, false);
        fetchContacts();

        recycler_contact=rootView.findViewById(R.id.Recycler_contact);
        Recycler_adapter adapter=new Recycler_adapter(getContext(),contact_list);
        recycler_contact.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler_contact.setAdapter(adapter);
        return rootView ;
    }
    private void fetchContacts() {
        ContentResolver contentResolver = getContext().getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        if (cursor != null) {
            try {
                int columnIndexDisplayName = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                int columnIndexPhoneNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

                while (cursor.moveToNext()) {
                    String contactName = cursor.getString(columnIndexDisplayName);
                    String phoneNumber = cursor.getString(columnIndexPhoneNumber);

                    contact_list.add(new contact_model(R.drawable.caller_button, contactName, phoneNumber));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                cursor.close();
            }
        } else {
            // Handle case when cursor is null
            Log.e("FetchContacts", "Cursor is null");
        }
    }
}