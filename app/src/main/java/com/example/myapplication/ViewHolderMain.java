package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ViewHolderMain extends RecyclerView.ViewHolder {
    private TextView textViewName;
    private TextView textViewGroup;

    ViewHolderMain(@NonNull View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.vh_tv_name);
        textViewGroup = itemView.findViewById(R.id.vh_th_group);
    }

    void onBind(Student s){
        this.textViewName.setText(s.getName());
        this.textViewGroup.setText(s.getGroup());
    }
}
