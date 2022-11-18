import java.util.*;
public class insertionSort {
    
    public static void main(String[] args) {
        
        int[] A = {10,9,25,66,87};
        
        int size = A.length;
        insertion(A, size);
        printArray(A);
    }

    public static void insertion(int[] A, int size){

        for (int i = 0; i < size; i++) {
            
            int temp = A[i];
            int j = i - 1;

            while (j>= 0 && A[j]>temp) {
                A[j+1] = A[j];
                j = j -1;
            }
            A[j + 1] = temp;
        }
    }


    public static void printArray(int[] A) {
    
        for (int i = 0; i < A.length; i++)
         {
            System.out.print(A[i] + " ");
         }
      }

}
