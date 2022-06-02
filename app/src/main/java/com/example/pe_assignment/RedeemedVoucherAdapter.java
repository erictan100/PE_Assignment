package com.example.pe_assignment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class RedeemedVoucherAdapter extends FragmentStateAdapter {

    public RedeemedVoucherAdapter (@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment (int position) {

        Fragment fragment = null;

        if(position == 0)
            fragment = new RewardActiveFragment();
        else if (position == 1)
            fragment = new RewardRedeemedFragment();

        return fragment;
    }

    @Override
    public int getItemCount () {
        return 2;
    }
}
