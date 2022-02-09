package sait.sort.utilities;

import java.util.Comparator;

public class Allsorts 
{
	/** 
	* Selection Sort Algorithm 
	* @param <T>
	* @param a
	* @param comp
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
	* @param <T>
	* @param a
	* @param comp
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
	* @param <T>
	* @param arr
	* @param comp
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
	* @param <T>
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
	* @param <T>
	* @param arr - Array to be sorted
	* @param low - Starting index
	* @param high - Ending index
	* @param comp - Comparator
	* @return
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
	 * @param <T>
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
	* @param <T>
	* @param a
	* @param b
	* @param comp
	* @return int
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
	
	 public static <T> void sort(T[] a, Comparator<? super T> comp) 
	 {
		 //mergeSort(a, 0, a.length - 1, comp);
	 }
	 
	 private <T> void mergeSort(T[] a, int l, int r, Comparator<? super T> comp) 
	 {
		  int mid = (l + r) / 2;
	     //return if array is empty
		  if (r-l<=1){
			  
	      return;
	      }
	        
	    // Sort the first and the second half of the array
		  else{
	    mergeSort(a, l, mid, comp);
	    mergeSort(a, mid + 1, r, comp);
	    merge(a, l, mid, r, comp);
		  }
	  }
	 
	 private <T> void merge(T[] a, int l, int mid, int r, Comparator<? super T> comp) 
	 {
	    int i = r - l + 1;
	    Object[] temp = new Object[i];

	    int left = l;

	    int midValue = mid + 1;

	    int index = 0;
		// merge left side into right side of the array  
	    while (left <= mid && midValue <= r) {
	      if (comp.compare(a[left], a[midValue]) < 0) {
	        temp[index] = a[left];
	        left++;
	      } 
		// merge right side into left side of the array
		else {
	        temp[index] = a[midValue];
	        midValue++;
	      }
	      index++;
	    }

	      //merge all values from left side to temp
	      while (left <= mid) {
	      temp[index] = a[left];
	      left++;
	      index++;
	    }
	   // merge all values from right side to temp
	    while (midValue <= r) {
	      temp[index] = a[midValue];
	      midValue++;
	      index++;
	    }
		  // merge temp into array a
	    for (index = 0; index < i; index++)
	      a[l + index] = (T) temp[index];
	 }
}
	

