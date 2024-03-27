package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Recycler_adapter extends RecyclerView.Adapter<Recycler_adapter.ViewHolder> {
    Context context;
    ArrayList<contact_model> arrayList;
    Recycler_adapter(Context context, ArrayList<contact_model> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.contact_card,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                 holder.img.setImageResource(arrayList.get(position).img);
                 holder.name.setText(arrayList.get(position).name);
                 holder.number.setText(arrayList.get(position).number);
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView name,number;
    ImageView img;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.name);
        number=itemView.findViewById(R.id.number);
        img=itemView.findViewById(R.id.Contact_image);
    }
}
}
