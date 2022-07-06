package com.example.pe_assignment;

public class ExpiredVoucherHelper {

    String redeemed_details, redeemed_duration, redeemed_points;

    public ExpiredVoucherHelper(String redeemed_details, String redeemed_duration, String  redeemed_points)
    {
        this.redeemed_details = redeemed_details;
        this.redeemed_duration = redeemed_duration;
        this.redeemed_points = redeemed_points;
    }

    public String getRedeemed_details()
    {
        return redeemed_details;
    }

    public String getRedeemed_duration()
    {
        return redeemed_duration;
    }

    public String getRedeemed_points()
    {
        return redeemed_points;
    }

}
