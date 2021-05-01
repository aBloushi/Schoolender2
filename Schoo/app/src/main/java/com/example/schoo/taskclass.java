package com.example.schoo;

public class taskclass {

    String name;
    String date;
    String FatherId;

    public taskclass() {

    }

    public taskclass(String name, String date, String fatherId) {
        this.name = name;
        this.date = date;
        FatherId = fatherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFatherId() {
        return FatherId;
    }

    public void setFatherId(String fatherId) {
        FatherId = fatherId;
    }
}
