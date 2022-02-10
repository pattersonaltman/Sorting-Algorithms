import java.util.Random;

public class RadixSort {
	
	public static int[] radixSort(int[] nums) {
		
		for(int digit = 0; digit <= 9; digit++)		
		{
			boolean swapOccurred = true;	
			
			while(swapOccurred == true)
			{
				swapOccurred = false;		
				
				for(int i = 0; i < nums.length - 1; i++)
				{
					int x = getDigit(nums[i], digit);		
					int y = getDigit(nums[i+1], digit);		
					
					if(x > y)
					{
						int temp = nums[i];
						nums[i] = nums[i+1];
						nums[i+1] = temp;
						swapOccurred = true;	
					}
				}
			}
		}
		
		return nums;
	}
	
	
	public static int getDigit(int num, int digit) {
		
		int placeValue = 1;		
		
		for(int i = 0; i < digit; i++)
		{
			placeValue *= 10;
		}
		
		return num / placeValue % 10;
	}
	
	
	public static int[] bubbleSort(int[] nums) {
		
		boolean swapOccurred = true;	
		
		while(swapOccurred == true)
		{
			swapOccurred = false;		
			
			for(int i = 0; i < nums.length - 1; i++)
			{
				if(nums[i] > nums[i+1])
				{
					int temp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = temp;
					swapOccurred = true;	
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
