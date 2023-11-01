package hashmap;

public class HashMapBernstein extends HashMap {

	public HashMapBernstein(int size) {
		super(size);
	}

	@Override
	public int hash(int value) {
        return (5381 * 33) ^ value;
	}

}
