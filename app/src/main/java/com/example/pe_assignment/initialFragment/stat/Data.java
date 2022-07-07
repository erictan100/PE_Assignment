package com.example.pe_assignment.initialFragment.stat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;
    @SerializedName("confirmed")
    @Expose
    private int confirmed;
    @SerializedName("confirmed_diff")
    @Expose
    private int confirmedDiff;
    @SerializedName("deaths")
    @Expose
    private int deaths;
    @SerializedName("deaths_diff")
    @Expose
    private int deathsDiff;
    @SerializedName("recovered")
    @Expose
    private int recovered;
    @SerializedName("recovered_diff")
    @Expose
    private int recoveredDiff;
    @SerializedName("active")
    @Expose
    private int active;
    @SerializedName("active_diff")
    @Expose
    private int activeDiff;
    @SerializedName("fatality_rate")
    @Expose
    private double fatalityRate;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getConfirmedDiff() {
        return confirmedDiff;
    }

    public void setConfirmedDiff(int confirmedDiff) {
        this.confirmedDiff = confirmedDiff;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getDeathsDiff() {
        return deathsDiff;
    }

    public void setDeathsDiff(int deathsDiff) {
        this.deathsDiff = deathsDiff;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getRecoveredDiff() {
        return recoveredDiff;
    }

    public void setRecoveredDiff(int recoveredDiff) {
        this.recoveredDiff = recoveredDiff;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getActiveDiff() {
        return activeDiff;
    }

    public void setActiveDiff(int activeDiff) {
        this.activeDiff = activeDiff;
    }

    public double getFatalityRate() {
        return fatalityRate;
    }

    public void setFatalityRate(double fatalityRate) {
        this.fatalityRate = fatalityRate;
    }

}