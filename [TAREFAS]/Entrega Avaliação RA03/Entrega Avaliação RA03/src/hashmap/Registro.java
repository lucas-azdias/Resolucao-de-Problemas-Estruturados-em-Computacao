package hashmap;

public class Registro {
	
	private int size;
	private int[] digits;
	
	public Registro(int size) {
		this.size = size;
		this.digits = new int[size];
	}
	
	public void setDigits(int[] digits) {
		for (int i = 0; i < size; i++) {
			this.digits[i] = digits[i];
		}
	}
	
	public int getValue() {
		int value = 0;
		for (int i = 0; i < size; i++) {
			value += digits[i] * (Math.pow(10, size - i - 1));
		}
		return value;
	}
	
}
