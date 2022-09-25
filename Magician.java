package com.google.lesson_04;

public class Magician extends Character {
    private int heal;

    public Magician(int HP, int Damage, int heal) {
        super(HP, Damage);
        this.heal=heal;
    }

    @Override
    public String showRace() {
        return "Magician";
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }
}
