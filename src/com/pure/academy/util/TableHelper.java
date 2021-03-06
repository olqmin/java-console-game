package com.pure.academy.util;

import com.github.freva.asciitable.AsciiTable;

public class TableHelper {
	
	public static void showInformationTable(String playerName, int playerHP, int monsterHP, String playerWeapon, int medicine, int numberOfRabbits, int numberOfTrees, boolean goldenKey, boolean caveKey, int playerMoney) {
		
String[] headers = {"", "Name", "HP", "Monster HP", "Weapon", "Medicine", "Bunnies", "Trees", "Golden Key", "Cave Key", "Money"};
	String[][] data = {
	        {"1", playerName, String.valueOf(playerHP), String.valueOf(monsterHP), playerWeapon, String.valueOf(medicine), String.valueOf(numberOfRabbits), String.valueOf(numberOfTrees), goldenKey ? "yes" : "no", caveKey ? "yes" : "no", String.valueOf(playerMoney)}};

	System.out.println(AsciiTable.getTable(headers, data));
	}
}
