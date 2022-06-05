package com.example.pe_assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnBoardingAdapter extends RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>{

    List<OnBoardingItem> onBoardingItems;

    public OnBoardingAdapter(List<OnBoardingItem> onBoardingItems) {
        this.onBoardingItems = onBoardingItems;
    }

    @NonNull
    @Override
    public OnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnBoardingViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_container_onboarding, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingViewHolder holder, int position) {

        holder.setOnboardingData(onBoardingItems.get(position));
    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    class OnBoardingViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView imageOnboarding;

        public OnBoardingViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.intro_title);
            imageOnboarding = itemView.findViewById(R.id.intro_img);
        }

        void setOnboardingData(OnBoardingItem onBoardingItem){

            title.setText(onBoardingItem.getTitle());
            imageOnboarding.setImageResource(onBoardingItem.getImage());

        }
    }
}
