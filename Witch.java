package com.google.lesson_04;

public class Witch extends Character {
    private int poison;
    public Witch(int HP, int Damage, int poison) {
        super(HP, Damage);
        this.poison=poison;
    }

    @Override
    public String showRace() {
        return "Witch";
    }

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }
}
