package com.example.pe_assignment.initialFragment.stat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Statistics {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("cases_new")
    @Expose
    private String casesNew;
    @SerializedName("cases_import")
    @Expose
    private String casesImport;
    @SerializedName("cases_recovered")
    @Expose
    private String casesRecovered;
    @SerializedName("cases_active")
    @Expose
    private String casesActive;
    @SerializedName("cases_cluster")
    @Expose
    private String casesCluster;
    @SerializedName("cases_unvax")
    @Expose
    private String casesUnvax;
    @SerializedName("cases_pvax")
    @Expose
    private String casesPvax;
    @SerializedName("cases_fvax")
    @Expose
    private String casesFvax;
    @SerializedName("cases_boost")
    @Expose
    private String casesBoost;
    @SerializedName("cases_child")
    @Expose
    private String casesChild;
    @SerializedName("cases_adolescent")
    @Expose
    private String casesAdolescent;
    @SerializedName("cases_adult")
    @Expose
    private String casesAdult;
    @SerializedName("cases_elderly")
    @Expose
    private String casesElderly;
    @SerializedName("cases_0_4")
    @Expose
    private String cases04;
    @SerializedName("cases_5_11")
    @Expose
    private String cases511;
    @SerializedName("cases_12_17")
    @Expose
    private String cases1217;
    @SerializedName("cases_18_29")
    @Expose
    private String cases1829;
    @SerializedName("cases_30_39")
    @Expose
    private String cases3039;
    @SerializedName("cases_40_49")
    @Expose
    private String cases4049;
    @SerializedName("cases_50_59")
    @Expose
    private String cases5059;
    @SerializedName("cases_60_69")
    @Expose
    private String cases6069;
    @SerializedName("cases_70_79")
    @Expose
    private String cases7079;
    @SerializedName("cases_80")
    @Expose
    private String cases80;
    @SerializedName("cluster_import")
    @Expose
    private String clusterImport;
    @SerializedName("cluster_religious")
    @Expose
    private String clusterReligious;
    @SerializedName("cluster_community")
    @Expose
    private String clusterCommunity;
    @SerializedName("cluster_highRisk")
    @Expose
    private String clusterHighRisk;
    @SerializedName("cluster_education")
    @Expose
    private String clusterEducation;
    @SerializedName("cluster_detentionCentre")
    @Expose
    private String clusterDetentionCentre;
    @SerializedName("cluster_workplace")
    @Expose
    private String clusterWorkplace;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCasesNew() {
        return casesNew;
    }

    public void setCasesNew(String casesNew) {
        this.casesNew = casesNew;
    }

    public String getCasesImport() {
        return casesImport;
    }

    public void setCasesImport(String casesImport) {
        this.casesImport = casesImport;
    }

    public String getCasesRecovered() {
        return casesRecovered;
    }

    public void setCasesRecovered(String casesRecovered) {
        this.casesRecovered = casesRecovered;
    }

    public String getCasesActive() {
        return casesActive;
    }

    public void setCasesActive(String casesActive) {
        this.casesActive = casesActive;
    }

    public String getCasesCluster() {
        return casesCluster;
    }

    public void setCasesCluster(String casesCluster) {
        this.casesCluster = casesCluster;
    }

    public String getCasesUnvax() {
        return casesUnvax;
    }

    public void setCasesUnvax(String casesUnvax) {
        this.casesUnvax = casesUnvax;
    }

    public String getCasesPvax() {
        return casesPvax;
    }

    public void setCasesPvax(String casesPvax) {
        this.casesPvax = casesPvax;
    }

    public String getCasesFvax() {
        return casesFvax;
    }

    public void setCasesFvax(String casesFvax) {
        this.casesFvax = casesFvax;
    }

    public String getCasesBoost() {
        return casesBoost;
    }

    public void setCasesBoost(String casesBoost) {
        this.casesBoost = casesBoost;
    }

    public String getCasesChild() {
        return casesChild;
    }

    public void setCasesChild(String casesChild) {
        this.casesChild = casesChild;
    }

    public String getCasesAdolescent() {
        return casesAdolescent;
    }

    public void setCasesAdolescent(String casesAdolescent) {
        this.casesAdolescent = casesAdolescent;
    }

    public String getCasesAdult() {
        return casesAdult;
    }

    public void setCasesAdult(String casesAdult) {
        this.casesAdult = casesAdult;
    }

    public String getCasesElderly() {
        return casesElderly;
    }

    public void setCasesElderly(String casesElderly) {
        this.casesElderly = casesElderly;
    }

    public String getCases04() {
        return cases04;
    }

    public void setCases04(String cases04) {
        this.cases04 = cases04;
    }

    public String getCases511() {
        return cases511;
    }

    public void setCases511(String cases511) {
        this.cases511 = cases511;
    }

    public String getCases1217() {
        return cases1217;
    }

    public void setCases1217(String cases1217) {
        this.cases1217 = cases1217;
    }

    public String getCases1829() {
        return cases1829;
    }

    public void setCases1829(String cases1829) {
        this.cases1829 = cases1829;
    }

    public String getCases3039() {
        return cases3039;
    }

    public void setCases3039(String cases3039) {
        this.cases3039 = cases3039;
    }

    public String getCases4049() {
        return cases4049;
    }

    public void setCases4049(String cases4049) {
        this.cases4049 = cases4049;
    }

    public String getCases5059() {
        return cases5059;
    }

    public void setCases5059(String cases5059) {
        this.cases5059 = cases5059;
    }

    public String getCases6069() {
        return cases6069;
    }

    public void setCases6069(String cases6069) {
        this.cases6069 = cases6069;
    }

    public String getCases7079() {
        return cases7079;
    }

    public void setCases7079(String cases7079) {
        this.cases7079 = cases7079;
    }

    public String getCases80() {
        return cases80;
    }

    public void setCases80(String cases80) {
        this.cases80 = cases80;
    }

    public String getClusterImport() {
        return clusterImport;
    }

    public void setClusterImport(String clusterImport) {
        this.clusterImport = clusterImport;
    }

    public String getClusterReligious() {
        return clusterReligious;
    }

    public void setClusterReligious(String clusterReligious) {
        this.clusterReligious = clusterReligious;
    }

    public String getClusterCommunity() {
        return clusterCommunity;
    }

    public void setClusterCommunity(String clusterCommunity) {
        this.clusterCommunity = clusterCommunity;
    }

    public String getClusterHighRisk() {
        return clusterHighRisk;
    }

    public void setClusterHighRisk(String clusterHighRisk) {
        this.clusterHighRisk = clusterHighRisk;
    }

    public String getClusterEducation() {
        return clusterEducation;
    }

    public void setClusterEducation(String clusterEducation) {
        this.clusterEducation = clusterEducation;
    }

    public String getClusterDetentionCentre() {
        return clusterDetentionCentre;
    }

    public void setClusterDetentionCentre(String clusterDetentionCentre) {
        this.clusterDetentionCentre = clusterDetentionCentre;
    }

    public String getClusterWorkplace() {
        return clusterWorkplace;
    }

    public void setClusterWorkplace(String clusterWorkplace) {
        this.clusterWorkplace = clusterWorkplace;
    }
}

