package com.example.pe_assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AppFeaturesAdapter extends RecyclerView.Adapter<AppFeaturesAdapter.AppFeaturesViewHolder> {

    ArrayList<AppFeaturesHelperClass> appFeatures;

    public AppFeaturesAdapter(ArrayList<AppFeaturesHelperClass> appFeatures) {
        this.appFeatures = appFeatures;
    }

    @NonNull
    @Override
    public AppFeaturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_features_design, parent, false);
        AppFeaturesViewHolder appFeaturesViewHolder = new AppFeaturesViewHolder(view);
        return appFeaturesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AppFeaturesViewHolder holder, int position) {

        AppFeaturesHelperClass appFeaturesHelperClass = appFeatures.get(position);
        holder.image.setImageResource(appFeaturesHelperClass.getImage());
        holder.description.setText(appFeaturesHelperClass.getTitle());
    }

    @Override
    public int getItemCount() {
        return appFeatures.size();
    }

    public static class AppFeaturesViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView description;

        public AppFeaturesViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.appfeatured_image);
            description = itemView.findViewById(R.id.appfeatured_title);
        }
    }


}
