package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.widget.ButtonBarLayout;
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




    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,caller_btn;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_keypad, container, false);
        init(rootView);

        return  rootView;
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
    }
    public void click(View view) {
        Button btn=(Button) view;
        String Number=textView.getText().toString();
        if(btn.getId()==btn1.getId()){
            Number=Number+"1";
            Toast.makeText(getActivity(),"rajut", Toast.LENGTH_SHORT).show();
        }
        if(btn.getId()==btn2.getId()){
            Number=Number+"2";
            textView.setText(Number);
        }
        if(btn.getId()==btn3.getId()){
            Number=Number+"3";
            textView.setText(Number);
        }
        if(btn.getId()==btn4.getId()){
            Number=Number+"4";
            textView.setText(Number);
        }
        if(btn.getId()==btn5.getId()){
            Number=Number+"5";
            textView.setText(Number);
        }
        if(btn.getId()==btn6.getId()){
            Number=Number+"6";
            textView.setText(Number);
        }
        if(btn.getId()==btn7.getId()){
            Number=Number+"7";
            textView.setText(Number);
        }
        if(btn.getId()==btn8.getId()){
            Number=Number+"8";
            textView.setText(Number);
        }
        if(btn.getId()==btn9.getId()){
            Number=Number+"9";
            textView.setText(Number);
        }
        if(btn.getId()==btn10.getId()){
            Number=Number+"*";
            textView.setText(Number);
        }
        if(btn.getId()==btn11.getId()){
            Number=Number+"0";
            textView.setText(Number);
        }
        if(btn.getId()==btn12.getId()){
            Number=Number+"#";
            textView.setText(Number);
        }
    }
}