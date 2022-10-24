import java.util.Scanner;

class DSACallStack
{
    private static DSA_Stack callStack;

    public static void main(String[] args)
    {
        Scanner Console=new Scanner(System.in);
        System.out.print("Enter a Number to Find its factorial: ");
        int x=Console.nextInt();
        callStack= new DSA_Stack();
        facCheck(x);
    }
    public static long facCheck(int n){
        if ( n < 0)
        {
            throw new IllegalArgumentException("Input should be positive. ");
        }

        else
        {
            return calcNFactorialRecursive(n);
        }
    }

        public static long calcNFactorialRecursive(int n) {
        long factorial = 1;

        if (n == 0) {
            factorial = 1;


        } else {

            factorial = n * calcNFactorialRecursive(n - 1);
            callStack.push(factorial);
            callStack.pop();//Recursive call
            callStack.display();
        }
        System.out.println(factorial);
        return factorial;
    }
}
