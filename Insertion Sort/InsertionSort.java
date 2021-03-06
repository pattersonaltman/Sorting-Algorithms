import java.util.Random;

public class InsertionSort {

	/*
	 * Insertion Sort:
	 * 
	 * Complexity:
	 * 		- Worst case: O(n^2)
	 * 			Insertion sort takes maximum time to sort if elements are sorted in 
	 * 			reverse order.
	 * 		- Best case: O(n)
	 * 			Minimum time (Order of n) when elements are already sorted.
	 * 
	 * Notes:
	 * 	- https://www.geeksforgeeks.org/insertion-sort/
	 */
	
	public static void main(String[] args) {


		int[] nums = new int[20];
		Random rand = new Random();
		
		for(int i = 0; i < nums.length; i++)
		{
			nums[i] = rand.nextInt(101);
		}
		
		System.out.println("Before Insertion Sort:\n");
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
				
		
		nums = insertionSort(nums);
		
		System.out.println("\n\nAfter Insertion Sort:\n");
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
		
	}
	
	
	public static int[] insertionSort(int[] nums){
		
		for(int i = 1; i < nums.length; i++)
		{
			int current = nums[i];		//save current
			int j = i-1;				
			
			if(nums[i] >= nums[j])		//leave alone any that are >= to index behind
			{
				continue;
			}
			
			//loop & compare until we reach the current num's correct position
			while(j > 0 && nums[i] < nums[j-1])
			{	
				j--;
			}
			
			// Set current num in it's place and increment rest ahead by 1
				
				//increment necessary indices by 1 ( [j+1, i] )
			for(int k = i; k > j; k--)
			{
				nums[k] = nums[k-1];
			}
			
				//Set current num
			nums[j] = current;
		}
		
		return nums;
	}

}
