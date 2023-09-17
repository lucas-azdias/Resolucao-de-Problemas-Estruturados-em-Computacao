package hanoiSolver;

import java.math.BigInteger;

import stack.Stack;

public class Hanoi {
	
	public static final int
		TOWERS_AMOUNT = 3,
		DEFAULT_START_TOWER = 0,
		DEFAULT_END_TOWER = 2,
		DEFAULT_MID_TOWER = 1;
	
	private Stack<Integer>[] towers;
	private int size;
	private boolean isAscendingOrder, showStepsInAutoSolve;
	
	@SuppressWarnings("unchecked")
	public Hanoi(int size, boolean isAscendingOrder, boolean showStepsInAutoSolve) {
		this.size = size;
		this.isAscendingOrder = isAscendingOrder;
		this.showStepsInAutoSolve = showStepsInAutoSolve;
		
		// Initialises all the towers
		towers = (Stack<Integer>[]) new Stack[TOWERS_AMOUNT];
		for (int i = 0; i < TOWERS_AMOUNT; i++) {
			towers[i] = new Stack<Integer>();
		}
		
		// Initialises the first tower elements (contains all the disks in the start)
		if (isAscendingOrder) {
			for (int i = 0; i < size; i++) {
				towers[DEFAULT_START_TOWER].put(size - i);
			}
		} else {
			for (int i = 0; i < size; i++) {
				towers[DEFAULT_START_TOWER].put(i + 1);
			}
		}
	}
	
	public static BigInteger getMinimumMovesToSolve(int size) {
		return BigInteger.TWO.pow(size).subtract(BigInteger.ONE);
	}
	
	public BigInteger getMinimumMovesToSolve() {
		return getMinimumMovesToSolve(size);
	}
	
	public void move(int startTower, int endTower) {
		// Applies a given move in the Tower of Hanoi (if valid)
		if (isMoveValid(startTower, endTower)) {
			int gotten = towers[startTower].get();
			towers[endTower].put(gotten);
		}
	}
	
	public BigInteger solve() {
		// Solves the Tower of Hanoi
		if (!isSolved()) {
			BigInteger moves = BigInteger.ZERO;
			// Restores to original set
			if (!isSolved(DEFAULT_START_TOWER)) {
				moves = solve(size, BigInteger.ZERO, DEFAULT_END_TOWER, DEFAULT_START_TOWER, DEFAULT_MID_TOWER);
			}
			// Solves
			moves = moves.add(solve(size, BigInteger.ZERO, DEFAULT_START_TOWER, DEFAULT_END_TOWER, DEFAULT_MID_TOWER));
			return moves;
		} else {
			return BigInteger.ZERO;
		}
	}
	
	public boolean isMoveValid(int startTower, int endTower) {
		// Returns if the given move is valid according to the chosen order
		if (isTowerValid(startTower) && isTowerValid(endTower)) {
			if (towers[startTower].isEmpty()) {
				return false;
			} else if (towers[endTower].isEmpty()) {
				return true;
			} else if (isAscendingOrder) {
				return towers[startTower].peek() < towers[endTower].peek();
			} else {
				return towers[startTower].peek() > towers[endTower].peek();
			}
		} else {
			return false;
		}
	}
	
	public boolean isSolved() {
		// Returns if the Tower of Hanoi is solved
		return isSolved(DEFAULT_END_TOWER);
	}
	
	public int size() {
		// Returns the size of the Tower of Hanoi
		return size;
	}
	
	public String toString() {
		// Returns the Tower of Hanoi as a string
		String text = "";
		for (int i = 0; i < TOWERS_AMOUNT; i++) {
			text += "| " + (i + 1) + " " + towers[i].toString() + "\n";
		}
		return text;
	}
	
	private BigInteger solve(int n, BigInteger moves, int startTower, int endTower, int midTower) {
		// Solves recursively the Tower of Hanoi
		if (n == 1) {
			move(startTower, endTower);
			moves = moves.add(BigInteger.ONE);
			if (showStepsInAutoSolve) {
				System.out.println(toString());
			}
		} else if (n > 1) {
			moves = solve(n - 1, moves, startTower, midTower, endTower);
			moves = solve(1, moves, startTower, endTower, midTower);
			moves = solve(n - 1, moves, midTower, endTower, startTower);
		} else { // n < 1
			System.out.println("Error when solving the Tower of Hanoi.");
		}
		
		return moves;
	}
	
	private boolean isTowerValid(int tower) {
		// Returns if the given tower is valid
		return tower >= 0 && tower < TOWERS_AMOUNT;
	}
	
	private boolean isSolved(int endTower) {
		// Returns if the Tower of Hanoi is solved for the endTower given
		if (isTowerValid(endTower) && towers[endTower].length() >= size) {
			Stack<Integer> endTowerStack = towers[endTower].copy();
			for (int i = 0; i < towers[endTower].length(); i++) {
				if (isAscendingOrder && endTowerStack.get() != i + 1) {
					return false;
				} else if (!isAscendingOrder && endTowerStack.get() != size - i) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

}
