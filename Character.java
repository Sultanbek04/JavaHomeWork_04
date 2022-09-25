package com.google.lesson_04;

public abstract class Character {
    private int HP; //Ctrl + D
    private int Damage;

    private int damageOfPoison=0;

    public int getDamageOfPoison() {
        return damageOfPoison;
    }

    public void setDamageOfPoison(int damageOfPoison) {
        this.damageOfPoison = damageOfPoison;
    }

    public Character() {
    }

    public Character(int HP, int Damage) {
        this.HP = HP;
        this.Damage = Damage;
    }

    public int getHP() {
        return HP;
    }

    public abstract String showRace();





    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }
}
