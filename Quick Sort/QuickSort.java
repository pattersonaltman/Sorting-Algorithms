import java.util.Random;

public class QuickSort {

	/*
	 * Quick Sort:
	 * 
	 * Complexity:
	 * 		- Time taken by QuickSort, in general, can be written as following. 
 				T(n) = T(k) + T(n-k-1) + \theta(n)
 				
 			- Worst Case: The worst case occurs when the partition process always picks greatest or smallest element as pivot. If we consider above partition strategy where last element is always picked as pivot, the worst case would occur when the array is already sorted in increasing or decreasing order. Following is recurrence for worst case. 
				T(n) = T(0) + T(n-1) + \theta(n)
				
				which is equivalent to  
				
				T(n) = T(n-1) + \theta(n)
				
				The solution of above recurrence is  \theta(n^2).
				
			- Best Case: The best case occurs when the partition process always picks the middle element as pivot. Following is recurrence for best case. 
				T(n) = 2T(n/2) + \theta(n)
				 
				The solution of above recurrence is \theta(nLogn).
				
			- Average Case: 
				To do average case analysis, we need to consider all possible permutation of array and calculate time taken by every permutation which doesn’t look easy. 
				We can get an idea of average case by considering the case when partition puts O(n/9) elements in one set and O(9n/10) elements in other set. Following is recurrence for this case. 
				
				T(n) = T(n/9) + T(9n/10) + \theta(n)
				 
				Solution of above recurrence is also O(nLogn)
	 * 
	 * Notes:
	 * 	- https://www.geeksforgeeks.org/quick-sort/
	 * 		- "The key process in quickSort is partition(). Target of partitions is, 
	 * 			given an array and an element x of array as pivot, put x at its 
	 * 			correct position in sorted array and put all smaller elements 
	 * 			(smaller than x) before x, and put all greater elements (greater than 
	 * 			x) after x. All this should be done in linear time."
	 * 		- "Pseudo code for partition()  
				   This function takes last element as pivot, places
				   the pivot element at its correct position in sorted
				   array, and places all smaller (smaller than pivot)
				   to left of pivot and all greater elements to right
				   of pivot"
	 */
	
	public static void main(String[] args) {

		
		
		int[] nums = new int[20];
		Random rand = new Random();
		
		for(int i = 0; i < nums.length; i++)
		{
			nums[i] = rand.nextInt(101);
		}
		
		System.out.println("Before Quick Sort:\n");
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
				
		System.out.println("\n\nAfter Quick Sort:\n");
		
		quickSort(nums, 0, nums.length - 1);
		
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
		
		
		
	}

	
	
	public static void quickSort(int[] nums, int low, int high) {
		
		if(low < high)
		{
			int partitionIndex = partition(nums, low, high);
			
			quickSort(nums, low, partitionIndex - 1);
			quickSort(nums, partitionIndex + 1, high);
		}
		
	}
	
	
	
	public static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		
		int i = low - 1;
		
		for(int j = low; j <= high - 1; j++)
		{
			if(arr[j] < pivot)
			{
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
	}

}
