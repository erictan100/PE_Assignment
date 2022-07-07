package com.example.pe_assignment.HelperClass;

public class ScheduleVaccineHelperClass {

    String name, ic, date, location;

    public ScheduleVaccineHelperClass() {
    }

    public ScheduleVaccineHelperClass(String name, String ic, String date, String location) {
        this.name = name;
        this.ic = ic;
        this.date = date;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
