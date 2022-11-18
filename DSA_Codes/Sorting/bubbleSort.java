public class bubbleSort{

    public static void main(String[] args) {
        int[] A = {10, 25, 35,3,2,100};
        bubble(A);
        printArray(A);
    }

    public static int[] bubble(int[] A){
        int temp;

         /*forloops to finish swapping one element and then move onto the next element */
        for (int j = 0; j < A.length; j++) {
           
            for (int i = 0; i < A.length - 1; i++) {
            
            if (A[i] > A[i + 1]) {
                
                temp = A[i];
                A[i] = A[i + 1];        /*code to swap the elements in the array */
                A[i + 1] = temp;
            }

        }
    }
    return A;
}

public static void printArray(int[] A) {
    
    for (int i = 0; i < A.length; i++)
     {
        System.out.print(A[i] + " ");
     }
  }

}