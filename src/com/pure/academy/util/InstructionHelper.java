package com.pure.academy.util;

import com.pure.academy.model.enums.Weapon;

import java.util.List;

public class InstructionHelper {
    public static void sorcererMenu(int playerMoney, String playerWeapon, List<Weapon> purchasableWeapons) {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("The Sorcerer is here. You have " + playerMoney + " gold and a " + playerWeapon + " weapon. Choose one of the following options:\n\n");
        System.out.println("1: Buy a " + purchasableWeapons.get(0).name + " - " + purchasableWeapons.get(0).price + " gold.");
        System.out.println("2: Buy a " + purchasableWeapons.get(1).name + " - " + purchasableWeapons.get(1).price + " gold.");
        System.out.println("3: Buy a " + purchasableWeapons.get(2).name + " - " + purchasableWeapons.get(2).price + " gold.");
        System.out.println("4: Buy medicine - 10 gold");
        System.out.println("5: Return to the city");
        System.out.println("6: Check inventory");

        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void quizGameRules() {
        System.out.println("You entered the Quiz game area.");
        System.out.println("In this game you have 3 questions, each of them with with 4 answers and only one of them is correct.");
        System.out.println("For 1st, 2nd and 3rd question you will get 100, 500 or 1000 money and a key, but if you choose wrong answer your HP will be reduced by 20%, 50% or you will die.");
        System.out.println("Let's play Quiz game!\n");
    }

    public static void gamblingAreaRules() {
        System.out.println("\nYou entered the gambling area.\n");
        System.out.println("You can gamble your money in this section only if you have at least 100 gold.");
        System.out.println("You have to guess the number from 0-100. 5 times must be enough for you.");
        System.out.println("If correct: Doubles the money\n" + "If 5 tries are over - your money will be divided by 2.\n");
    }

    public static void threeWayPathInstruction(String mountainName) {
        System.out.println("\n------------------------------------------------------------------\n");
        ASCIIArtHelper.drawThreeWayPath();
        System.out.println("\nYou are at a crossroad. Choose one of the following options:\n\n");
        System.out.println("1: To the " + mountainName + " mountain");
        System.out.println("2: To Pure City");
        System.out.println("3: To the gambling area");
        System.out.println("4: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void mountainInstruction(String mountainName, String riverName) {
        System.out.println("\n------------------------------------------------------------------\n");
        ASCIIArtHelper.drawMountain();
        System.out.println("\nWelcome to the " + mountainName + " mountain! Here you can find tradable resources which can help you further in the game. Choose one of the following options:\n\n");
        System.out.println("1: To the forest");
        System.out.println("2: To the " + riverName + " river");
        System.out.println("3: Return to the three-way-path");
        System.out.println("4: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void forestInstruction(String mountainName) {
        System.out.println("\n------------------------------------------------------------------\n");
        ASCIIArtHelper.drawForest();
        System.out.println("\nWelcome to the forest!Here you can add rabbits or trees to your inventory. Choose one of the following options:\n\n");
        System.out.println("1: Get a rabbit");
        System.out.println("2: Chop a tree");
        System.out.println("3: Return to the " + mountainName + " mountain");
        System.out.println("4: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void cityInstruction(String kingdom) {
        System.out.println("\n------------------------------------------------------------------\n");
        ASCIIArtHelper.drawPureCity();
        System.out.println("\nWelcome to Pure City! You are at a crossroad. Choose one of the following options:\n\n");
        System.out.println("1: To the shop");
        System.out.println("2: To the Sorcerer");
        System.out.println("3: To the cave");
        System.out.println("4: To the " + kingdom + " castle");
        System.out.println("5: Return to the three-way-path");
        System.out.println("6: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void cityShopInstruction() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are in the city market. Choose one of the following options:\n\n");
        System.out.println("1: Sell rabbits");
        System.out.println("2: Sell trees");
        System.out.println("3: Return to the city");
        System.out.println("4: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");
    }


    public static void gamblingAreaWarning(String playerName) {
        System.out.println("\n------------------------------------------------------------------\n");
        System.err.println("Hey, " + playerName + ", you don't have enough money to gamble. Choose one of the following options:");
        System.err.println("1: Return to the three-way-path");
    }

    public static void guessTheNumberLose(int random, int playerMoney) {
        System.out.println("You didn't manage to guess the number!");
        System.out.println("The number is " + random + ".");
        System.out.println("Your money were divided by 2!");
        System.out.println("You have " + playerMoney + " gold.");
    }

    public static void caveWrongAnswer(int playerHP, int percentage) {
        System.err.println("Your answer is wrong. Your HP are reduced by " + percentage + "%. Good luck next time");
        System.err.println("You have " + playerHP + " HP.");
    }

    public static void quizWarning(String playerName) {
        System.out.println("\n------------------------------------------------------------------\n");
        System.err.println("Hey, " + playerName + ", you don't have enough money to play Quiz game. Choose one of the following options:");
        System.err.println("1: Return to Pure City");
    }

    public static void monsterInstruction(int playerHP, int monsterHP) {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Your HP: " + playerHP);
        System.out.println("Monster HP: " + monsterHP);
        System.out.println("\n1: Fight");
        System.out.println("2: Drink medicine");
        System.out.println("3: Run");
        System.out.println("\n------------------------------------------------------------------\n");
    }


    public static void monsterKilled() {
        System.out.println("You killed the monster and got the key for the cave! Choose one of the following options:");
        System.out.println("1. Go to the castle");
        System.out.println("2. Return to the city");
    }

    public static void castleInstruction() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("\nYou are in the castle. Choose one of the following options:\n\n");
        System.out.println("1. Save the princess");
        System.out.println("2. Return to the city");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void princess(String playerName) {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Hey " + playerName + ", " + "I was prisoned here too long, but you saved me. Thank you, my dear!");
        System.out.println("\nTHE END");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void dead() {
        System.err.println("\n------------------------------------------------------------------\n");
        System.err.println("You are dead! The game is over!");
        System.err.println("\n------------------------------------------------------------------\n");
    }

    public static void correctAnswerOnQuiz(int moneyWon) {
        System.out.println("Your answer is correct! You won " + moneyWon + " money.");

    }

    public static void princessSaved() {
        System.out.println("You get the golden key!");
        System.out.println("You can save the princess!");
    }

    public static void notEnoughMoney() {
        System.err.println("You don't have enough money!");
    }

    public static void noMedicine() {
        System.err.println("You don't have any medicine!");
    }

    public static void choseKingdomInstruction() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Please choose a kingdom in which you want to play: ");
        System.out.println("1. Ottoman land");
        System.out.println("2. Scandinavia");
        System.out.println("3. Persia");
        System.out.println("\n------------------------------------------------------------------\n");
    }
}
