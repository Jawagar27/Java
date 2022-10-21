import java.util.*;
public class DSA_GCD {
    public static void main(String[] args) {
        int n,m;
        try{
         Scanner input = new Scanner(System.in);
         System.out.println("Please enter values to find the greates common denominator: ");
         System.out.println("X: ");
         n = input.nextInt();
         System.out.println("y: ");
         m  = input.nextInt();
 
         System.out.println("Greatest common denominator is: " + Rgcd(n, m));
        }catch(Exception e){
             
         System.out.println("Error in input taking process");
        
     }
       
    }

    public static int Rgcd(int n, int m)throws IllegalArgumentException{
        /*iterative calls to find the greatest common denominator */
        /*Also known as the HCF in normal mathematical terms */
           if (n< 0 || m< 0) {
                throw new IllegalArgumentException("input cannot be 0 or any figure less than that!");
            }else 
            {
                if (m != 0) {
                return Rgcd(m, n%m);
            }else{
                return n;
            }
        
    }
}
}
