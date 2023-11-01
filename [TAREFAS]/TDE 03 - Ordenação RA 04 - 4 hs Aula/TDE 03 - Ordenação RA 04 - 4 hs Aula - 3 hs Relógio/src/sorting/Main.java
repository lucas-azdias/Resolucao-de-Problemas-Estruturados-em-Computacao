package sorting;

import java.util.Random;

public class Main {
	
	public static void bubbleTest(long seed, int times) {
		long startTime, endTime;
		int[] values = new int[times];
		Random rand = new Random(seed);
		
		for (int i = 0; i < times; i++) {
			values[i] = rand.nextInt();
		}

		startTime = System.currentTimeMillis();
		Sorting.bubbleSort(values, times);
		endTime = System.currentTimeMillis();
		//for (int i = 0; i < times; i++) System.out.println(values[i]);
		
		System.out.println(
				"Teste de ordenação com Bubble Sort\n" +
				"\tTimes: " +
				times +
				"\tDeltaTime: " +
				(endTime - startTime) +
				"ms" +
				"\tTotalIters: " +
				Sorting.totalIters +
				"\tTotalSwaps: " +
				Sorting.totalSwaps +
				"\tTotalIters relative: " +
				(Math.round(100 * (double) Sorting.totalIters / times)) + "%" +
				"\tTotalSwaps relative: " +
				(Math.round(100 * (double) Sorting.totalSwaps / times)) + "%"
		);
	}
	
	public static void mergeTest(long seed, int times) {
		long startTime, endTime;
		int[] values = new int[times];
		Random rand = new Random(seed);
		
		for (int i = 0; i < times; i++) {
			values[i] = rand.nextInt();
		}

		startTime = System.currentTimeMillis();
		Sorting.mergeSort(values, times);
		endTime = System.currentTimeMillis();
		//for (int i = 0;i < times; i++) System.out.println(values[i]);
		
		System.out.println(
				"Teste de ordenação com Merge Sort\n" +
				"\tTimes: " +
				times +
				"\tDeltaTime: " +
				(endTime - startTime) +
				"ms" +
				"\tTotalIters: " +
				Sorting.totalIters +
				"\tTotalSwaps: " +
				Sorting.totalSwaps +
				"\tTotalIters relative: " +
				(Math.round(100 * (double) Sorting.totalIters / times)) + "%" +
				"\tTotalSwaps relative: " +
				(Math.round(100 * (double) Sorting.totalSwaps / times)) + "%"
		);
	}
	
	public static void quickTest(long seed, int times) {
		long startTime, endTime;
		int[] values = new int[times];
		Random rand = new Random(seed);
		
		for (int i = 0; i < times; i++) {
			values[i] = rand.nextInt();
		}

		startTime = System.currentTimeMillis();
		Sorting.quickSort(values, times);
		endTime = System.currentTimeMillis();
		//for (int i = 0;i < times; i++) System.out.println(values[i]);
		
		System.out.println(
				"Teste de ordenação com Quick Sort\n" +
				"\tTimes: " +
				times +
				"\tDeltaTime: " +
				(endTime - startTime) +
				"ms" +
				"\tTotalIters: " +
				Sorting.totalIters +
				"\tTotalSwaps: " +
				Sorting.totalSwaps +
				"\tTotalIters relative: " +
				(Math.round(100 * (double) Sorting.totalIters / times)) + "%" +
				"\tTotalSwaps relative: " +
				(Math.round(100 * (double) Sorting.totalSwaps / times)) + "%"
		);
	}
	
	public static void main(String[] args) {
		long seed = (new Random()).nextLong();
		int[] testTimes = {
				50,
				500,
				1000,
				5000,
				10000
		};
		
		for (int i = 0; i < 5; i++) {
			bubbleTest(seed, testTimes[i]);
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			mergeTest(seed, testTimes[i]);
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			quickTest(seed, testTimes[i]);
		}
		System.out.println();
		
		System.out.println("End.");
	}

}
