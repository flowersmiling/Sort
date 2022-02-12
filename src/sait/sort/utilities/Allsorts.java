package sait.sort.utilities;

import java.util.Comparator;

public class Allsorts 
{
	/** 
	* Selection Sort Algorithm 
	* @param <T> - placeholder of Type
	* @param a - Array to be sorted
	* @param comp - Comparator
	*/
	
	@SuppressWarnings("unchecked")
	public static <T> void selectionSort(Comparable<T>[] a, Comparator<? super T> comp) 
	{
		int n = a.length;
		  
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if ( compare((T)a[j], (T)a[min_idx], comp) > 0 ) //descending order
                    min_idx = j;
  
            // Swap the found minimum element with the first
            // element
            Comparable<T> temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
	}
	
	/** 
	* Bubble Sort Algorithm 
	* @param <T> - placeholder of Type
	* @param a - Array to be sorted
	* @param comp - Comparator
	*/
	
	@SuppressWarnings("unchecked")
	public static <T> void bubbleSort(Comparable<T>[] a, Comparator<? super T> comp)
    {
        int n = a.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (compare((T)a[j], (T)a[j+1], comp) < 0)
                {
                    // swap a[j+1] and a[j]
                	Comparable<T> temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
    }
	
	/** 
	* Insertion Sort Algorithm 
	* @param <T> - placeholder of Type
	* @param arr - Array to be Sorted
	* @param comp - Comparator
	*/
	
	@SuppressWarnings("unchecked")
	public static <T> void insertionSort (Comparable<T>[] arr, Comparator<? super T> comp)
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Comparable<T> key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && compare((T)arr[j], (T)key, comp) < 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
	
	/** 
	* Quick Sort Algorithm 
	* @param <T> - placeholder of Type
	* @param arr - Array to be sorted
	* @param low - Starting index
	* @param high - Ending index
	*/
	
	public static <T> void quickSort(Comparable<T>[] arr, int low, int high, Comparator<? super T> comp)
	{
	    if (low < high)
	    {	         
	        // pi is partitioning index, arr[p]
	        // is now at right place
	        int pi = partition(arr, low, high, comp);
	 
	        // Separately sort elements before
	        // partition and after partition
	        quickSort(arr, low, pi - 1, comp);
	        quickSort(arr, pi + 1, high, comp);
	    }
	}
	
	/** 
	* This function takes last element as pivot, places
   	*the pivot element at its correct position in sorted
   	*array, and places all smaller (smaller than pivot)
   	*to left of pivot and all greater elements to right
   	*of pivot 
	* @param <T> - placeholder of Type
	* @param arr - Array to be sorted
	* @param low - Starting index
	* @param high - Ending index
	* @param comp - Comparator
	* @return - index
	*/
	
	@SuppressWarnings("unchecked")
	static <T> int partition(Comparable<T>[] arr, int low, int high, Comparator<? super T> comp)
	{
	     
	    // pivot
		Comparable<T> pivot = arr[high];
	     
	    // Index of smaller element and
	    // indicates the right position
	    // of pivot found so far
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	         
	        // If current element is smaller
	        // than the pivot
	        if (compare((T)arr[j], (T)pivot, comp) > 0)
	        {
	             
	            // Increment index of
	            // smaller element
	            i++;
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    return (i + 1);
	}
	
	/** 
	* A utility function to swap two elements 
	 * @param <T> - placeholder of Type
	* @param arr - Array to be swapped
	* @param i - first position
	* @param j - second position
	*/
	
	static <T> void swap(Comparable<T>[] arr, int i, int j)
	{
		Comparable<T> temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	/** 
	* Decide what type is compared:Comparble or Comparator
	* @param <T> - placeholder of Type
	* @param a - object a
	* @param b - object b
	* @param comp - Comparator
	* @return int - -1,0,1
	*/
	
	@SuppressWarnings("unchecked")
	private static <T> int compare(T a, T b, Comparator<? super T> comp) 
	{
		if( comp != null )  //Comparator interface
		{
			return comp.compare((T)a, (T)b);
		}else	//Comparable interface
		{
			return ((Comparable<T>)a).compareTo(b);
		}
	}
	
	/** 
	* Main function that sorts arr[l..r] using merge() 
	 * @param <T> - placeholder of Type
	* @param arr - Array to be sorted
	* @param l - start index
	* @param r - end index
	* @param comp - Comparator
	*/
	
	public static <T> void mergeSort(Comparable<T>[] arr, int l, int r, Comparator<? super T> comp)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            mergeSort(arr, l, m, comp);
            mergeSort(arr, m + 1, r, comp);
  
            // Merge the sorted halves
            merge(arr, l, m, r, comp);
        }
    }
	
	/** 
	* Merges two subarrays of arr[] 
	 * @param <T> - placeholder of Type
	* @param arr - Array to be sorted
	* @param l - First subarray is arr[l..m]
	* @param m - Second subarray is arr[m+1..r]
	* @param r - last index
	* @param comp - Comparator
	*/
	
	@SuppressWarnings("unchecked")
	static <T> void merge(Comparable<T>[] arr, int l, int m, int r, Comparator<? super T> comp)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        Object[] L = new Object[n1];
        Object[] R = new Object[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (compare((T)L[i], (T)R[j], comp) > 0) 
            {
                arr[k] = (Comparable<T>) L[i];
                i++;
            }
            else {
                arr[k] = (Comparable<T>) R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = (Comparable<T>) L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = (Comparable<T>) R[j];
            j++;
            k++;
        }
    }
	
	/** 
	* TODO 
	* @param <T> - placeholder of Type
	* @param a - Array to be sorted
	* @param comp - Comparator
	*/
	
	@SuppressWarnings("unchecked")
	public static <T> void shellSort(Comparable<T>[] a, Comparator<? super T> comp)
	{
		int n = a.length;
	
		// Start with a big gap, then reduce the gap
		for (int gap = n/2; gap > 0; gap /=2)
		{
			// Do a gapped insertion sort for this gap size.
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted
			for (int i = gap; i < n; i++)
			{
				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i
				Comparable<T> temp = a[i];
			
				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found
				int j;
				for (j = i; j >= gap && compare((T)a[j - gap], (T)temp, comp) < 0; j -= gap)
					a[j] = a[j - gap];
				
					// put temp (the original a[i]) in its correct
					// location
					a[j] = temp;
			}
		}
	}
}
	

