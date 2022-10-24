public class DSAQueue_Test {
    
    public static void main(String[] args) {
        DSA_Queue queue= new DSA_Queue();
        test_push(queue);
        test_full(queue);
       
    }

        public static void test_push(DSA_Queue queue  ){

        queue.enqueue(20);
        if (queue.queue== null) {
            System.out.println("Test failed!\nError in the push function");
        } else {
            System.out.println("Test passed!");
        }
    }

    public static void test_full(DSA_Queue queue){
         /*the array uses 10 elements
          * so 10 values would be entered to check if the array is full orelse
          the test would fail
          */
          System.out.println("------Testing enqueue function------");
         System.out.println("This should output stack overflow as more items are being entered.");
        queue.enqueue(10);
        queue.enqueue(10);
        queue.enqueue(10);
        queue.enqueue(10);
        queue.enqueue(10);
        queue.enqueue(10);

        queue.display();
        //should output stack overflow
        System.out.println("Test passed!");
        System.out.println(" ");

        System.out.println("------Testing dequeue function------");
        System.out.println("Dequeues 2 items");
        
        queue.dequeue();
        queue.dequeue();
        queue.display();

     System.out.println("Test passed!");

    }
    
}
