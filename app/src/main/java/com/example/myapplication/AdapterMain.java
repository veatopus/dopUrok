package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMain extends RecyclerView.Adapter {
    private ArrayList<Student> data = new ArrayList<>();

    void add(Student student){
        data.add(student);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.main_view_holder, parent, false);
        return new ViewHolderMain(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolderMain) holder).onBind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
