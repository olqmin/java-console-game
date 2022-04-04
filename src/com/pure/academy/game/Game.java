package com.pure.academy.game;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.pure.academy.model.*;
import com.pure.academy.model.enums.Weapon;
import com.pure.academy.model.weapons.OttomanWeapon;
import com.pure.academy.model.weapons.PersianWeapon;
import com.pure.academy.model.weapons.ScandinavianWeapon;
import com.pure.academy.util.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    GameDataHelper gameData = new GameDataHelper();

    public static void main(String[] args) {

        Game pureAcademy = new Game();
        pureAcademy.playerSetup();


    }

    public void playerSetup() {
        gameData.setPlayerHP(100);
        gameData.setMonsterHP(50);

        ASCIIArtHelper.drawCharacter();

        System.out.println("\nYour HP: " + gameData.getPlayerHP());
        System.out.println("Please enter your name:");

        gameData.setPlayerName(scanner.nextLine());

        System.out.println("\n------------------------------------------------------------------\n");

        System.out.println("Hello " + gameData.getPlayerName() + ", let's start the game!");

        chooseKingdom();
        threeWayPath();
    }


    public void greetingFromTheKing() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println(gameData.getChosenHero().getKingName() + ":");
        System.out.println("Thank goodness you've arrived into my kingdom! All was peaceful until this terrible monster " + gameData.getChosenHero().getMonsterName() + " came. \n" +
                "Our homes are destroyed, the children and women are frightened. The screams that echo in the night are inhuman.\n" +
                "Even my best men and soldiers are incapable to overcome his strength. \n" +
                "Follow the path and keep in mind that " + gameData.getChosenHero().getMonsterName() + " is strong and it would be easier to kill it with weapons, which you can find in the city. \n" +
                "Last but not least, defeating the monster will save my imprisoned daughter - " + gameData.getChosenHero().getPrincesName() + ". Perhaps I can tell you more if we speak again. Good luck.");
    }

    public void bestWeaponForMonster() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println(gameData.getChosenHero().getKingName() + ":");
        System.out.println("It is time to give you an important advice. " + gameData.getChosenHero().getMonsterName() + " as every monster has it's weakness.");
        System.out.println("You'll definitely have a better chance in battle if you use a " + gameData.getPlayerWeapon().getPurchasableWeapons().get(2) + " against him.");
    }


    public void chooseKingdom() {
        InstructionHelper.choseKingdomInstruction();
        checkInput(() -> chooseKingdom());

        switch (gameData.getChoice()) {
            case 1:
                KingdomModel ottoman = new KingdomModel("Abdul Hamid II", "Zeynep", "Ubir", "Ararat", "Seydisuyu", "Ottoman land");
                gameData.setChosenHero(ottoman);
                gameData.setPlayerWeapon(new OttomanWeapon());
                break;
            case 2:
                KingdomModel scandinavian = new KingdomModel("Ragnar Lothbrok", "Aslaug", "Fenrir", "Uppsala", "Klar?lven", "Scandinavia");
                gameData.setChosenHero(scandinavian);
                gameData.setPlayerWeapon(new ScandinavianWeapon());
                break;
            case 3:
                KingdomModel persian = new KingdomModel("Artaxerxes I", "Damaspia", "Manticore", "Siah-Kaman", "Karkheh", "Persia");
                gameData.setChosenHero(persian);
                gameData.setPlayerWeapon(new PersianWeapon());
                break;
            default:
                chooseKingdom();
        }
        greetingFromTheKing();
    }

    public void threeWayPath() {
        InstructionHelper.threeWayPathInstruction();

        checkInput(() -> threeWayPath());

        switch (gameData.getChoice()) {
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
            gameData.setChoice(Integer.valueOf(input));
        } catch (NumberFormatException e) {
            System.err.println("Please enter only numbers!");
            function.run();
        }
    }

    public void mountain() {
        InstructionHelper.mountainInstruction();

        checkInput(() -> mountain());

        switch (gameData.getChoice()) {
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

        switch (gameData.getChoice()) {
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
        if (gameData.getPlayerHP() < 150) {
            gameData.setPlayerHP(gameData.getPlayerHP() + 10);
            System.out.println("Welcome to " + gameData.getChosenHero().getRiverName() + " river! You get 10 HP. Now your HP are " + gameData.getPlayerHP() + ".");
        } else {
            System.out.println(gameData.getChosenHero().getKingName() + ":");
            System.err.println("You can't take more than 150 HP!");
        }
        mountain();
    }

    public void rabbit() {
        System.out.println("\n------------------------------------------------------------------\n");
        if (gameData.getNumberOfRabbits() < 3) {
            gameData.setNumberOfRabbits(gameData.getNumberOfRabbits() + 1);

            ASCIIArtHelper.drawRabbit();

            System.out.println("You got a rabbit. You have " + gameData.getNumberOfRabbits() + " rabbit" + itemPlural(gameData.getNumberOfRabbits()) + ".");
        } else {
            System.out.println(gameData.getChosenHero().getKingName() + ":");
            System.err.println("You can't take more than 3 rabbits!");
        }
        forest();
    }

    public void chopTree() {
        System.out.println("\n------------------------------------------------------------------\n");
        if (gameData.getNumberOfTrees() < 3) {
            gameData.setNumberOfTrees(gameData.getNumberOfTrees() + 1);
            System.out.println("You chopped a tree. You have " + gameData.getNumberOfTrees() + " tree" + itemPlural(gameData.getNumberOfTrees()) + ".");
        } else {
            System.out.println(gameData.getChosenHero().getKingName() + ":");
            System.err.println("You can't take more than 3 trees!");
        }
        forest();
    }


    private String itemPlural(int numberOfItems) {
        return numberOfItems > 1 ? "s" : "";
    }

    public void city() {
        InstructionHelper.cityInstruction();

        checkInput(() -> city());

        switch (gameData.getChoice()) {
            case 1:
                cityShop();
                break;
            case 2:
                sorcerer();
                break;
            case 3:
                if (gameData.isCaveKey()) {
                    cave();
                } else {
                    System.out.println(gameData.getChosenHero().getKingName() + ":");
                    System.err.println("The cave is locked! You have to kill the monster and get the key.");
                    city();
                }
                break;
            case 4:
                if (gameData.getMonsterHP() < 1) {
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

        gameData.setChoice(scanner.nextInt());
        String givenAnswer = questionVisualisedMap.get(gameData.getChoice());
        return givenAnswer;
    }

    public void gamblingArea() {
        if (gameData.getPlayerMoney() >= 10) {
            System.out.println("\n------------------------------------------------------------------\n");
            InstructionHelper.gamblingAreaRules();
            guessTheNumber();
        } else {
            InstructionHelper.gamblingAreaWarning(gameData.getPlayerName());
            gameData.setChoice(scanner.nextInt());
            while (gameData.getChoice() != 1) {
                InstructionHelper.gamblingAreaWarning(gameData.getPlayerName());
                gameData.setChoice(scanner.nextInt());
            }
            threeWayPath();
        }
    }

    public void guessTheNumber() {
        int random = new Random().nextInt(101);
        System.out.print("Input a number from 0 to 100:");
        for (int i = 0; i < 5; i++) {
            gameData.setChoice(scanner.nextInt());

            if (gameData.getChoice() == random) {
                gameData.setPlayerMoney(gameData.getPlayerMoney() * 2);
                System.out.println("You guessed the number! You doubled your money!");
                threeWayPath();
            } else if (gameData.getChoice() < random) {
                System.out.println("The number is bigger! Try again!");
            } else {
                System.out.println("The number is smaller! Try again!");
            }
        }
        gameData.setPlayerMoney(gameData.getPlayerMoney() / 2);
        InstructionHelper.guessTheNumberLose(random, gameData.getPlayerMoney());
        threeWayPath();
    }

    public void cityShop() {
        InstructionHelper.cityShopInstruction();

        checkInput(() -> cityShop());

        switch (gameData.getChoice()) {
            case 1:
                gameData.setNumberOfRabbits(sellingItems(gameData.getNumberOfRabbits(), "rabbit"));
                cityShop();
                break;
            case 2:
                gameData.setNumberOfTrees(sellingItems(gameData.getNumberOfTrees(), "tree"));
                cityShop();
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

    private int sellingItems(int numberOfItems, String item) {
        if (numberOfItems > 0) {
            numberOfItems--;
            gameData.setPlayerMoney(gameData.getPlayerMoney() + 100);
            System.out.println("You sold a " + item + " and received 100 gold. You have " + numberOfItems + " " + item + itemPlural(numberOfItems) + " and your amount of gold is " +
                    gameData.getPlayerMoney() + ".");
        } else {
            System.out.println(gameData.getChosenHero().getKingName() + ":");
            System.err.println("You don't have any " + item + "s!");
        }
        return numberOfItems;
    }


    public void cave() {
        if (gameData.getPlayerMoney() >= -10) {
            System.out.println("\n------------------------------------------------------------------\n");
            InstructionHelper.quizGameRules();
            List<QuestionModel> questionList = QuestionGeneratorHelper.getThreeRandomQuestions();
            QuestionModel firstQuestion = questionList.get(0);
            String givenAnswer = askQuestion(firstQuestion, 1);

            int moneyWon;
            if (firstQuestion.getAnswerMap().get(givenAnswer) == true) {
                moneyWon = 100;
                InstructionHelper.correctAnswerOnQuiz(moneyWon);
                gameData.setPlayerMoney(gameData.getPlayerMoney() + moneyWon);
                QuestionModel secondQuestion = questionList.get(1);
                givenAnswer = askQuestion(secondQuestion, 2);
                if (secondQuestion.getAnswerMap().get(givenAnswer) == true) {
                    moneyWon = 500;
                    InstructionHelper.correctAnswerOnQuiz(moneyWon);
                    gameData.setPlayerMoney(gameData.getPlayerMoney() + moneyWon);
                    QuestionModel thirdQuestion = questionList.get(2);
                    givenAnswer = askQuestion(thirdQuestion, 3);
                    if (thirdQuestion.getAnswerMap().get(givenAnswer) == true) {
                        moneyWon = 1000;
                        InstructionHelper.correctAnswerOnQuiz(moneyWon);
                        gameData.setPlayerMoney(gameData.getPlayerMoney() + moneyWon);
                        if (!gameData.isQuizKey()) {
                            InstructionHelper.princessSaved();
                        }
                        gameData.setQuizKey(true);
                        city();
                    } else {
                        InstructionHelper.dead();
                    }
                } else {
                    gameData.setPlayerHP(gameData.getPlayerHP() / 2);
                    InstructionHelper.caveWrongAnswer(gameData.getPlayerHP(), 50);
                    city();
                }
            } else {
                gameData.setPlayerHP(gameData.getPlayerHP() / 5);
                InstructionHelper.caveWrongAnswer(gameData.getPlayerHP(), 20);
                city();
            }
        } else {
            InstructionHelper.quizWarning(gameData.getPlayerName());
            gameData.setChoice(scanner.nextInt());
            while (gameData.getChoice() != 1) {
                InstructionHelper.quizWarning(gameData.getPlayerName());
                gameData.setChoice(scanner.nextInt());
            }
            city();
        }
    }

    public void sorcerer() {

        InstructionHelper.sorcererMenu(gameData.getPlayerMoney(), gameData.getPlayerWeapon().getCurrentWeapon().name, gameData.getPlayerWeapon().getPurchasableWeapons());

        checkInput(() -> sorcerer());

        switch (gameData.getChoice()) {
            case 1:
                buyWeapon(gameData.getPlayerWeapon().getPurchasableWeapons().get(0));
                break;
            case 2:
                buyWeapon(gameData.getPlayerWeapon().getPurchasableWeapons().get(1));
                break;
            case 3:
                buyWeapon(gameData.getPlayerWeapon().getPurchasableWeapons().get(2));
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
        if (gameData.getPlayerWeapon().getCurrentWeapon().equals(weapon)) {
            System.out.println(gameData.getChosenHero().getKingName() + ":");
            System.err.println("You already have a " + weapon.name + ".");
            sorcerer();
        } else if (gameData.getPlayerMoney() >= weapon.price) {
            gameData.setPlayerMoney(gameData.getPlayerMoney() + weapon.price);
            gameData.getPlayerWeapon().setCurrentWeapon(weapon);
            System.out.println("You have a " + weapon.name + " and " + gameData.getPlayerMoney() + " gold.");
            sorcerer();
        } else {
            InstructionHelper.notEnoughMoney();
            sorcerer();
        }
    }

    public void medicine() {
        if (gameData.getMedicine() >= 5) {
            System.out.println(gameData.getChosenHero().getKingName() + ":");
            System.err.println("You can't take more than 5 medicine");
        } else if (gameData.getPlayerMoney() >= 10) {
            gameData.setPlayerMoney(gameData.getPlayerMoney() - 10);
            gameData.setMedicine(gameData.getMedicine() + 1);
            System.out.println("You have " + gameData.getMedicine() + " medicine and " + gameData.getPlayerMoney() + " gold.");
            sorcerer();
        } else {
            InstructionHelper.notEnoughMoney();
            sorcerer();
        }
    }

    public void monster() {
        InstructionHelper.monsterInstruction(gameData.getPlayerHP(), gameData.getMonsterHP());

        checkInput(() -> monster());

        switch (gameData.getChoice()) {
            case 1:
                fight();
                break;
            case 2:
                if (gameData.getMedicine() > 0) {
                    gameData.setMedicine(gameData.getMedicine() - 1);
                    gameData.setPlayerHP(gameData.getPlayerHP() + 10);
                    System.out.println("Your HP are " + gameData.getPlayerHP() + ".");
                    monster();
                } else {
                    InstructionHelper.noMedicine();
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
        gameData.setPlayerDamage(ThreadLocalRandom.current().nextInt(gameData.getPlayerWeapon().getCurrentWeapon().minDamage, gameData.getPlayerWeapon().getCurrentWeapon().maxDamage));

        System.out.println("You attacked the monster and gave " + gameData.getPlayerDamage() + " damage!");
        gameData.setMonsterHP(gameData.getMonsterHP() - gameData.getPlayerDamage());
        if (gameData.getMonsterHP() < 0) {
            gameData.setMonsterHP(0);
        }
        System.out.println("Monster HP: " + gameData.getMonsterHP());

        if (gameData.getMonsterHP() > 0) {
            switch (gameData.getPlayerWeapon().getCurrentWeapon()) {
                case FIST:
                    monsterDamage = ThreadLocalRandom.current().nextInt(0, 4);
                    break;
                case SCANDINAVIAN_KNIFE:
                case PERSIAN_KNIFE:
                case OTTOMAN_AXE:
                    monsterDamage = ThreadLocalRandom.current().nextInt(4, 15);
                    break;
                case SCANDINAVIAN_AXE:
                case PERSIAN_CROSSBOW:
                case OTTOMAN_CROSSBOW:
                    monsterDamage = ThreadLocalRandom.current().nextInt(15, 25);
                    break;
                case SCANDINAVIAN_CROSSBOW:
                case PERSIAN_AXE:
                case OTTOMAN_KNIFE:
                    monsterDamage = ThreadLocalRandom.current().nextInt(25, 50);
                    break;
            }

            System.out.println("The monster attacked you and gave " + monsterDamage + " damage!");
            gameData.setPlayerHP(gameData.getPlayerHP() - monsterDamage);
            if (gameData.getPlayerHP() < 1) {
                gameData.setPlayerHP(0);
                System.out.println("Player HP: " + gameData.getPlayerHP());
                InstructionHelper.dead();
            } else {
                System.out.println("Player HP: " + gameData.getPlayerHP());
                monster();
            }
        } else {
            gameData.setCaveKey(true);
            InstructionHelper.monsterKilled();

            checkInput(() -> fight());

            switch (gameData.getChoice()) {
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
        if (gameData.isQuizKey()) {
            InstructionHelper.castleInstruction();

            checkInput(() -> castle());

            switch (gameData.getChoice()) {
                case 1:
                    InstructionHelper.princess(gameData.getPlayerName());
                    break;
                case 2:
                    city();
                    break;
                default:
                    castle();
            }
        } else {
            System.out.println(gameData.getChosenHero().getKingName() + ":");
            System.err.println("Get the Quiz key first!");
            city();
        }
    }

    public void inventory() {
        TableHelper.showInformationTable(gameData.getPlayerName(), gameData.getPlayerHP(), gameData.getMonsterHP(), gameData.getPlayerWeapon().getCurrentWeapon().name, gameData.getMedicine(), gameData.getNumberOfRabbits(), gameData.getNumberOfTrees(), gameData.isQuizKey(), gameData.isCaveKey(), gameData.getPlayerMoney());
    }
}
