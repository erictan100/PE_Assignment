package com.example.pe_assignment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DigitalCertAdapter extends RecyclerView.Adapter<DigitalCertAdapter.DigitalCertViewHolder>{
    @NonNull
    @Override
    public DigitalCertViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder (@NonNull DigitalCertViewHolder holder, int position) {

    }

    @Override
    public int getItemCount () {
        return 0;
    }

    public class DigitalCertViewHolder extends RecyclerView.ViewHolder {
        public DigitalCertViewHolder (@NonNull View itemView) {
            super(itemView);
        }
    }

}

