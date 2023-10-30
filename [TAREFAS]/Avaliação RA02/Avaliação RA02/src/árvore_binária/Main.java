package árvore_binária;

import java.util.Random;

public class Main {
	
	public static long testTImsert(long seed, int times) {
		long startTime, endTime;
		int[] values = new int[times];
		Random rand = new Random(seed);
		BinaryTree t = new BinaryTree();
		
		for (int i = 0; i < times; i++) {
			values[i] = rand.nextInt();
		}
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			t.insert(values[i]);
		}
		endTime = System.currentTimeMillis();
		
		return endTime - startTime;
	}
	
	public static long testTRemove(long seed, int times) {
		long startTime, endTime;
		int[] values = new int[times];
		Random rand = new Random(seed);
		BinaryTree t = new BinaryTree();
		
		for (int i = 0; i < times; i++) {
			values[i] = rand.nextInt();
			t.insert(values[i]);
		}
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			t.remove(values[i]);
		}
		endTime = System.currentTimeMillis();
		
		return endTime - startTime;
	}
	
	public static long testTSearch(long seed, int times) {
		long startTime, endTime;
		int[] values = new int[times];
		Random rand = new Random(seed);
		BinaryTree t = new BinaryTree();
		
		for (int i = 0; i < times; i++) {
			values[i] = rand.nextInt();
			t.insert(values[i]);
		}
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			t.getNode(values[i]);
		}
		endTime = System.currentTimeMillis();
		
		return endTime - startTime;
	}
	
	public static long testTAvlImsert(long seed, int times) {
		long startTime, endTime;
		int[] values = new int[times];
		Random rand = new Random(seed);
		BinaryTreeAVL t = new BinaryTreeAVL();
		
		for (int i = 0; i < times; i++) {
			values[i] = rand.nextInt();
		}
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			t.insert(values[i]);
		}
		endTime = System.currentTimeMillis();
		
		return endTime - startTime;
	}
	
	public static long testTAvlRemove(long seed, int times) {
		long startTime, endTime;
		int[] values = new int[times];
		Random rand = new Random(seed);
		BinaryTreeAVL t = new BinaryTreeAVL();
		
		for (int i = 0; i < times; i++) {
			values[i] = rand.nextInt();
			t.insert(values[i]);
		}
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			t.remove(values[i]);
		}
		endTime = System.currentTimeMillis();
		
		return endTime - startTime;
	}
	
	public static long testTAvlSearch(long seed, int times) {
		long startTime, endTime;
		int[] values = new int[times];
		Random rand = new Random(seed);
		BinaryTreeAVL t = new BinaryTreeAVL();
		
		for (int i = 0; i < times; i++) {
			values[i] = rand.nextInt();
			t.insert(values[i]);
		}
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			t.getNode(values[i]);
		}
		endTime = System.currentTimeMillis();
		
		return endTime - startTime;
	}

	public static void main(String[] args) {
		long seed = (new Random()).nextLong();
		int[] testTimes = {100, 500, 1000, 10000, 20000};
		
		for (int i = 0; i < 5; i++) {
			System.out.println(
					"Teste sem AVL com inserção de " +
					testTimes[i] +
					" vezes demorou " +
					testTImsert(seed, testTimes[i]) +
					"ms."
			);
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(
					"Teste sem AVL com remoção de " +
					testTimes[i] +
					" vezes demorou " +
					testTRemove(seed, testTimes[i]) +
					"ms."
			);
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(
					"Teste sem AVL com busca de " +
					testTimes[i] +
					" vezes demorou " +
					testTSearch(seed, testTimes[i]) +
					"ms."
			);
		}
		System.out.println();
		
		System.out.println("----------------------------------------\n");
		
		for (int i = 0; i < 5; i++) {
			System.out.println(
					"Teste com AVL com inserção de " +
					testTimes[i] +
					" vezes demorou " +
					testTAvlImsert(seed, testTimes[i]) +
					"ms."
			);
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(
					"Teste com AVL com remoção de " +
					testTimes[i] +
					" vezes demorou " +
					testTAvlRemove(seed, testTimes[i]) +
					"ms."
			);
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(
					"Teste com AVL com busca de " +
					testTimes[i] +
					" vezes demorou " +
					testTAvlSearch(seed, testTimes[i]) +
					"ms."
			);
		}
		System.out.println("\nEnd");
		
		// Obs.: Faltou o duplo balanceamento em casos de joelho
		//		 (quando há inversão de sinal na escalada da árvore)
	}

}
