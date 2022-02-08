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
	
	
	public class MergeSorter {

		  public <T> void sort(T[] a, Comparator<? super T> comp) {
		    mergeSort(a, 0, a.length - 1, comp);
		  }


		  private <T> void mergeSort(T[] a, int l, int r, Comparator<? super T> comp) {
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

		  private <T> void merge(T[] a, int l, int mid, int r, Comparator<? super T> comp) {
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
	
	

