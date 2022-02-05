import java.util.Random;

public class BubbleSort_ShowNumberOfPasses {

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
		
				
		
		nums = bubbleSort_ShowNumberOfPasses(nums);
		
		System.out.println("\n\nAfter Bubble Sort:\n");
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
		
	}
	
	
	
	/*
	 * Method: public static int[] bubbleSort_ShowNumberOfPasses(int[] nums)
	 * 
	 * Notes:
	 * 	- Bubble sort, and shows number of passes in addition.
	 */
	
	public static int[] bubbleSort_ShowNumberOfPasses(int[] nums) {
		
		System.out.println("\n");
		
		int passes = 0;
		boolean swapOccurred = true;	//true to start while loop
		
		while(swapOccurred == true)
		{
			passes++;
			System.out.println("Number of Passes: "+passes);
			
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

}
