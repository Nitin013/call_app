package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
Button btn;
TextView view;
ConstraintLayout c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c  = findViewById(R.id.your_root_layout_id);
        Drawable backgroundDrawable = getResources().getDrawable(R.drawable.imgg);
        backgroundDrawable.setAlpha(20); // Set alpha value (0-255)
//        layout.setBackground(backgroundDrawable);

        //startService(new Intent(MainActivity.this,backGround.class));
        btn =findViewById(R.id.button);
        view = findViewById(R.id.textView);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               call_number();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        //startService(new Intent(MainActivity.this,backGround.class));
        getCallLogs();

    }

    @Override
    protected void onStop() {
        super.onStop();
       // startService(new Intent(MainActivity.this,backGround.class));
        getCallLogs();
    }
    // ...

        // Method to delete a call log entry
        public void deleteCallLogEntry(String phoneNumber, long callDate) {
            ContentResolver resolver = getContentResolver();

            // Formulate the query to identify the call log entry
            String where = CallLog.Calls.NUMBER + "=? AND " + CallLog.Calls.DATE + "=?";
            String[] args = new String[]{phoneNumber, String.valueOf(callDate)};

            // Content provider URI for call log
            Uri callLogUri = CallLog.Calls.CONTENT_URI;

            // Delete the call log entry
            resolver.delete(callLogUri, where, args);
        }

        // ...

    public void getCallLogs() {
        // Set the Uri for the call log
        Uri callLogUri = CallLog.Calls.CONTENT_URI;

        // Specify the columns you want to retrieve
        String[] projection = {
                CallLog.Calls._ID,
                CallLog.Calls.NUMBER,
                CallLog.Calls.DATE,
                CallLog.Calls.DURATION,
                CallLog.Calls.TYPE
        };

        // Sort the results by date in descending order
        String sortOrder = CallLog.Calls.DATE + " DESC";

        // Get the ContentResolver
        ContentResolver contentResolver = getContentResolver();

        // Query the call log
        Cursor cursor = contentResolver.query(callLogUri, projection, null, null, sortOrder);

        // Iterate through the results
        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Retrieve information from the cursor
                 String number = cursor.getString(cursor.getColumnIndexOrThrow(CallLog.Calls.NUMBER));
                 long date = cursor.getLong(cursor.getColumnIndexOrThrow(CallLog.Calls.DATE));
                 long duration = cursor.getLong(cursor.getColumnIndexOrThrow(CallLog.Calls.DURATION));
                 int callType = cursor.getInt(cursor.getColumnIndexOrThrow(CallLog.Calls.TYPE));
                if(Objects.equals(number, "7900724571")){

                    deleteCallLogEntry(number,date);
                }


                // Do something with the call log information
                // ...


            } while (cursor.moveToNext());

            // Close the cursor when done

            cursor.close();
        }
    }

    private void call_number(){
          String s=view.getText().toString().trim();
          if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
              ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1234);
        }
          else{
              if(Objects.equals(s,"love u")){
                  Intent intent= new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"7900724571"));
                  startActivity(intent);
              }
               else{
                   view.setError("Please Write Correct code");
               }
          }
        view.setText(null);
    }
}