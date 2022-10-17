import java.util.*;
public class Main {

	public static void main(String[] args) {

	

		Queuetest test = new Queuetest();
		
		test.enqueue(0);
		test.enqueue(20);
		test.enqueue(30);
		test.enqueue(40);
		test.dequeue();
		test.display();

	}
}
