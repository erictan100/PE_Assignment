package com.example.pe_assignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RewardExpiredFragment extends Fragment {

    RecyclerView expiredVoucher;
    RecyclerView.Adapter adapter;

    public RewardExpiredFragment () {
        // Required empty public constructor
    }

    public static RewardExpiredFragment newInstance (String param1, String param2) {
        RewardExpiredFragment fragment = new RewardExpiredFragment();
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_reward_rexpired, container, false);

        expiredVoucher = root.findViewById(R.id.recycleView_expiredVoucher);
        expiredVoucher();

        return root;
    }

    private void expiredVoucher () {

        expiredVoucher.setHasFixedSize(true);

        expiredVoucher.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        ArrayList<ExpiredVoucherHelper> expiredVoucherInfo = new ArrayList<>();

        expiredVoucherInfo.add(new ExpiredVoucherHelper("Baskin-Robbins RM3.10 cashback voucher! Min spend of RM31",
                "20 Sept - 20 Nov 2022","200 \n points"));

        adapter = new ExpiredVoucherAdapter(expiredVoucherInfo);

        expiredVoucher.setAdapter(adapter);
    }
}