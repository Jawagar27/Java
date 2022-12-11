import java.util.*;
public class ChallengeOne {
    

    public static void romanTOInt(int n){
        StringBuilder result = new StringBuilder();
        System.out.println("Entered number: " + n);

        int[] Roman  = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL","X", "IX", "V", "IV", "I"};

        for (int i = 0; i < Roman.length; i++) {
            while (n>=Roman[i]) {
        
                n = n - Roman[i];
                result.append(letters[i]);
            }

        }

        System.out.println("Roman number: "+result.toString());

       
    }


    public static void main(String[] args) {
        int num;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number to get roman number: ");
        num = input.nextInt();
        romanTOInt(num);
    }
}
