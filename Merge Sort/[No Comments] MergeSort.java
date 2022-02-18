import java.util.Random;

public class MergeSort {

	
	public static void mergeSort(int[] nums, int left, int right) {
		
		if(left < right)
		{
			int mid = left + (right - left) / 2;									
			
			mergeSort(nums, left, mid);				
			mergeSort(nums, mid + 1, right);		
		
			merge(nums, left, mid, right);									
		}
	}
	
	
	public static void merge(int[] nums, int left, int mid, int right) {
			
		int len1 = mid - left + 1;
		int len2 = right - mid;
		
		int[] L = new int[len1];
		int[] R = new int[len2];
		
		for(int i = 0; i < len1; i++)
		{
			L[i] = nums[left+i];
		}
		
		for(int i = 0; i < len2; i++)
		{
			R[i] = nums[(mid+1) + i];
		}
		
		int i = 0;
		int j = 0;
		int k = left;							
		while(i < len1 && j < len2)
		{
			if(L[i] <= R[j])					
			{									
				nums[k] = L[i];					
				i++;
			}
			else	
			{									
				nums[k] = R[j];					
				j++;
			}
			k++;
		}
		
		while(i < len1)
		{
			nums[k] = L[i];
			i++;
			k++;
		}
		
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
