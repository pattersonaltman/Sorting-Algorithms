import java.util.Random;

public class SelectionSort {

	/*
	 * Selection Sort
	 * 
	 * Methods: 
	 * 	- public static int[] selectionSort(int[] nums)
	 * 
	 * Complexity:
	 * 	- https://www.geeksforgeeks.org/selection-sort/ 
	 * 		- "Time Complexity: O(n^2) as there are two nested loops."
	 * 			- Although the time complexity should never be O(n^2). The actual time 
	 * 				complexity should always be a Triangular Number series, represented 
	 * 				by the formula: O(n) = n(n+1)/2
	 * 						     = 1 + 2 + 3 + ... n
	 * 
	 * Sources:
	 * 	- https://www.geeksforgeeks.org/selection-sort/
	 * 
	 * Notes:
	 * 	- Continually iterate over the array, finding the minimum in the array and moving 
	 * 		it to the front of the array. With each iteration, the "front" of the array 
	 * 		moves forward 1, towards the end of the array. Moving the minimum value to 
	 * 		the front of the array is done by swapping the front and minimum-value's indices.
	 * 
	 * Algorithm:
	 * 	- for(beginning-n)
	 * 		- x = minimum value in arr
	 * 		- swap arr[beginning] and arr[x]
	 * 		- beginning++
	 * 	- return arr
	 */
	
	
	
	public static int[] selectionSort(int[] nums) {
		
		int minIndex;				//index of current minimum in array
		
		for(int beginning = 0; beginning < nums.length; beginning++)
		{
			minIndex = beginning;		//set min to first element by default
			
			for(int j = beginning + 1; j < nums.length; j++)
			{
				//Find the minimum in the remaining array
				if(nums[j] < nums[minIndex])
				{
					minIndex = j;
				}	
			}
			
			//Place the minimum value at the current beginning of the array by
			//swapping the current beginning index with the current minimum index
			int temp = nums[beginning];
			nums[beginning] = nums[minIndex];
			nums[minIndex] = temp;
		}
		
		return nums;
	}
	
	
	public static void main(String[] args) {

		
		int[] nums = new int[20];
		Random rand = new Random();
		
		for(int i = 0; i < nums.length; i++)
		{
			nums[i] = rand.nextInt(101);
		}
		
		System.out.println("Before Selection Sort:\n");
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
				
		System.out.println("\n\nAfter Selection Sort:\n");
		
		nums = selectionSort(nums);
		
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		

	}

}
