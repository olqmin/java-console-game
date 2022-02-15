package com.pure.academy.util;

import com.github.freva.asciitable.AsciiTable;

public class TableHelper {

	public static void showInformationTable(String playerName, int playerHP, int numberOfRabbits, int numberOfTrees,
			int goldenKey, int playerMoney) {

		String[] headers = { "", "Name", "HP", "Bunnies", "Trees", "Golden Keys", "Money" };
		String[][] data = { { "1", playerName, String.valueOf(playerHP), String.valueOf(numberOfRabbits),
				String.valueOf(numberOfTrees), String.valueOf(goldenKey), String.valueOf(playerMoney) } };

		System.out.println(AsciiTable.getTable(headers, data));
	}
}
