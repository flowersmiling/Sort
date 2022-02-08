package sait.sort.utilities;

import java.util.Comparator;

public class Allsorts 
{
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
                if ( comp.compare((T)a[j], (T)a[min_idx]) > 0 ) //descending order
                    min_idx = j;
  
            // Swap the found minimum element with the first
            // element
            Comparable<T> temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
	}
	
	
}
