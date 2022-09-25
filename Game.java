package com.google.lesson_04;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    private int warriorHP = 300;
    private int quantityOfCharacters = 3;
    private int magicianHP = 150;
    private int witchHP = 150;
    private int warriorDamage = random.nextInt(50, 80);
    private int magicianDamage = random.nextInt(151);
    private int witchDamage = random.nextInt(100);
    private int heal = random.nextInt(30, 50);
    private int poison = random.nextInt(10, 25);

    private int chosenTarget;
    private int chosenCharacter;
    private int plusPoison;

    private String name(int numberOfPlayer) {
        System.out.println("Please write your name player " + numberOfPlayer + ": ");
        return scanner.nextLine();
    }

    private void startingTheGame(Character[] characters, String nameOfPlayer) {
        System.out.println("Characters of " + nameOfPlayer + ": ");
        for (int i = 0; i < characters.length; i++) {
            System.out.println(characters[i].showRace() + " " + characters[i].getHP() + "HP");

        }
        System.out.println();
    }

    private int showingAndChoosingTarget(Character[] charactersOfEnemy) {
        System.out.println("Choose your target: ");
        for (int i = 0; i < quantityOfCharacters; i++) {
            System.out.println((i + 1) + " is:" +
                    charactersOfEnemy[i].showRace() + " " + charactersOfEnemy[i].getHP() + "HP");
        }
        return scanner.nextInt();
    }

    private void chooseOption(boolean isHeal, Character[] myCharacters, int indexOfCharacter, Character[]
            enemyCharacters) {
        if (isHeal == true) {
            this.chosenTarget = showingAndChoosingTarget(myCharacters) - 1;
            Magician mag = (Magician) myCharacters[indexOfCharacter];
            myCharacters[chosenTarget].setHP(myCharacters[chosenTarget].getHP() + mag.getHeal());
        } else {
            this.chosenTarget = showingAndChoosingTarget(enemyCharacters) - 1;
            Witch witch = (Witch) myCharacters[indexOfCharacter];
            enemyCharacters[chosenTarget].setHP(enemyCharacters[chosenTarget].getHP() - witch.getPoison());

        }
    }

    private void poisonStep(int quantityOfCharacters, Character[] characters, String nameOfPlayer) {
        for (int i = 0; i < quantityOfCharacters; i++) {
            if (characters[i].getDamageOfPoison() != 0) {
                System.out.println("-" + characters[i].getDamageOfPoison());
                characters[i].setHP(characters[i].getHP() - characters[i].getDamageOfPoison());
                System.out.println(nameOfPlayer + "'s " + characters[i].showRace() + " "
                        + characters[i].getHP());
            }
        }
    }


    private void attackingCharacter(String nameOfPlayer, String enemyName, int quantityOfCharacters,
                                    Character[] charactersOfEnemy, Character[] myCharacters) {

        System.out.println();
        System.out.println(nameOfPlayer + " Choose a character to attack: ");


        for (int i = 0; i < myCharacters.length; i++) {
            System.out.println((i + 1) + " is a " + myCharacters[i].showRace() + " " + myCharacters[i].getHP() + "HP");
            switch (myCharacters[i].showRace()) {
                case "Warrior":
                    myCharacters[i].setDamage(random.nextInt(30, 60));
                    break;
                case "Magician":
                    Magician magician = (Magician) myCharacters[i];
                    magician.setHeal(random.nextInt(20, 50));
                    magician.setDamage(random.nextInt(120));
                    myCharacters[i] = magician;
                    break;
                case "Witch":
                    Witch witch = (Witch) myCharacters[i];
                    witch.setPoison(random.nextInt(20, 50));
                    witch.setDamage(random.nextInt(150));
                    myCharacters[i] = witch;
                    break;
            }
        }

        chosenCharacter = scanner.nextInt() - 1;

        switch (myCharacters[chosenCharacter].showRace()) {
            case "Warrior":
                chosenTarget = showingAndChoosingTarget(charactersOfEnemy) - 1;

                charactersOfEnemy[chosenTarget].setHP(charactersOfEnemy[chosenTarget].getHP() -
                        myCharacters[chosenCharacter].getDamage());

                System.out.println("-" + myCharacters[chosenCharacter].getDamage());
                System.out.println(enemyName + "'s " + charactersOfEnemy[chosenTarget].showRace() + " " +
                        charactersOfEnemy[chosenTarget].getHP() + "HP");
                break;
            case "Magician":
                System.out.println("Write 1 if you want to heal or write 2 if you want to attack");
                switch (scanner.nextInt()) {
                    case 1:
                        chooseOption(true, myCharacters, chosenCharacter, charactersOfEnemy);
                        Magician magician = (Magician) myCharacters[chosenCharacter];
                        System.out.println("+" + ((Magician) myCharacters[chosenCharacter]).getHeal());
                        System.out.println(nameOfPlayer+ "'s " + myCharacters[this.chosenTarget].showRace() + " " +
                                myCharacters[chosenTarget].getHP() + "HP");
                        break;
                    case 2:
                        chosenTarget = showingAndChoosingTarget(charactersOfEnemy) - 1;

                        charactersOfEnemy[chosenTarget].setHP(charactersOfEnemy[chosenTarget].getHP() -
                                myCharacters[chosenCharacter].getDamage());

                        System.out.println("-" + myCharacters[chosenCharacter].getDamage());
                        System.out.println(enemyName + "'s " + charactersOfEnemy[chosenTarget].showRace() + " " +
                                charactersOfEnemy[chosenTarget].getHP() + "HP");
                        break;

                }
                break;
            case "Witch":
                System.out.println("Write 1 if you want to poison or write 2 if you want to attack");
                switch (scanner.nextInt()) {
                    case 1:
                        chooseOption(false, myCharacters, chosenCharacter, charactersOfEnemy);
                        Witch witch = (Witch) myCharacters[chosenCharacter];
                        charactersOfEnemy[chosenTarget].setDamageOfPoison(witch.getPoison()
                                + charactersOfEnemy[chosenTarget].getDamageOfPoison());
                        System.out.println("-" + witch.getPoison());
                        System.out.println(enemyName + "'s " + charactersOfEnemy[this.chosenTarget].showRace() + " " +
                                charactersOfEnemy[chosenTarget].getHP() + "HP");


                        break;
                    case 2:
                        chosenTarget = showingAndChoosingTarget(charactersOfEnemy) - 1;

                        charactersOfEnemy[chosenTarget].setHP(charactersOfEnemy[chosenTarget].getHP() -
                                myCharacters[chosenCharacter].getDamage());

                        System.out.println("-" + myCharacters[chosenCharacter].getDamage());
                        System.out.println(enemyName + "'s " + charactersOfEnemy[chosenTarget].showRace() + " " +
                                charactersOfEnemy[chosenTarget].getHP() + "HP");

                        break;
                }
                break;
        }
    }


    private Character[] characterChoosing(String nameOfPlayer, int quantityOfCharacters) {
        Character[] characters = new Character[quantityOfCharacters];
        int counter = 0;
        System.out.println(nameOfPlayer + " You can choose three characters: ");
        System.out.println("1 - is a warrior");
        System.out.println("2 - is a magician");
        System.out.println("3 - is a witch");
        for (int i = 1; i <= quantityOfCharacters; i++) {
            System.out.println("Choose your " + i + " character");
            int numberOfTheCharacter = scanner.nextInt();
            switch (numberOfTheCharacter) {
                case 1:
                    characters[counter] = new Warrior(warriorHP, warriorDamage);
                    ++counter;
                    break;
                case 2:
                    characters[counter] = new Magician(magicianHP, magicianDamage, heal);
                    ++counter;
                    break;
                case 3:
                    characters[counter] = new Witch(witchHP, witchDamage, poison);
                    ++counter;
                    break;
                default:
                    System.out.println("Please choose number from 1 to 3");
                    --i;
            }
        }
        return characters; //ctrl + w copy a word

    }

    public void start() {
        String nameOfPlayer1 = name(1);
        String nameOfPlayer2 = name(2);

        var charactersOfPlayer1 = characterChoosing(nameOfPlayer1, quantityOfCharacters);
        var charactersOfPlayer2 = characterChoosing(nameOfPlayer2, quantityOfCharacters);

        startingTheGame(charactersOfPlayer1, nameOfPlayer1);
        startingTheGame(charactersOfPlayer2, nameOfPlayer2);

        while (true) {
            attackingCharacter(nameOfPlayer1, nameOfPlayer2, quantityOfCharacters, charactersOfPlayer2, charactersOfPlayer1);
            poisonStep(quantityOfCharacters, charactersOfPlayer1, nameOfPlayer1);
            attackingCharacter(nameOfPlayer2, nameOfPlayer1, quantityOfCharacters, charactersOfPlayer1, charactersOfPlayer2);
            poisonStep(quantityOfCharacters, charactersOfPlayer2, nameOfPlayer2);

        }


    }
}
