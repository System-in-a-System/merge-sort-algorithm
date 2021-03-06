import java.util.Comparator;


public class MergeSort {
	
	
	// Recursive method to carry out merge sort on the array of integers
	
	// Merge sort algorithm divides the array into two halves 
	// and applies a merge sort on each half recursively.
	// After the two halves are sorted, they are to be merged.
	public static int[] mergeSort(int[] in) {
			
		
		// Create a safe copy of the input array (original input array shall not be mutated)
		int[] arrCopy = new int[in.length];
			
		for (int i = 0; i < arrCopy.length; i++) 
			arrCopy[i] = in[i];

			
		// Set the base case to terminate the recursion
		if (arrCopy.length <= 1) 
			return arrCopy;
		

			
		// Locate the middle point and divide the current array in halves
		int middlePoint = arrCopy.length / 2;
		int[] arr1 = new int[middlePoint];
		int[] arr2 = new int[arrCopy.length - arr1.length];

		
		// Populate the first half
		for (int i = 0; i < arr1.length; i++) 
			arr1[i] = arrCopy[i];
			
		// Populate the second half
		for (int i = 0; i < arr2.length; i++) 
			arr2[i] = arrCopy[middlePoint++];
			

		// Recursively divide & update arr1 and arr2
		arr1 = mergeSort(arr1); 
		arr2 = mergeSort(arr2);

			
			
		// Sort & Merge subarrays back into a common array:
			
		// Set initial indexes for arrays
		int index1 = 0; // index for arr1 
		int index2 = 0; // index for arr2
		int index = 0; // index for common gathering arrCopy

		// Compare & Sort & Save into arrCopy
		while (index1 < arr1.length && index2 < arr2.length) {
		
			if (arr1[index1] < arr2[index2])
				arrCopy[index++] = arr1[index1++];
					
			else 
				arrCopy[index++] = arr2[index2++];
			
		}
			
			
			// Take care of possible remnants
			while (index1 < arr1.length)
				arrCopy[index++] = arr1[index1++];
			

			while (index2 < arr2.length)
				arrCopy[index++] = arr2[index2++];


			return arrCopy;
			
	}
	
	
	
	
	// Recursive method to carry out merge sort on the array of strings
	
	// Merge sort algorithm divides the array into two halves 
	// and applies a merge sort on each half recursively.
	// After the two halves are sorted, they are to be merged.
				
	public static String[] mergeSort(String[] in, Comparator<String> c) {
			
		// Create a safe copy of the input array (original input array shall not be mutated)
		String[] arrCopy = new String[in.length];
					
		for (int i = 0; i < arrCopy.length; i++) 
			arrCopy[i] = in[i];

					
		// Set the base case to terminate the recursion
		if (arrCopy.length <= 1) 
			return arrCopy;
		

					
		// Locate the middle point and divide the current array in halves
		int middlePoint = arrCopy.length / 2;
		String[] arr1 = new String[middlePoint];
		String[] arr2 = new String[arrCopy.length - arr1.length];

		// Populate the first half
		for (int i = 0; i < arr1.length; i++) 
			arr1[i] = arrCopy[i];
					

		// Populate the second half
		for (int i = 0; i < arr2.length; i++) 
			arr2[i] = arrCopy[middlePoint++];
					

		// Recursively divide & update arr1 and arr2
		arr1 = mergeSort(arr1, c); 
		arr2 = mergeSort(arr2, c);

					
					
		// Sort & Merge subarrays back into a common array:
					
		// Set initial indexes for arrays
		int index1 = 0; // index for arr1 
		int index2 = 0; // index for arr2
		int index = 0; // index for common gathering arrCopy

		// Compare & Sort & Save into arrCopy
		while (index1 < arr1.length && index2 < arr2.length) {
				
			if (c.compare(arr1[index1], arr2[index2]) < 0) 
				arrCopy[index++] = arr1[index1++];
							
			else 
				arrCopy[index++] = arr2[index2++];
		
		}
				
			
		// Take care of possible remnants
		while (index1 < arr1.length) 
			arrCopy[index++] = arr1[index1++];
			

		while (index2 < arr2.length) 
			arrCopy[index++] = arr2[index2++];
			

		return arrCopy;
	}
	
	

	
	// Program starting point
	public static void main(String[] args) {
		
		
		// Testing merge sort on the array of integers ---------------------------------------------------//
		
		// Initialize a new array & Implement merge sort on it and safe the result into a new array
		int[] originalArray = {7, 10, 9, 4, 1, -20, -7, 6, 15, 17};
		int[] mergeSortedArray = mergeSort(originalArray);
		
		
		// Print out the original array
		for (int i = 0; i < originalArray.length; i++)
			System.out.print(originalArray[i] + " ");
		 
		// Break line
		System.out.println();
		
		// Print out the sorted array		
		for (int i = 0; i < mergeSortedArray.length; i++)
			System.out.print(mergeSortedArray[i] + " ");
		
		// Break line
		System.out.println();
		
		
		// Testing merge sort on the array of strings ---------------------------------------------------//
		
		// Initialize a new array & Implement merge sort on it and safe the result into a new array
		String [] originalArrayStr = {"bc", "a", "hijkl", "defg", "mnopqrs"};
		Comparator<String> compareByLength =  (s1, s2) -> s1.length() - s2.length();
		String[] mergeSortArrayStr = mergeSort(originalArrayStr, compareByLength);
		
		
		
		// Print out the original array
		for (int i = 0; i < originalArrayStr.length; i++)
			System.out.print(originalArrayStr[i] + " ");
		 
		// Break line
		System.out.println();
		
		// Print out the sorted array
		for (int i = 0; i < mergeSortArrayStr.length; i++)
			System.out.print(mergeSortArrayStr[i] + " ");

	}

}
