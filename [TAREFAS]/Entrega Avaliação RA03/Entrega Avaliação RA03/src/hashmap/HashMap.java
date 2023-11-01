package hashmap;

public abstract class HashMap {

	private int size, usedPos, collisions;
	private HashMapPair[] table;
	
	public HashMap(int size) {
		this.size = size;
		this.usedPos = 0;
		this.collisions = 0;
		this.table = new HashMapPair[size];
	}
	
	public abstract int hash(int value);
	
	public int rehash(int value) {
		return (value + 1) % size;
	}
	
	public int put(int key, int value) {
		if (!isFull()) {
			int pos = callWFHash(key);
			if (table[pos] != null) {
				do {
					pos = rehash(pos);
					collisions++;
				} while (table[pos] != null);
			}
			table[pos] = new HashMapPair(key, value);
			usedPos++;
			return 0;
		} else {
			return -1;
		}
	}
	
	public Integer get(int key) {
		int pos = getPos(key);
		if (!isEmpty() && pos > 0) {
			return table[pos].getValue();
		} else {
			return null;
		}
	}
	
	public int remove(int key) {
		int pos = getPos(key);
		if (!isEmpty() && pos > 0) {
			table[pos] = null;
			usedPos--;
			return 0;
		} else {
			return -1;
		}
	}
	
	public boolean isEmpty() {
		return usedPos <= 0;
	}
	
	public boolean isFull() {
		return usedPos >= size;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getCollisions() {
		return collisions;
	}
	
	private int getPos(int key) {
		int pos = hash(key);
		for (int i = 0; i < size; i++) {
			if (table[pos] == null) {
				break;
			} else if (table[pos].getKey() == key) {
				return pos;
			} else {
				pos = rehash(pos);
			}
		}
		return -1;
	}
	
	private int callWFHash(int value) { // Well-Formed Hash
		// Aligns the return of the implemented hash function to a index form
		// (positive and not greater than the size of the array)
		return Math.abs(hash(value)) % getSize();
	}
	
}
