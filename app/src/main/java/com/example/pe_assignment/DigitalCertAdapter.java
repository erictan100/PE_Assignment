package com.example.pe_assignment;

import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DigitalCertAdapter extends RecyclerView.Adapter<DigitalCertAdapter.DigitalCertViewHolder>{

    ArrayList<DigitalCertHelper> digitalCert;

    public DigitalCertAdapter(ArrayList<DigitalCertHelper> digitalCert){
        this.digitalCert = digitalCert;
    }

    @NonNull
    @Override
    public DigitalCertViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.digital_cert_item,parent,false);
        DigitalCertViewHolder digitalCertViewHolder = new DigitalCertViewHolder(view);
        return digitalCertViewHolder;
    }

    @Override
    public void onBindViewHolder (@NonNull DigitalCertViewHolder holder, int position) {
        DigitalCertHelper digitalCertHelper = digitalCert.get(position);

        holder.DoseNo.setText(digitalCertHelper.getDoseNo());
        holder.Date.setText(digitalCertHelper.getDate());
        holder.Time.setText(digitalCertHelper.getTime());
        holder.VaccineType.setText(digitalCertHelper.getVaccineType());
        holder.Facility.setText(digitalCertHelper.getFacility());
        holder.BatchNumber.setText(digitalCertHelper.getBatchNumber());
    }

    @Override
    public int getItemCount () {
        return digitalCert.size();
    }

    public class DigitalCertViewHolder extends RecyclerView.ViewHolder {

        TextView DoseNo, Date, Time, VaccineType, Facility, BatchNumber;

        public DigitalCertViewHolder (@NonNull View itemView) {
            super(itemView);

            DoseNo = itemView.findViewById(R.id.cert_doseNumber);
            Date = itemView.findViewById(R.id.cert_doseDate);
            Time = itemView.findViewById(R.id.cert_doseTime);
            VaccineType = itemView.findViewById(R.id.cert_doseVacType);
            Facility = itemView.findViewById(R.id.cert_doseFacility);
            BatchNumber = itemView.findViewById(R.id.cert_doseBatch);
        }
    }

}

