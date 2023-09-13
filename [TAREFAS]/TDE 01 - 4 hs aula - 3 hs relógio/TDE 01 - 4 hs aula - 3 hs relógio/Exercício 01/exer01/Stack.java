package exer01;

public class Stack<T> {
	
	private LinkedList<T> list;
	
	public Stack() {
		this.list = new LinkedList<T>();
	}
	
	public void put(T element) {
		list.append(element);
	}
	
	public T get() {
		if (list.length() > 0) {
			T element = list.get(list.length() - 1);
			list.pop();
			return element;
		} else {
			return null;
		}
	}
	
	public int length() {
		return list.length();
	}
	
	public String toString() {
		return list.toString();
	}

}
