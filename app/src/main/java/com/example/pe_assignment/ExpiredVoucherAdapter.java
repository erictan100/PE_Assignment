package com.example.pe_assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpiredVoucherAdapter extends RecyclerView.Adapter<ExpiredVoucherAdapter.ExpiredVoucherViewHolder> {

    ArrayList<ExpiredVoucherHelper> expiredVoucher;

    public ExpiredVoucherAdapter(ArrayList<ExpiredVoucherHelper> expiredVoucher){
        this.expiredVoucher = expiredVoucher;
    }

    @NonNull
    @Override
    public ExpiredVoucherViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expired_item,parent,false);
        ExpiredVoucherViewHolder expiredVoucherHolder = new ExpiredVoucherViewHolder(view);
        return expiredVoucherHolder;
    }

    @Override
    public void onBindViewHolder (@NonNull ExpiredVoucherViewHolder holder, int position) {
        ExpiredVoucherHelper expiredVoucherHelper = expiredVoucher.get(position);

        holder.redeemed_details.setText(expiredVoucherHelper.getRedeemed_details());
        holder.redeemed_duration.setText(expiredVoucherHelper.getRedeemed_duration());
        holder.redeemed_points.setText(expiredVoucherHelper.getRedeemed_points());
    }

    @Override
    public int getItemCount () {
        return expiredVoucher.size();
    }

    public class ExpiredVoucherViewHolder extends RecyclerView.ViewHolder {

        TextView redeemed_details, redeemed_duration, redeemed_points;

        public ExpiredVoucherViewHolder (@NonNull View itemView) {
            super(itemView);

            redeemed_details = itemView.findViewById(R.id.redeemed_details);
            redeemed_duration = itemView.findViewById(R.id.redeemed_duration);
            redeemed_points = itemView.findViewById(R.id.redeemed_points);
        }
    }
}
