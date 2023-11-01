package hashmap;

public class HashMapDJB2 extends HashMap {

	public HashMapDJB2(int size) {
		super(size);
	}

	@Override
	public int hash(int value) {
        return ((5381 << 5) + 5381) + value;
	}

}
