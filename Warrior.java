package com.google.lesson_04;

public class Warrior extends Character {
    public Warrior(int HP, int Damage) {
        super(HP, Damage);
    }

    @Override
    public String showRace() {
        return "Warrior";
    }
}
