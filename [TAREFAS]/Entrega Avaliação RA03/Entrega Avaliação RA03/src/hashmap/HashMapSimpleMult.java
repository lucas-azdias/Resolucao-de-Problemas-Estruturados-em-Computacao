package hashmap;

public class HashMapSimpleMult extends HashMap {

	public HashMapSimpleMult(int size) {
		super(size);
	}

	@Override
	public int hash(int value) {
        return value * 5381;
	}

}
