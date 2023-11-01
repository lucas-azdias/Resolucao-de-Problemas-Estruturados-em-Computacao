package sorting;

public class Sorting {
	
	public static int totalSwaps = 0;
	public static int totalIters = 0;
	
	public static void bubbleSort(int[] values, int size) {
		totalSwaps = 0;
		totalIters = 0;
		boolean hasChanged = false;
		do {
			hasChanged = false;
			for (int i = 0; i < size - 1; i++) {
				if (values[i] > values[i + 1]) {
					swapValues(values, i, i + 1);
					hasChanged = true;
					totalSwaps++;
				}
				totalIters++;
			}
		} while(hasChanged);
	}
	
	public static void mergeSort(int[] values, int size) {
		totalSwaps = 0;
		totalIters = 0;
		merge(values, 0, getMergeMiddle(0, size - 1), size - 1);
	}
	
	public static void quickSort(int[] values, int size) {
		totalSwaps = 0;
		totalIters = 0;
		quick(values, 0, size - 1);
	}
	
	private static void merge(int[] values, int start, int middle, int end) {
		int start1 = start, start2 = middle + 1, end1 = middle, end2 = end;
		int amount1 = getMergeAmount(start1, end1), amount2 = getMergeAmount(start2, end2);
		
		// Calls to sort each half (recursive part)
		if (amount1 > 2) {
			merge(values, start1, getMergeMiddle(start1, end1), end1);
		} else if (amount1 == 2) {
			if (values[start1] > values[end1]) {
				swapValues(values, start1, end1);
				totalSwaps++;
			}
		}
		if (amount2 > 2) {
			merge(values, start2, getMergeMiddle(start2, end2), end2);
		} else if (amount2 == 2) {
			if (values[start2] > values[end2]) {
				swapValues(values, start2, end2);
				totalSwaps++;
			}
		}

		// Gets a copy of the current values for the substitution
		int[] oldValues = new int[getMergeAmount(start, end)];
		for (int i = 0; i < getMergeAmount(start, end); i++) {
			oldValues[i] = values[i + start];
		}
		
		// Loops and merges the results
		int cur = start, cur1 = start1 - start, cur2 = start2 - start;
		do {
			if (oldValues[cur1] <= oldValues[cur2]) {
				values[cur] = oldValues[cur1];
				cur1++;
			} else {
				values[cur] = oldValues[cur2];
				cur2++;
			}
			cur++;
			totalIters++;
		} while(cur1 < amount1 + (start1 - start) && cur2 < amount2 + (start2 - start));
		
		// Writes the remains of one side
		if (cur1 < amount1) {
			for (int i = 0; i < amount1 - cur1; i++) {
				values[cur + i] = oldValues[cur1 + i];
			}
		} else if (cur2 < amount2) {
			for (int i = 0; i < amount2 - cur2; i++) {
				values[cur + i] = oldValues[cur2 + i];
			}
		}
	}
	
	private static void quick(int[] values, int start, int end) {
		int curStart = start, curEnd = end;
		int midValue = values[(curStart + curEnd) / 2];
		while (curStart <= curEnd) {
			while (values[curStart] < midValue) {
				// While in right order, goes to the centre by the left
				curStart++;
			}
			while (values[curEnd] > midValue) {
				// While in right order, goes to the centre by the right
				curEnd--;
			}
			if (curStart <= curEnd) {
				// If the incongruence is the wrong order, then invert the values
				swapValues(values, curStart, curEnd);
				curStart++;
				curEnd--;
				totalSwaps++;
			}
			totalIters++;
		}

		// If hadn't passed through the entire vector, then passes
		if (start < curEnd) {
			quick(values, start, curEnd);
		}
		if (curStart < end) {
			//
			quick(values, curStart, end);
		}
	}
	
	private static void swapValues(int[] values, int indexA, int indexB) {
		int a = values[indexA];
		values[indexA] = values[indexB];
		values[indexB] = a;
	}
	
	private static int getMergeMiddle(int a, int b) {
		return (int) Math.floor((double) (a + b) / 2);
	}
	
	private static int getMergeAmount(int indexA, int indexB) {
		return indexB - indexA + 1;
	}

}
