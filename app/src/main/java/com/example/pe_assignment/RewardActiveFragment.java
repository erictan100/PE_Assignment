package com.example.pe_assignment;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class RewardActiveFragment extends Fragment {

    public TextView redemptionCount1, redemptionCount2, redemptionCount3, redemptionCount4;
    public AppCompatButton btnRedeem1, btnRedeem2, btnRedeem3, btnRedeem4;
    public ScrollView scrollView;

    public int totalPoints;
    public static int redeemPoint1 = 200, redeemPoint2 = 300, redeemPoint3 = 400, redeemPoint4 = 300;
    public static int redeemCount1 = 2, redeemCount2 = 3, redeemCount3 = 2, redeemCount4 = 3, redeemCount5 = 1;

    public RewardActiveFragment () {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RewardActiveFragment newInstance (String param1, String param2) {
        RewardActiveFragment fragment = new RewardActiveFragment();

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
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_reward_active, container, false);

        scrollView = root.findViewById(R.id.scrollViewReward);
        scrollView.fullScroll(View.FOCUS_DOWN);
        scrollView.setSmoothScrollingEnabled(true);

        redemptionCount1 = root.findViewById(R.id.redemption_count1);
        redemptionCount2 = root.findViewById(R.id.redemption_count2);
        redemptionCount3 = root.findViewById(R.id.redemption_count3);
        redemptionCount4 = root.findViewById(R.id.redemption_count4);

        btnRedeem1 = root.findViewById(R.id.btn_redeem1);
        btnRedeem2 = root.findViewById(R.id.btn_redeem2);
        btnRedeem3 = root.findViewById(R.id.btn_redeem3);
        btnRedeem4 = root.findViewById(R.id.btn_redeem4);

        redemptionCount1.setText(("Redemption(s) Left: ") + String.valueOf(redeemCount1));
        redemptionCount2.setText(("Redemption(s) Left: ") + String.valueOf(redeemCount2));
        redemptionCount3.setText(("Redemption(s) Left: ") + String.valueOf(redeemCount3));
        redemptionCount4.setText(("Redemption(s) Left: ") + String.valueOf(redeemCount4));

        btnRedeem1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick (View view) {
                totalPoints = ((MyRewardActivity) getActivity()).getTotalPoints();
                Boolean result = checkRedemption(totalPoints, redeemPoint1, redeemCount1);
                if(result)
                {
                    redeemCount1--;
                    redemptionCount1.setText(("Redemption(s) Left: ") + String.valueOf(redeemCount1));
                    successRedeem();
                    if(redeemCount1 <= 0)
                    {
                        btnRedeem1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#59534848")));
                        btnRedeem1.setEnabled(false);
                    }
                }
            }
        });

        btnRedeem2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick (View view) {
                totalPoints = MyRewardActivity.getTotalPoints();
                Boolean result = checkRedemption(totalPoints, redeemPoint2,redeemCount2);
                if(result)
                {
                    redeemCount2--;
                    redemptionCount2.setText(("Redemption(s) Left: ") + String.valueOf(redeemCount2));
                    successRedeem();
                    if(redeemCount2 <= 0)
                    {
                        btnRedeem2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#59534848")));
                        btnRedeem2.setEnabled(false);
                    }
                }
            }
        });

        btnRedeem3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick (View view) {
                totalPoints = MyRewardActivity.getTotalPoints();
                Boolean result = checkRedemption(totalPoints, redeemPoint3,redeemCount3);
                if(result)
                {
                    redeemCount3--;
                    redemptionCount3.setText(("Redemption(s) Left: ") + String.valueOf(redeemCount3));
                    successRedeem();
                    if(redeemCount3 <= 0)
                    {
                        btnRedeem3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#59534848")));
                        btnRedeem3.setEnabled(false);
                    }
                }
            }
        });

        btnRedeem4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick (View view) {
                totalPoints = MyRewardActivity.getTotalPoints();
                Boolean result = checkRedemption(totalPoints, redeemPoint4,redeemCount4);
                if(result)
                {
                    redeemCount4--;
                    redemptionCount4.setText(("Redemption(s) Left: ") + String.valueOf(redeemCount4));
                    successRedeem();
                    if(redeemCount4 <= 0)
                    {
                        btnRedeem4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#59534848")));
                        btnRedeem4.setEnabled(false);
                    }
                }
            }
        });

        return root;
    }

    public Boolean checkRedemption(int currentTotalPoints, int rewardPoints, int redeemCountLeft)
    {
        if (redeemCountLeft > 0 && currentTotalPoints >= rewardPoints)
        {
            totalPoints = currentTotalPoints - rewardPoints;
            MyRewardActivity.setTotalPoint(totalPoints);
            return true;
        }
        else
        {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
            alertDialog
                    .setTitle("Sorry")
                    .setMessage("Your points is not enough to choose this rewards")
                    .setCancelable(true)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return false;
        }
    }

    public void successRedeem()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle("Successful")
                .setCancelable(true)
                .setMessage("Your voucher has successfully claimed. It will send to your mail box.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

}