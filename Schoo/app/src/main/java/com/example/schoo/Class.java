package com.example.schoo;

import java.io.Serializable;

public class Class implements Serializable {
    private String name;

    private int attack;
    private int defence;
    private int total;

    public Class(String name,  int attack, int defence, int total) {
        this.name = name;

        this.attack = attack;
        this.defence = defence;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
