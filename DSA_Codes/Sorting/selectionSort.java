/**
 * selectionSort
 */
public class selectionSort {

    public static void main(String[] args) {
        int[] A = {7,4,10,8,3,1};
        selection(A);
        printArray(A);
    }

    public static void selection(int[] A){

        for (int i = 0; i < A.length -1; i++) {
            int min = i;
        
            for (int j = i + 1; j < A.length; j++) {

                
                    if (A[min]>A[j]) {  //we sheck if the value is greater than any of the sorted values
                        //if so it swaps the position among them
                        
                        min = j;

                        int temp = A[min];
                        A[min] = A[i];
                        A[i] = temp;
                    }

            
            }
        }
    }


    public static void printArray(int[] A) {
    
        for (int i = 0; i < A.length; i++)
         {
            System.out.print(A[i] + " ");
         }
      }
}