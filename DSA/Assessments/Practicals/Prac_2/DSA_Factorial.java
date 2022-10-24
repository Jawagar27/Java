import java.util.*;
public class DSA_Factorial {
    public static void main(String[] args) {
		/*System.out.println(factorial(-1));*/
		int n;
       try {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number to find the factorial of it: ");
        n = input.nextInt();
        System.out.println("Output using the iterative algorithm is: "); 
        ifactorial(n);
       System.out.println("Output using the recursive algorithm is: "+ Rfactorial(n)); 
        
       } catch (Exception e) {
        System.out.println("Error in the input taking process!");
       } 

	}

	private static void sayname(int count) {
        /*this code is done to test if recursion implements successfully!*/
		System.out.println("Jawagar");
		if(count <= 1) {
			return;
		}
		sayname(count - 1);
	}
	
	/*code for factorial of numbers in the iterative form*/
	
	public static void ifactorial(int num)throws  IllegalArgumentException{
		
        int value = 1; 

        if (num<= 0) {
            throw new IllegalArgumentException("Input must be greater than and not equal to 0!");
            }
		for(int i = num; i >= 2; i--) {
			
			value *= i;
		}
	System.out.println(value);
	}

    /*Implementation of the factorial function using recursion*/
    public static int Rfactorial(int n)throws IllegalArgumentException{
       
        if (n< 0) {
            throw new IllegalArgumentException("Input must be greater than and not equal to 0!");
            
        }else if (n == 0) {
                return 1;
            
        }else{
               
                return n * Rfactorial(n-1);
            
        }
}
}
