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
		  
		  if (r-l<=1)
	      return;
	        
	    // Sort the first and the second half
	    mergeSort(a, l, mid, comp);
	    mergeSort(a, mid + 1, r, comp);
	    merge(a, l, mid, r, comp);
	  }

	  private static <T> void merge(T[] a, int l, int mid, int r, Comparator<? super T> comp) {
	    int i = r - l + 1;
	    Object[] values = new Object[i];

	    int left = l;

	    int midValue = mid + 1;

	    int index = 0;

	    while (left <= mid && midValue <= r) {
	      if (comp.compare(a[left], a[midValue]) < 0) {
	        values[index] = a[left];
	        left++;
	      } else {
	        values[index] = a[midValue];
	        midValue++;
	      }
	      index++;
	    }

	    while (left <= mid) {
	      values[index] = a[left];
	      left++;
	      index++;
	    }
	    while (midValue <= r) {
	      values[index] = a[midValue];
	      midValue++;
	      index++;
	    }

	    for (index = 0; index < i; index++)
	      a[l + index] = (T) values[index];
	  }
	}


