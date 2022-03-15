package com.pure.academy.util;

public class InstructionHelper {
    public static void sorcererMenu(int playerMoney, String playerWeapon) {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("The Sorcerer is here.You have " + playerMoney + " gold and " + playerWeapon + ".  Choose one of the following options:\n\n");
        System.out.println("1: Buy a knife - 100 gold");
        System.out.println("2: Buy a sword - 500 gold");
        System.out.println("3: Buy a crossbow - 1000 gold");
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

    public static void threeWayPathInstruction() {
        System.out.println("\n------------------------------------------------------------------\n");
        ASCIIArtHelper.drawThreeWayPath();
        System.out.println("\nYou are at a crossroad. Choose one of the following options:\n\n");
        System.out.println("1: To the mountain");
        System.out.println("2: To Pure City");
        System.out.println("3: To the gambling area");
        System.out.println("4: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void mountainInstruction() {
        System.out.println("\n------------------------------------------------------------------\n");
        ASCIIArtHelper.drawMountain();
        System.out.println("\nWelcome to the mountain! Choose one of the following options:\n\n");
        // TODO: add description about options!
        System.out.println("1: To the forest");
        System.out.println("2: To the river");
        System.out.println("3: Return to the three-way-path");
        System.out.println("4: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");
    }
}
