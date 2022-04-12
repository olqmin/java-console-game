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

    public static void monsterKilled(String kingName, String monsterName) {
        System.out.println(kingName + ": You killed " + monsterName + " and got the key for the cave! Choose one of the following options:");
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

    public static void dead(String kingName) {
        System.err.println("\n------------------------------------------------------------------\n");
        System.err.println(kingName + ":");
        System.err.println("You are dead! The game is over! ");
        System.err.println("Don't get disappointed! The key to overcoming the monster is in exploring the map.");
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

    public static void noMedicine(String kingName) {
        System.err.println(kingName + ": You don't have any medicine!");
    }

    public static void choseKingdomInstruction() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Please choose a kingdom in which you want to play: ");
        System.out.println("1. Ottoman land");
        System.out.println("2. Scandinavia");
        System.out.println("3. Persia");
        System.out.println("4. Great Bulgaria");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public static void hpLimitReached(String kingName) {
        System.err.println(kingName + ": You can't take more than 150 HP!");
    }

    public static void greetingFromTheKing(String kingName, String kingdomName, String monsterName, String princessName) {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println(kingName + ":");
        System.out.println("Thank goodness you've arrived in " + kingdomName + "! All was peaceful until this terrible monster " + monsterName + " came. \n" +
                "Our homes are destroyed, the children and women are frightened. The screams that echo in the night are inhuman.\n" +
                "Even my best men and soldiers are incapable to overcome his strength. \n" +
                "Follow the path and keep in mind that " + monsterName + " is strong and it would be easier to kill it with weapons, which you can find in the city. \n" +
                "Last but not least, defeating the monster will save my imprisoned daughter - " + princessName + ". Perhaps I can tell you more if we speak again. Good luck.");
    }

    public static void bestWeaponForMonster(String kingName, String monsterName, String monsterDesc) {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println(kingName + ":");
        System.out.println("It is time to give you an important advice. " + monsterName + " as every monster has its weakness.\n");
        System.out.println(monsterDesc);
        System.out.println();
        System.out.println("You'll definitely have a better chance in battle if you use the best weapon against it.");
    }

    public static void showPlayerHP(String playerName, int playerHP) {
        System.out.println(playerName + " HP: " + playerHP);
    }

    public static void showMonsterHP(int monsterHP) {
        System.out.println("Monster HP: " + monsterHP);
    }

    public static String babaYagaDesc() {
        return
                "In Slavic mythology Baba Yaga is an old witch with long nose,\n" +
                        "crooked legs and gets around with a magic broomstick.\n" +
                        "Young children are afraid of her because she eats them in big pots.\n" +
                        "Elders are afraid of her because they think she can cast devious\n" +
                        "spells and curses on them. When she meets a person, she either blesses\n" +
                        "them or curses them, depending on the approach to her.";
    }

    public static String fenrirDesc() {
        return
                "A monstrous wolf.\n" +
                        "The Aesir gods raised Fenrir themselves in order to\n" +
                        "keep him under their control and prevent him from wreaking\n" +
                        "havoc throughout the Nine Worlds. He grew at an astonishingly fast pace,\n" +
                        "however, and eventually the troubled gods decided to chain him up.\n" +
                        "Fenrir refused to be bound and run throughout the world with his lower jaw\n" +
                        "against the ground and his upper jaw in the sky, devouring everything in his path.";
    }

    public static String ubirDesc() {
        return
                "A monster like vampire. It is a mythological or\n" +
                        "folkloric being in Turkic mythology who subsist by\n" +
                        "feeding on the life essence (generally in the form of blood of)\n" +
                        "living creatures, regardless of whether it is undead person or being.";
    }

    public static String manticoreDesc() {
        return
                "It is a highly dangerous beast with the head of a man,\n" +
                        "the body of a lion and the tail of a scorpion,\n" +
                        "which can shoot out venomous spines or hairs to incapacitate prey.\n" +
                        "The venom he secretes from his tail is highly toxic and fast acting.\n" +
                        "The manticore is able to shoot its spines either in front or behind,\n" +
                        "curving its tail over its body to shoot forwards, or straightening it tail to shoot them backwards.";
    }
}