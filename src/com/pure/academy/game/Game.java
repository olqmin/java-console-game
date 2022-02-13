package com.pure.academy.game;

import com.pure.academy.util.ASCIIArtHelper;
import com.pure.academy.util.SoundFXHelper;

import java.util.Scanner;

public class Game {
	Scanner scanner = new Scanner(System.in);
	int playerHP;
	String playerName;
	int choice;
	int monsterHP;
	int goldenKey;
	int playerMoney;
	int numberOfRabbits;
	int numberOfTrees;


	public static void main(String[] args) {

		//numberOfRabbits and numberOfTrees
		Game dublin = new Game();

		dublin.playerSetup();

		//dublin.townGate();


	}

	public void playerSetup() {
		playerHP = 100;
		monsterHP = 15;

		//playerWeapon = "Knife";
		
		ASCIIArtHelper.drawCharacter();
		
		System.out.println("\nYour HP: " + playerHP);
		System.out.println("Please enter your name:");

		playerName = scanner.nextLine();
		// TODO: invalid input. Please enter alphabetic name of the character!
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Hello " + playerName + ", let's start the game!");

		threeWayPath();
	}

	public void threeWayPath() {
		SoundFXHelper.playSound("resources/SoundFX/mixkit-arcade-game-opener-2222.wav");
		
		System.out.println("\n------------------------------------------------------------------\n");
		ASCIIArtHelper.drawThreeWayPath();
		System.out.println("\nYou are at a crossroad. Choose one of the following options:\n\n");
		System.out.println("1: To the mountain");
		System.out.println("2: To Pure City");
		System.out.println("3: To the gambling area");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scanner.nextInt();

		if (choice == 1) {
			mountain();
		} else if (choice == 2) {
			city();
		} else if (choice == 3) {
			// TODO: implement gambling area.
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("Coming soon.");
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
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scanner.nextInt();

		if (choice == 1) {
			forest();
		} else if (choice == 2) {
			river();
		} else if (choice == 3) {
			threeWayPath();
		} else {
			mountain();
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
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scanner.nextInt();

		if (choice == 1) {
			rabbit();
		} else if (choice == 2) {
			chopTree();
		} else if (choice == 3) {
			mountain();
		} else {
			forest();
		}
	}

	public void river() {
		System.out.println("\n------------------------------------------------------------------\n");
		playerHP += 10;
		System.out.println("Welcome to the river! You get 10 HP. Now your HP are " + playerHP + ".");
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
		System.out.println("4: To the monster");
		System.out.println("5: Return to the three-way-path");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scanner.nextInt();

		if (choice == 1) {
			cityMarket();
		} else if (choice == 2) {
			// TODO: implement Sorcerer.
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("Coming soon.");
			city();
		} else if (choice == 3) {
			// TODO: implement cave.
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("Coming soon.");
			city();
		} else if (choice == 4) {
			// TODO: implement monster.
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("Coming soon.");
			city();
		} else if (choice == 5) {
			threeWayPath();
		} else {
			city();
		}
	}

	public void cityMarket() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are in the city market. Choose one of the following options:\n\n");
		System.out.println("1: Sell rabbits");
		System.out.println("2: Sell trees");
		System.out.println("3: Return to the city");
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
		} else {
			cityMarket();
		}
	}
}