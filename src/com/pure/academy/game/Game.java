package com.pure.academy.game;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.pure.academy.model.QuestionModel;
import com.pure.academy.model.Weapon;
import com.pure.academy.util.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    int playerHP;
    String playerName;
    int choice;
    int monsterHP;
    boolean quizKey;
    boolean caveKey;
    int playerMoney;
    int numberOfRabbits;
    int numberOfTrees;
    Weapon playerWeapon = Weapon.FIST;
    int playerDamage;
    int medicine;


    public static void main(String[] args) {

        Game pureAcademy = new Game();
        pureAcademy.playerSetup();

    }

    public void playerSetup() {
        playerHP = 100;
        monsterHP = 50;

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
        InstructionHelper.threeWayPathInstruction();

        checkInput(() -> threeWayPath());

        switch (choice) {
            case 1:
                mountain();
                break;
            case 2:
                city();
                break;
            case 3:
                gamblingArea();
                break;
            case 4:
                inventory();
                threeWayPath();
                break;
            default:
                threeWayPath();
        }


    }
    
    private void checkInput(Runnable function) {
    	String input = scanner.next();
        try {
            choice = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            System.err.println("Please enter only numbers!");
            function.run();
        }
    }

    public void mountain() {
        InstructionHelper.mountainInstruction();

        checkInput(() -> mountain());

        switch (choice) {
            case 1:
                forest();
                break;
            case 2:
                river();
                break;
            case 3:
                threeWayPath();
                break;
            case 4:
                inventory();
                mountain();
                break;
            default:
                mountain();
        }
    }

    public void forest() {
        InstructionHelper.forestInstruction();

        checkInput(() -> forest());

        switch (choice) {
            case 1:
                rabbit();
                break;
            case 2:
                chopTree();
                break;
            case 3:
                mountain();
                break;
            case 4:
                inventory();
                forest();
                break;
            default:
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
        InstructionHelper.cityInstruction();

        checkInput(() -> city());
        switch (choice) {
            case 1:
                cityShop();
                break;
            case 2:
                sorcerer();
                break;
            case 3:
                if (caveKey) {
                    cave();
                } else {
                    System.err.println("The cave is locked! You have to kill the monster and get the key.");
                    city();
                }
                break;
            case 4:
                if (monsterHP < 1) {
                    castle();
                } else {
                    monster();
                }
                break;
            case 5:
                threeWayPath();
                break;
            case 6:
                inventory();
                city();
                break;
            default:
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
            InstructionHelper.gamblingAreaRules();
            guessTheNumber();
        } else {
            InstructionHelper.gamblingAreaWarning(playerName);
            choice = scanner.nextInt();
            while (choice != 1) {
                InstructionHelper.gamblingAreaWarning(playerName);
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
                System.out.println("The number is bigger! Try again!");
            } else {
                System.out.println("The number is smaller! Try again!");
            }
        }
        playerMoney /= 2;
        InstructionHelper.guessTheNumberLose(random, playerMoney);
        threeWayPath();
    }

    public void cityShop() {
        InstructionHelper.cityShopInstruction();

        checkInput(() -> cityShop());
        switch (choice) {
            case 1:
                if (numberOfRabbits > 0) {
                    numberOfRabbits--;
                    playerMoney += 100;
                    System.out.println("You sold a rabbit and received 100 gold. You have " + numberOfRabbits + " rabbits and your amount of gold is " +
                            playerMoney + ".");
                    cityShop();
                } else {
                    System.err.println("You don't have any rabbits!");
                    cityShop();
                }
                break;
            case 2:
                if (numberOfTrees > 0) {
                    numberOfTrees--;
                    playerMoney += 100;
                    System.out.println("You sold a tree and received 100 gold. You have " + numberOfTrees + " trees and your amount of gold is " +
                            playerMoney + ".");
                    cityShop();
                } else {
                    System.err.println("You don't have any trees!");
                    cityShop();
                }
                break;
            case 3:
                city();
                break;
            case 4:
                inventory();
                cityShop();
                break;
            default:
                cityShop();
        }
    }

    public void cave() {
        if (playerMoney >= -10) {
            System.out.println("\n------------------------------------------------------------------\n");
            InstructionHelper.quizGameRules();
            List<QuestionModel> questionList = QuestionGeneratorHelper.getThreeRandomQuestions();
            QuestionModel firstQuestion = questionList.get(0);
            String givenAnswer = askQuestion(firstQuestion, 1);

            int moneyWon;
            if (firstQuestion.getAnswerMap().get(givenAnswer) == true) {
            	moneyWon = 100;
            	InstructionHelper.correctAnswerOnQuiz(moneyWon);
                playerMoney += moneyWon;
                QuestionModel secondQuestion = questionList.get(1);
                givenAnswer = askQuestion(secondQuestion, 2);
                if (secondQuestion.getAnswerMap().get(givenAnswer) == true) {
                	moneyWon = 500;
                	InstructionHelper.correctAnswerOnQuiz(moneyWon);
                    playerMoney += moneyWon;
                    QuestionModel thirdQuestion = questionList.get(2);
                    givenAnswer = askQuestion(thirdQuestion, 3);
                    if (thirdQuestion.getAnswerMap().get(givenAnswer) == true) {
                    	moneyWon = 1000;
                    	InstructionHelper.correctAnswerOnQuiz(moneyWon);
                        playerMoney += moneyWon;
                        if (!quizKey) {
                        	InstructionHelper.princessSaved();
                        }
                        quizKey = true;
                        city();
                    } else {
                        InstructionHelper.dead();
                    }
                } else {
                    playerHP /= 2;
                    InstructionHelper.caveWrongAnswer(playerHP, 50);
                    city();
                }
            } else {
                playerHP -= playerHP / 5;
                InstructionHelper.caveWrongAnswer(playerHP, 20);
                city();
            }
        } else {
            InstructionHelper.quizWarning(playerName);
            choice = scanner.nextInt();
            while (choice != 1) {
                InstructionHelper.quizWarning(playerName);
                choice = scanner.nextInt();
            }
            city();
        }
    }

    public void sorcerer() {
        InstructionHelper.sorcererMenu(playerMoney, playerWeapon.name().toLowerCase());

        checkInput(() -> sorcerer());
        switch (choice) {
            case 1:
                knife();
                break;
            case 2:
                sword();
                break;
            case 3:
                crossbow();
                break;
            case 4:
                medicine();
                break;
            case 5:
                city();
                break;
            case 6:
                inventory();
                sorcerer();
                break;
            default:
                sorcerer();
        }
    }

    private void buyWeapon(Weapon weapon) {
        if (playerWeapon.equals(weapon)) {
            System.err.println("You already have a " + weapon.name().toLowerCase() + ".");
            sorcerer();
        } else if (playerMoney >= weapon.price) {
            playerMoney -= weapon.price;
            playerWeapon = weapon;
            System.out.println("You have a " + weapon.name().toLowerCase() + " and " + playerMoney + " gold.");
            sorcerer();
        } else {
            System.err.println("You don't have enough money!");
            sorcerer();
        }
    }

    public void knife() {
        buyWeapon(Weapon.KNIFE);
    }

    public void sword() {
        buyWeapon(Weapon.SWORD);
    }

    public void crossbow() {
        buyWeapon(Weapon.CROSSBOW);
    }

    public void medicine() {
        if (medicine >= 5) {
            System.err.println("You can't take more than 5 medicine");
        } else if (playerMoney >= 10) {
            playerMoney -= 10;
            medicine++;
            System.out.println("You have " + medicine + " medicine and " + playerMoney + " gold.");
            sorcerer();
        } else {
            System.err.println("You don't have enough money!");
            sorcerer();
        }
    }

    public void monster() {
        InstructionHelper.monsterInstruction(playerHP, monsterHP);

        checkInput(() -> monster());

        switch (choice) {
            case 1:
                fight();
                break;
            case 2:
                if (medicine > 0) {
                    medicine--;
                    playerHP += 10;
                    System.out.println("Your HP are " + playerHP + ".");
                    monster();
                } else {
                    System.err.println("You don't have any medicine!");
                    monster();
                }
                break;
            case 3:
                city();
                break;
            default:
                monster();
        }
    }

    public void fight() {
        int monsterDamage = 0;
        switch (playerWeapon) {
            case FIST:
                playerDamage = ThreadLocalRandom.current().nextInt(0, 2);
                break;
            case KNIFE:
                playerDamage = ThreadLocalRandom.current().nextInt(2, 7);
                break;
            case SWORD:
                playerDamage = ThreadLocalRandom.current().nextInt(7, 12);
                break;
            case CROSSBOW:
                playerDamage = ThreadLocalRandom.current().nextInt(12, 20);
                break;
        }
        System.out.println("You attacked the monster and gave " + playerDamage + " damage!");
        monsterHP = monsterHP - playerDamage;
        if (monsterHP < 0) {
            monsterHP = 0;
        }
        System.out.println("Monster HP: " + monsterHP);

        if (monsterHP > 0) {
            switch (playerWeapon) {
                case FIST:
                    monsterDamage = ThreadLocalRandom.current().nextInt(0, 4);
                    break;
                case KNIFE:
                    monsterDamage = ThreadLocalRandom.current().nextInt(4, 15);
                    break;
                case SWORD:
                    monsterDamage = ThreadLocalRandom.current().nextInt(15, 25);
                    break;
                case CROSSBOW:
                    monsterDamage = ThreadLocalRandom.current().nextInt(25, 50);
                    break;
            }


            System.out.println("The monster attacked you and gave " + monsterDamage + " damage!");
            playerHP = playerHP - monsterDamage;
            if (playerHP < 1) {
                playerHP = 0;
                System.out.println("Player HP: " + playerHP);
                InstructionHelper.dead();
            } else {
                System.out.println("Player HP: " + playerHP);
                monster();
            }
        } else {
            caveKey = true;
            InstructionHelper.monsterKilled();

            checkInput(() -> fight());

            switch (choice) {
                case 1:
                    castle();
                    break;
                case 2:
                    city();
                    break;
                default:
                    fight();
            }

        }
    }

    public void castle() {
        if (quizKey) {
            InstructionHelper.castleInstruction();

            checkInput(() -> castle());

            switch (choice) {
                case 1:
                    InstructionHelper.princess(playerName);
                    break;
                case 2:
                    city();
                    break;
                default:
                    castle();
            }

        } else {
            System.err.println("Get the Quiz key first!");
            city();
        }
    }

    public void inventory() {
        TableHelper.showInformationTable(playerName, playerHP, playerWeapon.name().toLowerCase(), medicine, numberOfRabbits, numberOfTrees, quizKey, caveKey, playerMoney);
    }
}
