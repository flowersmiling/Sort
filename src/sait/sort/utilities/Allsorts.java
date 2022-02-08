package sait.sort.utilities;

import java.util.Comparator;

public class Allsorts 
{
	public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n, Comparator<? super T> comp)
	{
		for (int index = 0; index < n-1; index++)
		{
			int indexOfNextSmallest = getIndexOfSmallest(a, index, n-1, comp);
			swap(a, index, indexOfNextSmallest);
			// Assertion: a[0] <= a[1] <= . . . <= a[index] <= all other a[i].
		}
	}
	
	private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last, Comparator<? super T> comp)
	{
		T min = a[first];
		int indexOfMin = first;
		for (int index = first + 1; index <= last; index++)
		{
			if (comp.compare(a[index], min) < 0)
			{
				min = a[index];
				indexOfMin = index;
			}
		// Assertion: min is the smallest of a[first] through a[index].
		}
		
		return indexOfMin;
	}
	
	// Swaps the array entries a[i] and a[j].
	 private static void swap(Object[] a, int i, int j)
	 {
		 Object temp = a[i];
		 a[i] = a[j];
		 a[j] = temp;
	 }
}
