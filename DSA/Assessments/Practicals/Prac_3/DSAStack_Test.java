public class DSAStack_Test {
    
    public static void main(String[] args) {
        DSA_Stack stack = new DSA_Stack();
        test_push(stack);
            test_full(stack);
            test_empty(stack);
       
        
    }

    public static void test_push(DSA_Stack stack){
System.out.println("Testing the push function");
        stack.push(20);
        if (stack.Stack == null) {
            System.out.println("Test failed!\nError in the push function");
        } else {
            System.out.println("puch Test passed!");
        }
    }

    public static  void test_full(DSA_Stack stack){
         /*the array uses 10 elements
          * so 10 values would be entered to check if the array is full orelse
          the test would fail
          */
        System.out.println("Testing the entered elements");
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.display();
        System.out.println("  ");
        System.out.println("Test passed!");
        System.out.println("  ");
      
      

    }
    public static void test_empty(DSA_Stack stack){
        System.out.println("Testing the pop function");

       stack.pop();
       stack.pop();
       stack.pop();
      stack.display();
       System.out.println("  ");
        System.out.println("Test passed!");

   }

   
}
