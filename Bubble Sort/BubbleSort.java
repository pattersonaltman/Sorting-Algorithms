import java.util.Random;

public class BubbleSort {

	/*
	 * Bubble Sort:
	 * 
	 * Complexity:
	 * 		- Worst and Average Case Time Complexity: O(n*n). 
	 * 			Worst case occurs when array is reverse sorted.
	 * 		- Best Case Time Complexity: O(n). 
	 * 			Best case occurs when array is already sorted.
	 * 
	 * Notes:
	 * 	- https://www.geeksforgeeks.org/bubble-sort/
	 */
	
	public static void main(String[] args) {


		int[] nums = new int[20];
		Random rand = new Random();
		
		for(int i = 0; i < nums.length; i++)
		{
			nums[i] = rand.nextInt(101);
		}
		
		System.out.println("Before Bubble Sort:\n");
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
				
		
		nums = bubbleSort(nums);
		
		System.out.println("\n\nAfter Bubble Sort:\n");
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
		
	}
	
	
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

}	//End Class
