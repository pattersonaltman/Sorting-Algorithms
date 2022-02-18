import java.util.Random;

public class MergeSort {

	/*
	 * Merge Sort
	 * 
	 * Methods: 
	 * 	- public static void mergeSort(int[] nums, int left, int right)
	 * 	- public static void merge(int[] nums, int left, int mid, int right)
	 * 
	 * Complexity:
	 * 	- Time Complexity: Sorting arrays on different machines. Merge Sort is a 
	 * 		recursive algorithm and time complexity can be expressed as following 
	 * 		recurrence relation. 
			T(n) = 2T(n/2) + θ(n)

			The above recurrence can be solved either using the Recurrence Tree method or the Master 
			method. It falls in case II of Master Method and the solution of the recurrence 
			is θ(nLogn). Time complexity of Merge Sort is  θ(nLogn) in all 3 cases 
			(worst, average and best) as merge sort always divides the array into two 
			halves and takes linear time to merge two halves.
	 * 
	 * Sources:
	 * 	- https://www.geeksforgeeks.org/merge-sort/
	 * 
	 * Notes:
	 * 
	 * Algorithm:
	 * 	- mergeSort(arr, left, right)
	 * 		-if(left < right) 
	 * 			- mid = left + (right - left) / 2
	 * 			- call mergeSort() on left half: mergeSort(arr, left, mid)
	 * 			- call mergeSort() on right half: mergeSort(arr, (mid + 1), right)
	 * 			- call merge() on left & right halves: merge(arr, left, mid, right)
	 * 	- merge(arr, left, mid, right)
	 * 		- find length for left & right subarrays
	 * 		- create temp arrays for left & right
	 * 		- copy data to left & right temp arrays
	 * 		- merge left & right subarrays, copying the data to the original array, arr[]
	 * 			- (don't forget to clear (add) any possible remaining elements from 
	 * 				the subarrays when merging.)
	 */
	


	
	
	public static void mergeSort(int[] nums, int left, int right) {
		
		if(left < right)
		{
			int mid = left + (right - left) / 2;		// midpoint - to split array at
														/* Marks the 1st and 2nd halves, for this 
														 * current part of the recursion calls */
			
			mergeSort(nums, left, mid);				//recursively split 1st half: [left, mid]
			mergeSort(nums, mid + 1, right);		//recursively split 2nd half: [mid + 1, right]
			
			
			merge(nums, left, mid, right);			/* Merge the 1st and 2nd halves from this 
														current part of the recursion calls */
			
													/*
													 * - The two halves it is merging will be the 
													 * 	  finished halves from the two recursion calls 
													 *    above, [left, mid] and [mid + 1, right].
													 * - Those 2 halves will each already be sorted
													 *    by their respective merge() calls.
													 * - This merge() call will sort & merge those 2
													 *    sorted halves. (Two sorted halves still need 
													 *    to be sorted together when merging into one.)
													 */
		}
	}
	
	
	
	public static void merge(int[] nums, int left, int mid, int right) {
		
		/* Find the sizes of the two subarrays */
		int len1 = mid - left + 1;
		int len2 = right - mid;
		
		/* Create temp arrays (Left, Right) */
		int[] L = new int[len1];
		int[] R = new int[len2];
		
		/* Copy data to temp arrays */
		for(int i = 0; i < len1; i++)
		{
			L[i] = nums[left+i];
		}
		
		for(int i = 0; i < len2; i++)
		{
			R[i] = nums[(mid+1) + i];
		}
		
		/* Merge the subarrays (the data is copied to the original array) */
		int i = 0;
		int j = 0;
		int k = left;							// left/start index on the original array
		while(i < len1 && j < len2)
		{
			if(L[i] <= R[j])					//if next from left subarray is <= next from
			{									//right subarray, nums[k] = L[i].
				nums[k] = L[i];					//Move ahead in L[]
				i++;
			}
			else	//R[j] < L[i]				//else next from right subarray is < next from
			{									//left subarray, nums[k] = R[i].
				nums[k] = R[j];					//Move ahead in R[]
				j++;
			}
			k++;
		}
		
		/* Copy remaining elements of L[], if any */
		while(i < len1)
		{
			nums[k] = L[i];
			i++;
			k++;
		}
		
		/* Copy remaining elements of R[], if any */
		while(j < len2)
		{
			nums[k] = R[j];
			j++;
			k++;
		}
	}
	
	
	
	public static void main(String[] args) {


		int[] nums = new int[20];
		Random rand = new Random();
		
		for(int i = 0; i < nums.length; i++)
		{
			nums[i] = rand.nextInt(101);
		}
		
		System.out.println("Before Merge Sort:\n");
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
				
		System.out.println("\n\nAfter Merge Sort:\n");
		
		mergeSort(nums, 0, nums.length - 1);
		
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
		
	}
	
		
}
