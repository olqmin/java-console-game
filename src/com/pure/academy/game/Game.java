package com.pure.academy.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.pure.academy.model.QuestionModel;
import com.pure.academy.util.ASCIIArtHelper;
import com.pure.academy.util.QuestionGeneratorHelper;
import com.pure.academy.util.ShuffelHelper;
import com.pure.academy.util.TableHelper;

public class Game {
    Scanner scanner = new Scanner(System.in);
    int playerHP;
    String playerName;
    int choice;
    int monsterHP;
    boolean quizKey = false;
    boolean caveKey = false;
    int playerMoney;
    int numberOfRabbits;
    int numberOfTrees;
    String playerWeapon = "Fist";
    int playerDamage;
    int medicine;


    public static void main(String[] args) {

        //numberOfRabbits and numberOfTrees
        Game dublin = new Game();

        dublin.playerSetup();

        //dublin.townGate();


    }

    public void playerSetup() {
        playerHP = 100;
        monsterHP = 50;

        //playerWeapon = "Knife";

        ASCIIArtHelper.drawCharacter();

        System.out.println("\nYour HP: " + playerHP);
        System.out.println("Please enter your name:");

        playerName = scanner.nextLine();
        // TODO: invalid input. Please enter alphabetic name of the character!
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Hello " + playerName + ", let's start the game!");

//        SoundFXHelper.playSound("resources/SoundFX/mixkit-arcade-game-opener-2222.wav");
        threeWayPath();
    }

    public void threeWayPath() {
        System.out.println("\n------------------------------------------------------------------\n");
        ASCIIArtHelper.drawThreeWayPath();
        System.out.println("\nYou are at a crossroad. Choose one of the following options:\n\n");
        System.out.println("1: To the mountain");
        System.out.println("2: To Pure City");
        System.out.println("3: To the gambling area");
        System.out.println("4: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            mountain();
        } else if (choice == 2) {
            city();
        } else if (choice == 3) {
            gamblingArea();
        } else if (choice == 4) {
            inventory();
            threeWayPath();
        } else {
            threeWayPath();
        }
    }

    public void mountain() {
        System.out.println("\n------------------------------------------------------------------\n");

        ASCIIArtHelper.drawMountain();

        System.out.println("\nWelcome to the mountain! Choose one of the following options:\n\n");

        // TODO: add description about options!
        System.out.println("1: To the forest");
        System.out.println("2: To the river");
        System.out.println("3: Return to the three-way-path");
        System.out.println("4: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            forest();
        } else if (choice == 2) {
            river();
        } else if (choice == 3) {
            threeWayPath();
        } else if (choice == 4) {
            inventory();
            mountain();
        } else {
            threeWayPath();
        }
    }

    public void forest() {
        System.out.println("\n------------------------------------------------------------------\n");

        ASCIIArtHelper.drawForest();

        System.out.println("\nWelcome to the forest! Choose one of the following options:\n\n");
        // TODO: add description about options!
        System.out.println("1: Get a rabbit");
        System.out.println("2: Chop a tree");
        System.out.println("3: Return to the mountain");
        System.out.println("4: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            rabbit();
        } else if (choice == 2) {
            chopTree();
        } else if (choice == 3) {
            mountain();
        } else if (choice == 4) {
            inventory();
            forest();
        } else {
            forest();
        }
    }

    public void river() {
        System.out.println("\n------------------------------------------------------------------\n");
        if (playerHP < 150) {
            playerHP += 10;
            System.out.println("Welcome to the river! You get 10 HP. Now your HP are " + playerHP + ".");
        } else {
            System.err.println("You can't take more 150 HP!");
        }
        mountain();
    }

    public void rabbit() {
        System.out.println("\n------------------------------------------------------------------\n");
        if (numberOfRabbits < 3) {
            numberOfRabbits++;

            ASCIIArtHelper.drawRabbit();

            System.out.println("You got a rabbit. You have " + numberOfRabbits + " rabbits.");
        } else {
            System.err.println("You can't take more than 3 rabbits!");
        }
        forest();
    }

    public void chopTree() {
        System.out.println("\n------------------------------------------------------------------\n");
        if (numberOfTrees < 3) {
            numberOfTrees++;
            System.out.println("You chopped a tree. You have " + numberOfTrees + " trees.");
        } else {
            System.err.println("You can't take more than 3 trees!");
        }
        forest();
    }

    public void city() {
        System.out.println("\n------------------------------------------------------------------\n");

        ASCIIArtHelper.drawPureCity();

        System.out.println("\nWelcome to Pure City! You are at a crossroad. Choose one of the following options:\n\n");
        System.out.println("1: To the shop");
        System.out.println("2: To the Sorcerer");
        System.out.println("3: To the cave");
        System.out.println("4: To the castle");
        System.out.println("5: Return to the three-way-path");
        System.out.println("6: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            cityMarket();
        } else if (choice == 2) {
            sorcerer();
        } else if (choice == 3) {
            if (caveKey) {
                cave();
            } else {
                System.out.println("The cave is locked! You have to kill the monster and get the key.");
                city();
            }
        } else if (choice == 4) {
            if (monsterHP < 1) {
                castle();
            } else {
                monster();
            }
        } else if (choice == 5) {
            threeWayPath();
        } else if (choice == 6) {
            inventory();
            city();
        } else {
            city();
        }
    }

    private String askQuestion(QuestionModel firstQuestion, int numberOfQuestion) {
        System.out.println("\n" + numberOfQuestion + ". " + firstQuestion.getActualQuestion());
        int iteration = 1;

        Map<Integer, String> questionVisualisedMap = new HashMap();
        for (String k : ShuffelHelper.newShuffledSet(firstQuestion.getAnswerMap().keySet())) {
            System.out.println(iteration + ". " + k);
            questionVisualisedMap.put(iteration, k);
            iteration++;
        }
        System.out.println("\nInput your answer: 1/2/3 or 4");

        choice = scanner.nextInt();
        String givenAnswer = questionVisualisedMap.get(choice);
        return givenAnswer;
    }

    public void gamblingArea() {
        if (playerMoney >= 10) {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("\nYou entered the gambling area.\n");
            System.out.println("You can gamble your money in this section only if you have at least 100 gold.");
            System.out.println("You have to guess the number from 0-100. 5 times must be enough for you.");
            System.out.println("If correct: Doubles the money\n" + "If 5 tries are over - your money will be divided by 2.\n");
            guessTheNumber();
        } else {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Hey, " + playerName + ", you don't have enough money to gamble. Choose one of the following options:");
            System.out.println("1: Return to the three-way-path");
            choice = scanner.nextInt();
            while (choice != 1) {
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("Hey, " + playerName + ", you don't have enough money to gamble. Choose one of the following options:");
                System.out.println("1: Return to the three-way-path");
                choice = scanner.nextInt();
            }
            threeWayPath();
        }
    }

    public void guessTheNumber() {
        int random = new Random().nextInt(101);
        System.out.print("Input a number from 0 to 100:");
        for (int i = 0; i < 5; i++) {
            choice = scanner.nextInt();

            if (choice == random) {
                playerMoney *= 2;
                System.out.println("You guessed the number! You doubled your money!");
                threeWayPath();
            } else if (choice < random) {
                System.out.println("The number is bigger!");
            } else {
                System.out.println("The number is smaller!");
            }
        }
        playerMoney /= 2;
        System.out.println("You didn't manage to guess the number!");
        System.out.println("The number is " + random + ".");
        System.out.println("Your money were divided by 2!");
        System.out.println("You have " + playerMoney + " gold.");
        threeWayPath();
    }

    public void cityMarket() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are in the city market. Choose one of the following options:\n\n");
        System.out.println("1: Sell rabbits");
        System.out.println("2: Sell trees");
        System.out.println("3: Return to the city");
        System.out.println("4: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            if (numberOfRabbits > 0) {
                numberOfRabbits--;
                playerMoney += 100;
                System.out.println("You sold a rabbit and got 100 gold. You have " + numberOfRabbits + " rabbits and " +
                        playerMoney + " gold.");
                cityMarket();
            } else {
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("You don't have any rabbits!");
                cityMarket();
            }
        } else if (choice == 2) {
            if (numberOfTrees > 0) {
                numberOfTrees--;
                playerMoney += 100;
                System.out.println("You sold a tree and got 100 gold. You have " + numberOfTrees + " trees and " +
                        playerMoney + " gold.");
                cityMarket();
            } else {
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("You don't have any trees!");
                cityMarket();
            }
        } else if (choice == 3) {
            city();
        } else if (choice == 4) {
            inventory();
            cityMarket();
        } else {
            cityMarket();
        }
    }

    public void cave() {
        if (playerMoney >= -10) {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("You entered the Quiz game area.");
            System.out.println("In this game you have 3 questions, each of them with with 4 answers and only one of them is correct.");
            System.out.println("For 1st, 2nd and 3rd question you will get 100, 500 or 1000 money and a key, but if you choose wrong answer your HP will be reduced by 20%, 50% or you will die.");
            System.out.println("Let's play Quiz game!\n");
            List<QuestionModel> questionList = QuestionGeneratorHelper.getThreeRandomQuestions();
            QuestionModel firstQuestion = questionList.get(0);
            String givenAnswer = askQuestion(firstQuestion, 1);

            if (firstQuestion.getAnswerMap().get(givenAnswer) == true) {
                System.out.println("Your answer is correct! You won 100 money.");
                playerMoney += 100;
                QuestionModel secondQuestion = questionList.get(1);
                givenAnswer = askQuestion(secondQuestion, 2);
                if (secondQuestion.getAnswerMap().get(givenAnswer) == true) {
                    System.out.println("Your answer is correct! You won 500 money.");
                    playerMoney += 500;
                    QuestionModel thirdQuestion = questionList.get(2);
                    givenAnswer = askQuestion(thirdQuestion, 3);
                    if (thirdQuestion.getAnswerMap().get(givenAnswer) == true) {
                        System.out.println("Your answer is correct! You won 1000 money.");
                        playerMoney += 1000;
                        if (!quizKey) {
                            System.out.println("You get the golden key!");
                            System.out.println("You can save the princess!");
                        }
                        quizKey = true;
                        city();
                    }
                    else {
                        dead();
                    }
                } else {
                    playerHP /= 2;
                    System.out.println("Your answer is wrong. Your HP are reduced by 50%. Good luck next time");
                    System.out.println("You have " + playerHP + " HP.");
                    city();
                }
            } else {
                playerHP -= playerHP / 5;
                System.out.println("Your answer is wrong. Your HP are reduced by 20%. Good luck next time");
                System.out.println("You have " + playerHP + " HP.");
                city();
            }
        }
        else {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Hey, " + playerName + ", you don't have enough money to play Quiz game. Choose one of the following options:");
            System.out.println("1: Return to Pure City");
            choice = scanner.nextInt();
            while (choice != 1) {
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("Hey, " + playerName + ", you don't have enough money to play Quiz game. Choose one of the following options:");
                System.out.println("1: Return to Pure City");
                choice = scanner.nextInt();
            }
            city();
        }
    }

    public void sorcerer() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("The Sorcerer is here.You have " + playerMoney + " gold and " + playerWeapon + ".  Choose one of the following options:\n\n");
        System.out.println("1: Buy a knife - 100 gold");
        System.out.println("2: Buy a sword - 500 gold");
        System.out.println("3: Buy a crossbow - 1000 gold");
        System.out.println("4: Buy medicine - 10 gold");
        System.out.println("5: Return to the city");
        System.out.println("6: Check inventory");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            knife();
        } else if (choice == 2) {
            sword();
        } else if (choice == 3) {
            crossbow();
        } else if (choice == 4) {
            medicine();
        } else if (choice == 5) {
            city();
        } else if (choice == 6) {
            inventory();
            sorcerer();
        } else {
            sorcerer();
        }
    }

    public void knife() {
        if (playerWeapon.equals("Knife")) {
            System.out.println("You already have a knife.");
            sorcerer();
        } else if (playerMoney >= 100) {
            playerMoney -= 100;
            playerWeapon = "Knife";
            System.out.println("You have a " + playerWeapon + " and " + playerMoney + " gold.");
            sorcerer();
        } else {
            System.out.println("You don't have enough money!");
            sorcerer();
        }
    }

    public void sword() {
        if (playerWeapon.equals("Sword")) {
            System.out.println("You already have a sword.");
            sorcerer();
        } else if (playerMoney >= 500) {
            playerMoney -= 500;
            playerWeapon = "Sword";
            System.out.println("You have a " + playerWeapon + " and " + playerMoney + " gold.");
            sorcerer();
        } else {
            System.out.println("You don't have enough money!");
            sorcerer();
        }
    }

    public void crossbow() {
        if (playerWeapon.equals("Crossbow")) {
            System.out.println("You already have a crossbow.");
            sorcerer();
        } else if (playerMoney >= 1000) {
            playerMoney -= 1000;
            playerWeapon = "Crossbow";
            System.out.println("You have a " + playerWeapon + " and " + playerMoney + " gold.");
            sorcerer();
        } else {
            System.out.println("You don't have enough money!");
            sorcerer();
        }
    }

    public void medicine() {
        if (medicine >= 5) {
            System.out.println("You can't take more than 5 medicine");
        } else if (playerMoney >= 10) {
            playerMoney -= 10;
            medicine++;
            System.out.println("You have " + medicine + " medicine and " + playerMoney + " gold.");
            sorcerer();
        } else {
            System.out.println("You don't have enough money!");
            sorcerer();
        }
    }

    public void monster() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Your HP: " + playerHP);
        System.out.println("Monster HP: " + monsterHP);
        System.out.println("\n1: Fight");
        System.out.println("2: Drink medicine");
        System.out.println("3: Run");
        System.out.println("\n------------------------------------------------------------------\n");

        choice = scanner.nextInt();

        if (choice == 1) {
            fight();
        } else if (choice == 2) {
            if (medicine > 0) {
                medicine--;
                playerHP += 10;
                System.out.println("Your HP are " + playerHP + ".");
                monster();
            } else {
                System.out.println("You don't have any medicine!");
                monster();
            }
        } else if (choice == 3) {
            city();
        } else {
            monster();
        }
    }

    public void fight() {
        switch (playerWeapon) {
            //int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            case "Fist" : playerDamage = ThreadLocalRandom.current().nextInt(0,2); break ;
            case "Knife": playerDamage = ThreadLocalRandom.current().nextInt(2,7); break;
            case "Sword": playerDamage = ThreadLocalRandom.current().nextInt(7,12); break;
            case "Crossbow": playerDamage = ThreadLocalRandom.current().nextInt(12,20); break;
        }
        System.out.println("You attacked the monster and gave " + playerDamage + " damage!");
        monsterHP = monsterHP - playerDamage;
        if (monsterHP < 0) {
            monsterHP = 0;
        }
        System.out.println("Monster HP: " + monsterHP);

        if (monsterHP < 1) {
            caveKey = true;
            System.out.println("You killed the monster and got the key for the cave! Choose one of the following options:");
            System.out.println("1. Go to the castle");
            System.out.println("2. Return to the city");

            choice = scanner.nextInt();

            if (choice == 1) {
                castle();
            } else if (choice == 2) {
                city();
            } else {
                fight();
            }
        } else {
            int monsterDamage = 0;

            monsterDamage = ThreadLocalRandom.current().nextInt(0,20);

            System.out.println("The monster attacked you and gave " + monsterDamage + " damage!");
            playerHP = playerHP - monsterDamage;
            System.out.println("Player HP: " + playerHP);

            if (playerHP < 1) {
                dead();
            } else {
                monster();
            }
        }
    }

    public void castle() {
        if (quizKey) {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("\nYou are in the castle. Choose one of the following options:\n\n");
            System.out.println("1. Save the princess");
            System.out.println("2. Return to the city");
            System.out.println("\n------------------------------------------------------------------\n");

            choice = scanner.nextInt();

            if (choice == 1) {
                princess();
            } else if (choice == 2) {
                city();
            } else {
                castle();
            }
        } else {
            System.out.println("Get the Quiz key first!");
            city();
        }
    }

    public void princess() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Hey " + playerName + ", " + "I was prisoned here too long, but you saved me. Thank you, my dear!");
        System.out.println("\nTHE END");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public void dead() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are dead! The game is over!");
        System.out.println("\n------------------------------------------------------------------\n");
    }

    public void inventory() {
        TableHelper.showInformationTable(playerName, playerHP, playerWeapon, medicine, numberOfRabbits, numberOfTrees, quizKey, caveKey, playerMoney);
    }
}
