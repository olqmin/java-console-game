package com.pure.academy.util;

import com.github.freva.asciitable.AsciiTable;

public class TableHelper {
	
	public static void showInformationTable(String playerName, int playerHP, String playerWeapon, int medicine, int numberOfRabbits, int numberOfTrees, boolean goldenKey, boolean caveKey, int playerMoney) {
		
String[] headers = {"", "Name", "HP", "Weapon", "Medicine", "Bunnies", "Trees", "Golden Key", "Cave Key", "Money"};
	String[][] data = {
	        {"1", playerName, String.valueOf(playerHP), playerWeapon, String.valueOf(medicine), String.valueOf(numberOfRabbits), String.valueOf(numberOfTrees), String.valueOf(goldenKey), String.valueOf(caveKey), String.valueOf(playerMoney)}};

	System.out.println(AsciiTable.getTable(headers, data));
	}
}
