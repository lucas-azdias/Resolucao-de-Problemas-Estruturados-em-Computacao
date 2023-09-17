package hanoiSolver;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	public static int inputInt(Scanner scanner, String msg) {
		System.out.print(msg);
		return scanner.nextInt();
	}
	
	public static boolean inputBoolean(Scanner scanner, String msg) {
		System.out.print(msg);
		String response = scanner.next();
		
		return response.toLowerCase().substring(0, 1).contentEquals("y");
	}
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// Initial message
			System.out.println("TOWER OF HANOI GAME");
			
			// Initialising the game
			int size = inputInt(scanner, "\nType the desired size of the Tower of Hanoi: ");
			
			boolean isAscendingOrder = inputBoolean(scanner, "\nType if the completion order is ascending [Y/N]: ");
			
			boolean showStepsInAutoSolve = inputBoolean(scanner, "\nShow step by step in autosolve mode? [Y/N]: ");
			
			Hanoi hanoi = new Hanoi(size, isAscendingOrder, showStepsInAutoSolve);
			
			System.out.println();
			
			// Playing the game
			BigInteger moves = BigInteger.ZERO;
			int choice;
			do {
				// Show current state
				System.out.print(hanoi.toString());
				
				// Gets option from the user
				choice = inputInt(scanner, "0 - Exit game\n1 - Move\n2 - Autosolve mode\n> ");
				
				System.out.println();
				
				if (choice == 1) {
					System.out.println("Initialising move...");
					int startTower = inputInt(scanner, "Enter the start tower: ") - 1;
					int endTower = inputInt(scanner, "Enter the end tower: ") - 1;
					if (hanoi.isMoveValid(startTower, endTower)) {
						hanoi.move(startTower, endTower);
						moves = moves.add(BigInteger.ONE);
						System.out.println("\nMoved.\n");
					} else {
						System.out.println("\nInvalid move.\n");
					}
				} else if (choice == 2) {
					moves = moves.add(hanoi.solve());
				}
			} while (choice != 0 && !hanoi.isSolved());
			
			// Checks if the challenge has been completed
			if (hanoi.isSolved()) {
				System.out.println("Congratulations! The Tower of Hanoi is solved!\n");
			} else {
				System.out.println("Good luck next time.\n");
			}
			System.out.println("The minimum amount of moves was " + hanoi.getMinimumMovesToSolve() + ".");
			System.out.println("You took " + moves + " moves.");
			
			// End message
			System.out.println("\nThe game has ended.");
		}
	}

}
