package sait.sort.utilities;

import java.awt.Shape;
import java.util.Arrays;
import java.util.Comparator;


class MergeSorter {

	  public static <T> void sort(T[] a, Comparator<? super T> comp) {
	    mergeSort(a, 0, a.length - 1, comp);
	  }


	  private static <T> void mergeSort(T[] a, int l, int r, Comparator<? super T> comp) {
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

	  private static <T> void merge(T[] a, int l, int mid, int r, Comparator<? super T> comp) {
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


