package exer02;

public class Main {

	public static void main(String[] args) {
		Queue p = new Queue();

		for (int i = 0; i < 100; i++) {
			System.out.println("Teste " + (i + 1));
			
			p.put(Integer.valueOf(5));
			p.put(Integer.valueOf(9));
			p.put(Integer.valueOf(18));
			
			System.out.println("\"" + p + "\"");
			
			p.get();
			System.out.println("\"" + p + "\"");
			
			p.get();
			System.out.println("\"" + p + "\"");
			
			p.get();
			System.out.println("\"" + p + "\"");
		}
	}
}
