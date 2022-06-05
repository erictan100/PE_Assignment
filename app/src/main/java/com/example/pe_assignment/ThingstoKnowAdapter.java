package com.example.pe_assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThingstoKnowAdapter extends RecyclerView.Adapter<ThingstoKnowAdapter.ThingstoKnowViewHolder> {

    ArrayList<ThingstoKnowHelperClass> thingstoKnow;

    public ThingstoKnowAdapter(ArrayList<ThingstoKnowHelperClass> thingstoKnow) {
        this.thingstoKnow = thingstoKnow;
    }

    @NonNull
    @Override
    public ThingstoKnowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.things_to_know_design, parent, false);
        ThingstoKnowViewHolder thingstoKnowViewHolder = new ThingstoKnowViewHolder(view);
        return thingstoKnowViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThingstoKnowViewHolder holder, int position) {

        ThingstoKnowHelperClass thingstoKnowHelperClass = thingstoKnow.get(position);
        holder.mainImage.setImageResource(thingstoKnowHelperClass.getMainImage());
        holder.logoImage.setImageResource(thingstoKnowHelperClass.getLogoImage());
        holder.author.setText(thingstoKnowHelperClass.getAuthor());
        holder.title.setText(thingstoKnowHelperClass.getTitle());
        holder.description.setText(thingstoKnowHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return thingstoKnow.size();
    }

    public static class ThingstoKnowViewHolder extends RecyclerView.ViewHolder {

        ImageView mainImage, logoImage;
        TextView author, title, description;

        public ThingstoKnowViewHolder(@NonNull View itemView) {
            super(itemView);

            mainImage = itemView.findViewById(R.id.img_things_to_know);
            logoImage = itemView.findViewById(R.id.things_to_know_author_logo);
            author = itemView.findViewById(R.id.things_to_know_author);
            title = itemView.findViewById(R.id.things_to_know_title);
            description = itemView.findViewById(R.id.things_to_know_description);
        }
    }
}
