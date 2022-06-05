package com.example.pe_assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VaccineInfoAdapter extends RecyclerView.Adapter<VaccineInfoAdapter.VaccineInfoViewHolder>{

    List<VaccineInfoItem> vaccineInfoItems;

    public VaccineInfoAdapter(List<VaccineInfoItem> vaccineInfoItems) {
        this.vaccineInfoItems = vaccineInfoItems;
    }

    @NonNull
    @Override
    public VaccineInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VaccineInfoViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_vaccine_info, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull VaccineInfoViewHolder holder, int position) {

        holder.setOnboardingData(vaccineInfoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return vaccineInfoItems.size();
    }

    class VaccineInfoViewHolder extends RecyclerView.ViewHolder{

        TextView title, manufacturer, description;
        ImageView vaccineOnboarding;

        public VaccineInfoViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.info_title);
            manufacturer = itemView.findViewById(R.id.info_manufacturer);
            description = itemView.findViewById(R.id.info_description);
            vaccineOnboarding = itemView.findViewById(R.id.info_img);
        }

        void setOnboardingData(VaccineInfoItem vaccineInfoItem){

            title.setText(vaccineInfoItem.getTitle());
            manufacturer.setText(vaccineInfoItem.getManufacturer());
            description.setText(vaccineInfoItem.getDescription());
            vaccineOnboarding.setImageResource(vaccineInfoItem.getImage());

        }
    }
}
