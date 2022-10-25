
	class Sorts {
		/** Bubble sort ------------------------------------------------------ **/
		public static void bubbleSort(int[] A) {
			int pass = 0;
			boolean sorted = false, changed = false;
			int temporary = 0;
			do {
				sorted = true;
				// Assume sorted and change if not true
				for (int i = 0; i < (A.length - 1) - pass; i++) {
					if (A[i] > A[i + 1]) {
						// Then swap
						temporary = A[i]; // temporaryorarily store in variable
						A[i] = A[i + 1];
						A[i + 1] = temporary;
						sorted = false;
						// To continue sorting
					}
				}
				pass++; // Increment to next pass
			} while (!sorted);
		}
	
		/** Selection Sort --------------------------------------------------- **/
		public static void selectionSort(int[] A) {
			int Minimum_index = 0, temporary = 0;
			for (int i = 0; i < A.length; i++) {
				Minimum_index = i;
				for (int j = i + 1; j <= A.length - 1; j++) {
					if (A[j] < A[Minimum_index]) {
						Minimum_index = j;
					}
				}
				temporary = A[Minimum_index];
				A[Minimum_index] = A[i];
				A[i] = temporary;
			}
		}
	
		/** Insertion Sort --------------------------------------------------- **/
		public static void insertionSort(int[] A) {
			int temporary = 0;
			for (int i = 1; i <= A.length - 1; i++) {
				int j = i;
				temporary = A[j];
				while ((j > 0) && (A[j - 1] > temporary)) {
					A[j] = A[j - 1];
					j--;
				}
				A[j] = temporary;
			}
		}
	
		/** Merge Sort ------------------------------------------------------- **/
	
		// Merge Sort Private Recursive Algorithm
		private static void mergeSortRec(int[] A, int Left_index, int Right_index) {
			int Middle_index;
	
			if (Left_index < Right_index) {
				Middle_index = (Left_index + Right_index) / 2;
	
				mergeSortRec(A, Left_index, Middle_index);
				// Recurse Left
				mergeSortRec(A, Middle_index + 1, Right_index);
				// Recurse Right
	
				merge(A, Left_index, Middle_index, Right_index);
			}
	
			// Recursive base case is if the `if` is never entered
		}
	
		// Private Method to Merge Sub-Arrays After Recursion
		private static void merge(int[] A, int Left_index, int Middle_index,
				int Right_index) {
			int[] Temporary_Array = new int[Right_index - Left_index + 1];
			int i = Left_index;
			int j = Middle_index + 1;
			int k = 0;
	
			while ((i <= Middle_index) && (j <= Right_index)) {
				if (A[i] <= A[j]) {
					Temporary_Array[k] = A[i];
					i++;
				} else {
					Temporary_Array[k] = A[j];
					j++;
				}
				k++;
			}
	
			for (int ii = i; i <= Middle_index; i++) {
				// Flush remainder from left sub-array
				Temporary_Array[k] = A[i];
				k++;
			}
	
			for (int jj = j; j <= Right_index; j++) {
				// Flush remainder from right sub-array
				Temporary_Array[k] = A[j];
				k++;
			}
	
			for (int kk = Left_index; kk <= Right_index; kk++) {
				// Place sorted data from Temporary_Array into A
				A[kk] = Temporary_Array[kk - Left_index];
			}
		}
	
		// Wrapper Method for mergeSortRec()
		public static void mergeSort(int[] A) {
			mergeSortRec(A, 0, A.length - 1);
		}
	
		/** Quick Sort | Left-Most Pivot Selection Implementation ------------ **/
		// Wrapper method for Quick_sort_Recursive()
		public static void quickSort(int[] A) {
			Quick_sort_Recursive(A, 0, A.length - 1);
		}
	
		private static void Quick_sort_Recursive(int[] A, int Left_index, int Right_index) {
			int Pivtoted_index;
			int newPivtoted_index;
	
			// Check that the array length is > 1
			if (Right_index > Left_index) {
				Pivtoted_index = Left_index;
				// Left-most pivot selection
				newPivtoted_index = doPartitioning(A, Left_index, Right_index, Pivtoted_index);
	
				Quick_sort_Recursive(A, Left_index, newPivtoted_index - 1);
				// Recurse Left
				Quick_sort_Recursive(A, newPivtoted_index + 1, Right_index);
				// Recurse Right
			}
	
			// Recursive base case is if the `if` is never entered
		}
	
		/** Quick Sort | Median of Three Pivot Selection Implementation ------ **/
		// Wrapper method for Quick_Sort_Median_()
		public static void quickSortMed3(int[] A) {
			Quick_Sort_Median_(A, 0, A.length - 1);
		}
	
		// Recursive algortithm for quick sort
		private static void Quick_Sort_Median_(int[] A, int Left_index, int Right_index) {
			int Pivtoted_index;
			int newPivtoted_index;
	
			// Check that the array length is > 1
			if (Right_index > Left_index) {
				Pivtoted_index = med3(A, Left_index, Right_index, (Left_index + Right_index) / 2);
				// Median of three pivot selection
				newPivtoted_index = doPartitioning(A, Left_index, Right_index, Pivtoted_index);
	
				Quick_sort_Recursive(A, Left_index, newPivtoted_index - 1);
				// Recurse Left
				Quick_sort_Recursive(A, newPivtoted_index + 1, Right_index);
				// Recurse Right
			}
	
			// Recursive base case is if the `if` is never entered
		}
	
		// Find the median of 3 values from given index
		private static int med3(int[] A, int a, int b, int c) {
			int med;
	
			if (A[a] > A[b] && A[a] > A[c]) {
				med = a;
			} else if (A[b] > A[a] && A[b] > A[c]) {
				med = b;
			} else {
				med = c;
			}
	
			return med;
		}
	
		/** Quick Sort | Partitioning Generic Algorithm ----------------------- */
		// Used by left-most and median-of-three quick sorts
		private static int doPartitioning(int[] A, int Left_index, int Right_index,
				int Pivtoted_index) {
			int current_index;
			int pivoted_value;
			int temporary;
			int newPivtoted_index;
	
			// Swap the pivotVal and the right-most element
			pivoted_value = A[Pivtoted_index];
			A[Pivtoted_index] = A[Right_index];
			A[Right_index] = pivoted_value;
	
			// Find all values that are smaller than the pivot and transfer them
			// to the left side of the array
			current_index = Left_index;
	
			for (int i = Left_index; i <= Right_index - 1; i++) {
				if (A[i] < pivoted_value) {
					// Swap i'th and current_index element
					temporary = A[i];
					A[i] = A[current_index];
					A[current_index] = temporary;
	
					current_index++;
				}
			}
	
			newPivtoted_index = current_index;
			A[Right_index] = A[newPivtoted_index];
			A[newPivtoted_index] = pivoted_value;
	
			return newPivtoted_index;
		}
	
		/** Quick Sort | 3-Way ----------------------------------------------- **/
		// Wrapper method for quickSort3WayRec()
		public static void quickSort3Way(int[] A) {
			quickSort3WayRec(A, 0, A.length - 1);
		}
	
		private static void quickSort3WayRec(int[] A, int Left_index, int Right_index) {
			int pivotIdx;
			int temporary;
			int[] ltgt;
	
			if (Left_index < Right_index) {
				pivotIdx = med3(A, Left_index, Right_index, (Left_index + Right_index) / 2);
	
				// Swap left and pivot
				temporary = A[Left_index];
				A[Left_index] = A[pivotIdx];
				A[pivotIdx] = temporary;
	
				ltgt = partition3Way(A, Left_index, Right_index);
	
				quickSort3WayRec(A, Left_index, ltgt[0] - 1);
				quickSort3WayRec(A, ltgt[1] + 1, Right_index);
			}
		}
	
		private static int[] partition3Way(int[] A, int Left_index, int Right_index) {
			int lt = 1;
			int i = 1;
			int gt = Right_index;
			int pivot = A[Left_index];
			int[] ltgt = new int[2];
			int temporary;
	
			while (i <= gt) {
				if (A[i] < pivot) {
					// Swap lt and i
					temporary = A[lt];
					A[lt] = A[i];
					A[i] = temporary;
	
					lt++;
					i++;
				} else if (A[i] > pivot) {
					// Swap i and gt
					temporary = A[i];
					A[i] = A[gt];
					A[gt] = temporary;
	
					gt--;
				} else {
					i++;
				}
			}
	
			ltgt[0] = lt;
			ltgt[1] = gt;
	
			return ltgt;
		}
	
	}