import java.util.Random;

public class HeapSort {

	/* 
	 * Heap Sort
	 *  
	 * Methods:
	 * 	- public static void heapSort(int[] arr)
	 * 	- public static void heapify(int[] arr, int size, int parent)
	 *  
	 * Complexity: 
	 * 	- "Heapify a single node takes O(log N) time complexity where N is the total 
	 * 		number of Nodes."
	 * 	- "Therefore, building the entire Heap will take N heapify operations and the 
	 * 		total time complexity will be O(N*logN)."
	 * 	- "In reality, building a heap takes O(n) time depending on the implementation ..."
	 *  
	 * Sources: 
	 * 	- https://www.geeksforgeeks.org/heap-sort/
	 *  
	 * Notes: 
	 * 	- 1st for loop of heapSort():
	 * 		- size / 2 - 1 = parent node of the last leaf node
	 * 		- if using index-value instead of size-value (arr.length - 1 , instead 
	 * 			of arr.length), formula changes to:  parent node = (size - 1) / 2
	 *  
	 * Algorithm: 
	 * 	+ heapSort(arr)
	 * 		- for( i = [parent of last leaf node, root] )
	 * 			- heapify(arr, arr.size, i)
	 * 		- for( end = [last leaf node, root) )
	 * 			- swap end and root
	 * 			- heapify(arr, end, root)
	 * 
	 * 	+ heapify(arr, size, parent)
	 * 		- largest (index) = parent (by default)
	 * 		- left child (index) = 2 * parent + 1
	 * 		- right child (index) = 2 * parent + 2
	 * 		- if( left child exists in tree && is > arr[largest] )
	 * 			- largest = left
	 * 		- if( right child exits in tree && is > arr[largest] )
	 * 			- largest = right
	 * 		- if( parent != largest )
	 * 			- swap parent and largest
	 * 			- heapify(arr, size, largest)
	 */ 

	
	
	
	public static void heapSort(int[] arr) {
		
		int size = arr.length;

		/* Build max heap, from bottom up */
		for(int i = size / 2 - 1; i >= 0; i--)		// size / 2 - 1 = parent of the last leaf node
		{
			heapify(arr, size, i);
		}
		
		for(int i = size - 1; i > 0; i--)
		{
			/* Swap current root and end (end decrements by 1 each time) */
			int swap = arr[0];
			arr[0] = arr[i];
			arr[i] = swap;
			
			/* Call heapify on root, (2nd arg is 'i' and not 'size', since the size is decrementing) */
			heapify(arr, i, 0);
		}
		
	}
	
	
	public static void heapify(int[] arr, int size, int parent) {
		
		/* Initialize largest to parent by default */
		/* Initialize left & right children */
		int largest = parent;			
		int left = 2 * parent + 1;		//largest, left, & right are indices, not values
		int right = 2 * parent + 2;
		
		if(left < size && arr[left] > arr[largest])		//if left child exists && is > arr[largest]
		{
			largest = left;
		}
		
		if(right < size && arr[right] > arr[largest])	//if right child exists && is > arr[largest]
		{
			largest = right;
		}
		
		if(parent != largest)		//if parent node wasn't the largest node ...
		{
			/* Swap parent node and largest node */
			int swap = arr[parent];
			arr[parent] = arr[largest];
			arr[largest] = swap;
			
			/* Perform heapify on largest node (before swap occurred) */
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
