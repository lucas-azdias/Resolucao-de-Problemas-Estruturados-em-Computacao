package exer03_linked_lists;

public class Queue {
	
	private LinkedList<Integer> list;
	
	public Queue() {
		this.list = new LinkedList<Integer>();
	}
	
	public void put(Integer element) {
		list.append(element);
	}
	
	public Integer get() {
		if (list.length() > 0) {
			Integer element = list.get(0);
			list.remove(0);
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
