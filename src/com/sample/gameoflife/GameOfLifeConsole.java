package com.sample.gameoflife;

import java.util.Scanner;

public class GameOfLifeConsole {
	public static void test_main() {
		boolean viewNextGen = false;
		int generation = 0;
		Life configuration = new Life();
		// instructions() //TODO: User supplies initial Configuration

		configuration.initialize();
		configuration.print();

		System.out.println("Continue viewing new generation? (Y/N)");
		Scanner scanner = new Scanner(System.in);
		char input = scanner.next().charAt(0);
		if (input == 'Y' || input == 'y') {
			viewNextGen = true;
			generation++;
		}
		while (viewNextGen) {
			System.out.println("Generation: " + generation);
			configuration.update();
			configuration.print();
			System.out.println("Continue viewing new generation? (Y/N)");

			input = scanner.next().charAt(0);
			if (input == 'Y' || input == 'y') {
				viewNextGen = true;
				generation++;
			} else {
				viewNextGen = false;
			}
		}
		scanner.close();

	}

	public static void main(String[] args) {
		test_main();
	}

}
