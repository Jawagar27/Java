import java.util.*;
public class DSA_Nconversions {
    public static void main(String[] args) {
       int n;
       try{
        Scanner DecimalInput = new Scanner(System.in);
        System.out.println("Please enter a decimal value to get the binary value of it: ");
        n = DecimalInput.nextInt();

        System.out.println("Binary value is: " + conversion(n));
       }catch(Exception e){
            
        System.out.println("Error in input taking process");
       
    }
    }

    public static int conversion(int num)throws IllegalArgumentException{

        if (num < 0) {
            throw new IllegalArgumentException("Values cannot be less than 0!");
        }else if (num == 0) {
            return 0;
        }else{
            return(num %2 + 10 * conversion(num/2));
        }
    }
}
