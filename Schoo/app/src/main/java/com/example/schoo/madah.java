package com.example.schoo;

public class madah {
    String name;
    String color;
    String weeks;
   String date;
   String id;
   String FatherId;

    public madah() {
    }

    public madah(String name, String color, String weeks, String date, String id, String fatherId) {
        this.name = name;
        this.color = color;
        this.weeks = weeks;
        this.date = date;
        this.id = id;
        FatherId = fatherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFatherId() {
        return FatherId;
    }

    public void setFatherId(String fatherId) {
        FatherId = fatherId;
    }
}
