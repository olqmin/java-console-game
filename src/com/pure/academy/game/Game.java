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

	}



}
