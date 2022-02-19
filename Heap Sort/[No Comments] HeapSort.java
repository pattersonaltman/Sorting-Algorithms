import java.util.Random;

public class HeapSort {

	
	public static void heapSort(int[] arr) {
		
		int size = arr.length;

		for(int i = size / 2 - 1; i >= 0; i--)		
		{
			heapify(arr, size, i);
		}
		
		for(int i = size - 1; i > 0; i--)
		{
			
			int swap = arr[0];
			arr[0] = arr[i];
			arr[i] = swap;
			
			heapify(arr, i, 0);
		}
		
	}
	
	
	public static void heapify(int[] arr, int size, int parent) {
		
		int largest = parent;			
		int left = 2 * parent + 1;		
		int right = 2 * parent + 2;
		
		if(left < size && arr[left] > arr[largest])		
		{
			largest = left;
		}
		
		if(right < size && arr[right] > arr[largest])	
		{
			largest = right;
		}
		
		if(parent != largest)		
		{
			
			int swap = arr[parent];
			arr[parent] = arr[largest];
			arr[largest] = swap;
			
			heapify(arr, size, largest);
		}
	}
	
	
	
	public static void main(String[] args) {

		int[] nums = new int[20];
		Random rand = new Random();
		
		for(int i = 0; i < nums.length; i++)
		{
			nums[i] = rand.nextInt(101);
		}
		
		System.out.println("Before Heap Sort:\n");
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}
		
		
		heapSort(nums);
		
		System.out.println("\n\nAfter Heap Sort:\n");
		for(int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i]+" ");
		}	
		
	}	

}
