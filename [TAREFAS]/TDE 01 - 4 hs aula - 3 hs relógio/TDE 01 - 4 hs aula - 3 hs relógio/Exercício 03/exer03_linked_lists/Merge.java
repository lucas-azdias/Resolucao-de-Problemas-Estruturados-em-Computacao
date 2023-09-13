package exer03_linked_lists;

public class Merge {
	
	private Queue queueA, queueB;
	
	public Merge(Queue queueA, Queue queueB) {
		this.queueA = queueA;
		this.queueB = queueB;
	}
	
	public Queue merge() {
		Queue result = new Queue();
		Integer lastA = null, lastB = null;
		do {
			if (lastA == null) {
				lastA = queueA.get();
			}
			if (lastB == null) {
				lastB = queueB.get();
			}
			
			if (lastB == null || (lastA != null && lastA.intValue() <= lastB.intValue())) {
				result.put(lastA);
				lastA = null;
			} else {
				result.put(lastB);
				lastB = null;
			}
		} while(lastA != null || lastB != null);
		return result;
	}
	
}
