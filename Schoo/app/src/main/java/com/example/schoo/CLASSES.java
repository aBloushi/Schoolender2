package com.example.schoo;

import java.util.Date;

public class CLASSES {
    Date Time;
    String Name;

    public CLASSES(Date time, String name) {
        Time = time;
        Name = name;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
