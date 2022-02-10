package com.pure.academy.game;

import com.pure.academy.demo.DemoGame;

import java.util.Scanner;

public class Game {
	Scanner scanner = new Scanner(System.in);
	int playerHP;
	String playerName;
	int choice;
	int monsterHP;
	int goldenKey;


	public static void main(String args[]) {

        //numberOfRabbits and numberOfTrees
		Game dublin = new Game();

		dublin.playerSetup();

		//dublin.townGate();


	}

	public void playerSetup() {
		playerHP = 100;
		monsterHP = 15;

		//playerWeapon = "Knife";

		System.out.println("Your HP: " + playerHP);
		System.out.println("Please enter your name:");

		playerName = scanner.nextLine();
        // TODO: invalid input. Please enter alphabetic name of the character!
		System.out.println("Hello " + playerName + ", let's start the game!");

		threeWayPath();
	}

	public void threeWayPath() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are at a crossroad. Choose one of the following options:\n\n");
		System.out.println("1: To the mountain");
		System.out.println("2: To Pure City");
		System.out.println("3: To the gambling area");
		System.out.println("\n------------------------------------------------------------------\n");
		choice = scanner.nextInt();

		if (choice == 1) {
			// TODO: implement mountain.
		} else if (choice == 2) {
			// todo: implement city.
		} else if (choice == 3) {
			// todo: implement gambling area.
		} else {
			threeWayPath();
		}
	}

}
