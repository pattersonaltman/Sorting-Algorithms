import java.util.Random;

public class RadixSort {
	
	
	/*
	 * Radix Sort
	 * 
	 * Methods: 
	 * 	- public static int[] radixSort(int[] nums)
	 * 	- public static int getDigit(int num, int digit)
	 * 	- public static int[] bubbleSort(int[] nums)
	 * 
	 * Complexity:
	 * 	- What is the running time of Radix Sort? 
	 * 		Let there be d digits in input integers. Radix Sort takes O(d*(n+b)) time 
	 * 		where b is the base for representing numbers, for example, for the decimal 
	 * 		system, b is 10. What is the value of d? If k is the maximum possible 
	 * 		value, then d would be O(logb(k)). So overall time complexity is 
	 * 		O((n+b) * logb(k)).
	 * 			- The (n+b) in O(d*(n+b)), comes from Counting Sort's complexity. This 
	 * 				implementation of radix sort uses Bubble Sort (a comparison sort) 
	 * 				instead of Counting Sort, so the time complexity is not the sam
	 * 
	 * Sources:
	 * 	- https://www.geeksforgeeks.org/radix-sort/
	 * 
	 * Notes:
	 * 	- Uses an improvised implementation of Bubble Sort to do the stable-sorting of 
	 * 		nums, for each incrementation of its individual digits.
	 * 
	 * Algorithm:
	 * 	- for(0-9)  (loop over the digits we will be looking at for each element in nums)
	 * 		- use improvised Bubble Sort to re-sort nums, according to the current digit
	 * 	- return nums
	 */
	
	public static int[] radixSort(int[] nums) {
		
		// Create for loop to iterate over getting each digit from numbers in nums
		for(int digit = 0; digit <= 9; digit++)		//Why for(0-9)? ---> Code Constraint/Limit: 2,147,483,647 --> int data type won't need to/be able to hold values past 10 (9-index) digits
		{
			// Now use an improvised implementation of Bubble Sort to repeatedly sort nums, according to the individual digits.
			
			//----------- Bubble Sort (Improvised) | Start -----------

			boolean swapOccurred = true;	//true to start while loop
			
			while(swapOccurred == true)
			{
				swapOccurred = false;		//start off false
				
				for(int i = 0; i < nums.length - 1; i++)
				{
					//Compare using the current digit of the elements in nums
					//Change the actual values/indices in nums (not just the singular digits)
					
					int x = getDigit(nums[i], digit);		// x = nums[i], current digit
					int y = getDigit(nums[i+1], digit);		// y = nums[i+1], current digit
					
					if(x > y)
					{
						//Swap and set swapOccurred boolean
						int temp = nums[i];
						nums[i] = nums[i+1];
						nums[i+1] = temp;
						swapOccurred = true;	//bubble sort will require another pass
					}
				}
			}
			
			//----------- Bubble Sort (Improvised) | End -----------
		}
		
		return nums;
	}
	
	
	/*
	 * Helper Methods:
	 * 
	 * 	- public static int getDigit(int num, int digit)
	 * 	- public static int[] bubbleSort(int[] nums)
	 * 		- Stable-sorting method
	 * 		- Not actually used for direct function calling. Implemented in an 
	 * 			improvised version, inside of radixSort().
	 * 		- Included method into file just for easy reference.
	 */
	
	
	
	
	/*
	 * Method: public static int getDigit(int num, int digit)
	 * 
	 * Notes:
	 * 	- int digit - the digit you are intending to get in [num], 0-indexed (1's place = 0, 10's place = 1, ...)
	 */
	public static int getDigit(int num, int digit) {
		
		int placeValue = 1;		// 0's place = 1, 10's place = 10, 100's place = 100, ...
		
		for(int i = 0; i < digit; i++)
		{
			placeValue *= 10;
		}
		
		return num / placeValue % 10;
	}
	
	
	
	
	
	// Need stable-sorting method to be a part of Radix-sort, --> choosing to using Bubble Sort.
	
	/*
	 * Method: public static int[] bubbleSort(int[] nums)
	 * 
	 * Notes:
	 * 	- Algorithm needs to have one full pass with no swaps to know it is completed.
	 * 
	 * Algorithm:
	 * 	- set swap boolean to true to initiate while loop
	 * 		- while:
	 * 			- set swap boolean back to false until a swap occurs
	 * 			- for i to 2nd-to-last index
	 * 				- if nums[i] > nums[i+1]
	 * 					- swap nums[i] and nums[i+1]
	 * 					- set swap boolean, another pass will be required
	 */
	public static int[] bubbleSort(int[] nums) {
		
		boolean swapOccurred = true;	//true to start while loop
		
		while(swapOccurred == true)
		{
			swapOccurred = false;		//start off false
			
			for(int i = 0; i < nums.length - 1; i++)
			{
				if(nums[i] > nums[i+1])
				{
					//Swap and set swapOccurred boolean
					int temp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = temp;
					swapOccurred = true;	//bubble sort will require another pass
				}
			}
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
		
		System.out.println("Before Radix Sort:\n");
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
				
		System.out.println("\n\nAfter Radix Sort:\n");
		
		nums = radixSort(nums);
		
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
		
	}
	
	

	

}
