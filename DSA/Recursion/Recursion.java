import java.util.Scanner;
public class Recursion {

	public static void main(String[] args) {
		System.out.println(factorial(-1));
		ifactorial(5);
	}

	private static void sayname(int count) {
		System.out.println("Jawagar");
		if(count <= 1) {
			return;
		}
		sayname(count - 1);
	}
	
	public static long factorial(int n) throws IllegalArgumentException{
	
		long value;
		if(n<0) {
			throw new IllegalArgumentException("Import must not be less than 0");
		}
		else if (n == 0) {
			return 1;
		}
		else {
			value = n * factorial(n - 1);
		}
		return value;
	}
	
	public static void ifactorial(int num){
		int value = 1; 
		for(int i = num; i >= 2; i--) {
			
			value *= i;
		}
	System.out.println(value);
	}

}
