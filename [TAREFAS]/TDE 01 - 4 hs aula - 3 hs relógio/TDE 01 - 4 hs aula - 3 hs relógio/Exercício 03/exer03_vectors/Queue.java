package exer03_vectors;

public class Queue {

	private int front;
	private int back;
	private Integer[] array;
	
	Queue(int max_size) {
		this.front = 0;
		this.back = -1;
		this.array = new Integer[max_size];
	}
	
	public void put(Integer element) throws IndexOutOfBoundsException {
		if (!isFull()) {
			back++;
			if (back >= array.length) {
				back = 0;
			}
			array[back] = element;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public Integer get() {
		if (!isEmpty()) {
			Integer gotten = (Integer) array[front];
			array[front] = null;
			if (front == back) {
				front = 0;
				back = -1;
			} else {
				front++;
			}
			if (front >= array.length) {
				front = 0;
			}
			return gotten;
		} else {
			return null;
		}
	}
	
	public boolean isFull() {
		return front == (back + 1) % array.length && back != -1;
	}
	
	public boolean isEmpty() {
		return back <= -1;
	}
	
	public int length() {
		return array.length;
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i < Math.abs(back - front + 1); i++) {
			str += array[i + front % array.length].toString() + " ";
		}
		return str;
	}
	
}
