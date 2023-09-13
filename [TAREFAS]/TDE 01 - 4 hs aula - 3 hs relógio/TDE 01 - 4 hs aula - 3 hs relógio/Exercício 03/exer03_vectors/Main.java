package exer03_vectors;

public class Main {

	public static void main(String[] args) {
		Queue p1 = new Queue(3);
			
		p1.put(Integer.valueOf(5));
		p1.put(Integer.valueOf(9));
		p1.put(Integer.valueOf(18));
			
		System.out.println("\"" + p1 + "\"");
		
		
		Queue p2 = new Queue(3);
			
		p2.put(Integer.valueOf(1));
		p2.put(Integer.valueOf(14));
		p2.put(Integer.valueOf(56));
			
		System.out.println("\"" + p2 + "\"");
		
		
		Queue p = new Merge(p1, p2).merge();
			
		System.out.println("\"" + p + "\"");
	}
}
