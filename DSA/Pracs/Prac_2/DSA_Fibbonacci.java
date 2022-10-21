import java.util.*;
public class DSA_Fibbonacci {
    public static void main(String[] args) {
       
        int n;
        try{
         Scanner input = new Scanner(System.in);
         System.out.println("Please enter a decimal value to get the fibonacci value of it: ");
         n = input.nextInt();
 
         System.out.println("Fibonacci through recursive algorithm: " + Rfibbonacci(n));
         System.out.println("Fibonacci through iterative algorithm: ");
         Ifibbonacci(n);
        }catch(Exception e){
             
         System.out.println("Error in input taking process");
        
    }
}
/*Code for the recursive implementation of fibbonacci numbers*/
    public static int Rfibbonacci(int n)throws IllegalArgumentException{

        if (n<= 1) {
            return n;
        }
        return (Rfibbonacci(n-1) + Rfibbonacci(n-2));
    }
/*Code for the iterative implementation of fibbonacci numbers*/
    public static void Ifibbonacci(int n)throws IllegalArgumentException{

        int num1 = 1;
        int num2 = 1;
        int counter = 0;

        while (counter < n) {
            System.out.print(num1 + " ");
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }
    }
}
