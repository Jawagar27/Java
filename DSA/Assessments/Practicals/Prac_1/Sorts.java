
	import java.io.*;
	import java.util.*;
	public class Sorts {

		 public static void main(String[] args) {
		    	FileInputStream FIS = null;
				InputStreamReader ISR;
				BufferedReader br;
				String line;
				int linenum;
				int[] values = new int[7001];
				
				try{
					FIS = new FileInputStream("C:/Users/Jawagar/Downloads/RandomNames7000(2).csv");
					ISR = new InputStreamReader(FIS);
					br = new BufferedReader(ISR);
					line = br.readLine();
					linenum = 0;
					
						while(line != null) {
							
							String[] data = line.split(",");
							values[linenum] = Integer.parseInt(data[0]);
							line = br.readLine();
							linenum++;
							}
						bubbleSort(values);
						selectionSort(values);
						insertionSort(values);
						processLine(values);
						
						FIS.close();
				}catch(IOException e) {
					if(FIS != null) {
						try {
							FIS.close();
						}catch(IOException e2) {
							
						}
					System.out.println("Error in file reading: " + e.getMessage());
					}
				}
		   
				
				
			
			}
			
		    
		    
		    private static void processLine(int[] array) {
				
				
				
				FileOutputStream filestream = null;
		    	PrintWriter pw;
				
				
			try {	
				
				
				
				filestream = new FileOutputStream("C:/Users/Jawagar/Desktop/Sorts.csv");
		    	pw = new PrintWriter(filestream);
		    	
		    	for(int i = 0; i<array.length; i++) {
		    		pw.println("ID"+i+":" + "," + array[i]);
		    	}
		    	
		    	pw.close();
				
				
				System.out.println("File writing done!" );

			}catch(IOException e) {
				if(filestream != null) {
			    	try {
			    		filestream.close();
			    	}catch(IOException e1) {
			    		
			    	}
				System.out.println("Error in file processing: " + e.getMessage());
			}
			}
				
			}
			// bubble sort
		    public static void bubbleSort(int[] A)
		    {
		    	int size = A.length;
				
				for(int i = 0; i<size - 1; i++) {
					for(int j = 0; j<size - 1; j++) {
						if(A[j]> A[j + 1]) {
							int temp = A[j];
							A[j] = A[j + 1];
							A[j+1] = temp;
							
						}
					}
				}
		    }//bubbleSort()

		    // selection sort
		    public static void selectionSort(int[] A)
		    {
		    	int size = A.length;
		    	for(int step = 0; step<size - 1; step++) {
		    		int min = step;
		    		
		    		for(int i = step + 1; i<size; i++) {
		    			
		    			if(A[i] < A[min]) {
		    				
		    				min = i;
		    			}
		    		}
		    		int temp = A[step];
		    	      A[step] = A[min];
		    	      A[min] = temp;
		    	}
		    	
		    }// selectionSort()

		    // insertion sort
		    public static void insertionSort(int[] A)
		    {
		    	
		    	int size = A.length;

		        for (int step = 1; step < size; step++) {
		          int key = A[step];
		          int j = step - 1;

		          // Compare key with each element on the left of it until an element smaller than
		          // it is found.
		          // For descending order, change key<array[j] to key>array[j].
		          while (j >= 0 && key < A[j]) {
		            A[j + 1] = A[j];
		            --j;
		          }

		          // Place key at after the element just smaller than it.
		          A[j + 1] = key;
		        }
		    }// insertionSort()

		    // mergeSort - front-end for kick-starting the recursive algorithm
		    public static void mergeSort(int[] A)
		    {
			
					
				
		    }//mergeSort()
		    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
		    {
				int mid;
				if (leftIdx<rightIdx) {
					mid = (leftIdx+rightIdx)/2;

					mergeSortRecurse(A, leftIdx, mid);/*code to recursively partition the left side */
					mergeSortRecurse(A, mid+1, rightIdx);/*code to recursively partition the right side */
					merge(A, leftIdx, mid, rightIdx);/*vode to merge both the ends into a sorted array */
				}
		    }//mergeSortRecurse()
		    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
		    {int i,j,k;
				

								i = leftIdx;
				j = midIdx +1;
				k = leftIdx;
				int[]b = null;;

				while (i<= j && j<= rightIdx) {
					
					if (A[i]<= A[j]) {
						b[k] = A[i];
						i++;
						
					}else{
						b[k] = A[j];
						j++;
						 
					}

					k++;
				}

				if (i>midIdx) {
					 while (j<= rightIdx) {
						
						b[k] = A[j];
						j++;
						k++;
					 }
				}else{
						while (i<= midIdx) {
							b[k] = A[i]; 
							i++;
						}
				}

		    }//merge()




		    // quickSort - front-end for kick-starting the recursive algorithm
		    public static void quickSort(int[] A)
		    {
				int left = 0; //initialise the right and lefts
				int right = A.length-1;
				quickSortRecurse(A, left, right); //pass it to recurse function
		    }//quickSort()
		    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
		    {
				int pivot;
				if (rightIdx>leftIdx) {
					
					pivot = leftIdx;
				}
				int newpivotIdx = doPartitioning(A, leftIdx, rightIdx,leftIdx );
				quickSortRecurse(A, leftIdx, newpivotIdx-1); //sort left partition
				quickSortRecurse(A, newpivotIdx+1, rightIdx); //sort right partition
		    }//quickSortRecurse()
		    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
		    {/*swapping the pivot element with the right most element */
				int pivotval = A[pivotIdx];
				A[pivotIdx] = A[rightIdx];
				A[rightIdx] = pivotval;
					
				int curr = leftIdx;

				for (int i = leftIdx; i <=  rightIdx-1; i++) {
					
					if (A[i]< pivotval) {
						int temp = A[i];
						A[i] = A[curr];
						A[curr] = temp;
						curr = curr++; 
					}
				}

				int newpivotIdx = curr;
				A[rightIdx] = A[newpivotIdx];
				A[newpivotIdx] = pivotval;
				return newpivotIdx;	// TEMP - Replace this when you implement QuickSort
		    }//doPartitioning

	}
