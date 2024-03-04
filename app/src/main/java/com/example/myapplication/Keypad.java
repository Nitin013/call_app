package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.ButtonBarLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Keypad extends Fragment {

    public Keypad(){

    }
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,caller_btn,back_space,v_call;
    TextView textView;
    String Number=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_keypad, container, false);
        init(rootView);

        Number=textView.getText().toString().trim();

        setBackground();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number += "1";
                textView.setText(Number);
                v_call.setVisibility(v.VISIBLE);
                back_space.setVisibility(v.VISIBLE);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number += "2";
                textView.setText(Number);
                v_call.setVisibility(v.VISIBLE);
                back_space.setVisibility(v.VISIBLE);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number += "3";
                textView.setText(Number);
                v_call.setVisibility(v.VISIBLE);
                back_space.setVisibility(v.VISIBLE);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number += "1";
                textView.setText(Number);
                v_call.setVisibility(v.VISIBLE);
                back_space.setVisibility(v.VISIBLE);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number += "5";
                textView.setText(Number);
                v_call.setVisibility(v.VISIBLE);
                back_space.setVisibility(v.VISIBLE);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number += "5";
                textView.setText(Number);
                v_call.setVisibility(v.VISIBLE);
                back_space.setVisibility(v.VISIBLE);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number += "7";
                textView.setText(Number);
                v_call.setVisibility(v.VISIBLE);
                back_space.setVisibility(v.VISIBLE);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number += "8";
                textView.setText(Number);
                v_call.setVisibility(v.VISIBLE);
                back_space.setVisibility(v.VISIBLE);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number += "9";
                textView.setText(Number);
                v_call.setVisibility(v.VISIBLE);
                back_space.setVisibility(v.VISIBLE);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number += "*";
                textView.setText(Number);
                v_call.setVisibility(v.VISIBLE);
                back_space.setVisibility(v.VISIBLE);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number += "0";
                textView.setText(Number);
                v_call.setVisibility(v.VISIBLE);
                back_space.setVisibility(v.VISIBLE);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number += "#";
                textView.setText(Number);
                v_call.setVisibility(v.VISIBLE);
                back_space.setVisibility(v.VISIBLE);
            }
        });
        caller_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  call_number();
            }
        });

        back_space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(textView.getText().toString().length()>0) {
                    String temp = textView.getText().toString().substring(0, textView.getText().toString().length() - 1);
                    textView.setText(temp);
                    Number=temp;
                }
            }
        });
        return  rootView;
    }

    private void call_number() {
       if(Number.length()!=0) {
           Toast.makeText(getContext(), "nitin", Toast.LENGTH_SHORT).show();
           if (getContext() != null && getContext().checkCallingOrSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
               String phone_number = "tel:" + Number;
               Intent callIntent = new Intent(Intent.ACTION_CALL);
               callIntent.setData(Uri.parse(phone_number));
               startActivity(callIntent);
           } else {
               ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CALL_PHONE}, 123);
           }
       }
       else{
           Toast.makeText(getContext(), "Enter a number", Toast.LENGTH_SHORT).show();;
       }
    }

    public void init(View rootView){
        textView=rootView.findViewById(R.id.textView);
        btn1=rootView.findViewById(R.id.button1);
        btn2=rootView.findViewById(R.id.button2);
        btn3=rootView.findViewById(R.id.button3);
        btn4=rootView.findViewById(R.id.button4);
        btn5=rootView.findViewById(R.id.button5);
        btn6=rootView.findViewById(R.id.button6);
        btn7=rootView.findViewById(R.id.button7);
        btn8=rootView.findViewById(R.id.button8);
        btn9=rootView.findViewById(R.id.button9);
        btn10=rootView.findViewById(R.id.button10);
        btn11=rootView.findViewById(R.id.button11);
        btn12=rootView.findViewById(R.id.button12);
        caller_btn=rootView.findViewById(R.id.caller_button);
        v_call=rootView.findViewById(R.id.v_call);
        back_space=rootView.findViewById(R.id.erase);

    }
    public  void setBackground(){
        btn1.setBackgroundColor(0xFF000000);
        btn2.setBackgroundColor(0xFF000000);
        btn3.setBackgroundColor(0xFF000000);
        btn4.setBackgroundColor(0xFF000000);
        btn5.setBackgroundColor(0xFF000000);
        btn6.setBackgroundColor(0xFF000000);
        btn7.setBackgroundColor(0xFF000000);
        btn8.setBackgroundColor(0xFF000000);
        btn9.setBackgroundColor(0xFF000000);
        btn10.setBackgroundColor(0xFF000000);
        btn11.setBackgroundColor(0xFF000000);
        btn12.setBackgroundColor(0xFF000000);
        caller_btn.setBackgroundColor(0xFF000000);
        v_call.setBackgroundColor(0xFF000000);
        back_space.setBackgroundColor(0xFF000000);
        v_call.setVisibility(v_call.INVISIBLE);
        back_space.setVisibility(back_space.INVISIBLE);

    }


}