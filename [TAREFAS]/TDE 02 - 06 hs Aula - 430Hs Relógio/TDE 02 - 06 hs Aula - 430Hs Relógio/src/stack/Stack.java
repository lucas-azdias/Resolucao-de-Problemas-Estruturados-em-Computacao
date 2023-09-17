package stack;

public class Stack<T> {
	
	private Node<T> tail;
	private int length;
	
	public Stack() {
		this.tail = null;
		this.length = 0;
	}
	
	public void put(T element) {
		// Add a new element at the end of the stack
		// The new tail pointer will point to the previous node
		length++;
		tail = new Node<T>(element, tail); // If tail is null, then is the start node
	}
	
	public T get() {
		// Returns the last element in the stack and removes it
		if (!isEmpty()) {
			// Returns current data and transfers the tail pointer to the previous node
			length--;
			T gotten = tail.getData();
			tail = tail.getNext();
			return gotten;
		} else {
			return null;
		}
	}
	
	public T peek() {
		// Returns the last element in the stack
		if (!isEmpty()) {
			return tail.getData();
		} else {
			return null;
		}
	}
	
	public void empty() {
		// Empties the entire stack
		while (!isEmpty()) {
			get();
		};
	}
	
	public boolean isEmpty() {
		// Verifies if the stack is empty
		return tail == null;
	}
	
	public int length() {
		// Returns the length of the stack
		return length;
	}
	
	@SuppressWarnings("unchecked")
	public Stack<T> copy() {
		// Copies the stack recursively (includes all nested classes)
		int l = length;
		Stack<T> stack = new Stack<T>();
		Object[] data = new Object[l];
		for (int i = 0; i < l; i++) {
			data[i] = get();
		}
		for (int i = 0; i < l; i++) {
			T e = (T) data[l - i - 1];
			put(e);
			stack.put(e);
		}
		return stack;
	}
	
	public String toString() {
		// Returns the stack as a string
		String text = "";
		if (!isEmpty()) {
			Stack<T> stack = copy();
			// Concatenates all strings in inverse order
			for (int i = 0; i < length; i++) {
				text = stack.get().toString() + ", " + text;
			}
			text = text.substring(0, text.length() - 2);
		}
		text = "[" + text + "]";
		return text;
	}

}
