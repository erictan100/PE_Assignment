package com.example.pe_assignment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HomeTabAdapter extends FragmentStateAdapter {

    int totalTabs;

    public HomeTabAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, int totalTabs) {
        super(fragmentManager, lifecycle);
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                ThingstoKnowFragment thingstoKnowFragment = new ThingstoKnowFragment();
                return thingstoKnowFragment;

            case 1:
                ThingstoDoFragment thingstoDoFragment = new ThingstoDoFragment();
                return thingstoDoFragment;

            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return totalTabs;
    }
}
