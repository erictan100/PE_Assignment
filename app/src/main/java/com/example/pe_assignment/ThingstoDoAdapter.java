package com.example.pe_assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThingstoDoAdapter extends RecyclerView.Adapter<ThingstoDoAdapter.ThingstoDoViewHolder>{

    ArrayList<ThingstoDoHelperClass> thingstoDo;

    public ThingstoDoAdapter(ArrayList<ThingstoDoHelperClass> thingstoDo) {
        this.thingstoDo = thingstoDo;
    }

    @NonNull
    @Override
    public ThingstoDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.things_to_do_design, parent, false);
        ThingstoDoViewHolder thingstoDoViewHolder = new ThingstoDoViewHolder(view);
        return thingstoDoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThingstoDoViewHolder holder, int position) {

        ThingstoDoHelperClass thingstoDoHelperClass = thingstoDo.get(position);
        holder.image.setImageResource(thingstoDoHelperClass.getImage());
        holder.title.setText(thingstoDoHelperClass.getTitle());
        holder.description.setText(thingstoDoHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return thingstoDo.size();
    }

    public static class ThingstoDoViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, description;

        public ThingstoDoViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img_things_to_do);
            title = itemView.findViewById(R.id.things_to_do_title);
            description = itemView.findViewById(R.id.things_to_do_description);
        }
    }
}
