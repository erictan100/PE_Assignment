package com.example.pe_assignment;

public class DigitalCertHelper {

    String DoseNo, Date, Time, VaccineType, Facility, BatchNumber;

    public DigitalCertHelper(String DoseNo, String Date,String Time,String VaccineType,String Facility,String BatchNumber)
    {
        this.DoseNo = DoseNo;
        this.Date = Date;
        this.Time = Time;
        this.VaccineType = VaccineType;
        this.Facility = Facility;
        this.BatchNumber = BatchNumber;
    }

    public String getDoseNo(){
        return DoseNo;
    }

    public String getDate(){
        return Date;
    }

    public String getTime(){
        return Time;
    }

    public String getVaccineType(){
        return VaccineType;
    }

    public String getFacility(){
        return Facility;
    }

    public String getBatchNumber(){
        return BatchNumber;
    }
}
