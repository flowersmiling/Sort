package sait.sort.utilities;

import java.util.Comparator;

public class Allsorts 
{
	public static <T> void selectionSort(Comparable<T>[] a, int n, Comparator<? super T> comp)
	{
		for (int index = 0; index < n-1; index++)
		{
			int indexOfNextSmallest = getIndexOfSmallest(a, index, n-1, comp);
			swap(a, index, indexOfNextSmallest);
			// Assertion: a[0] <= a[1] <= . . . <= a[index] <= all other a[i].
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <T> int getIndexOfSmallest(Comparable<T>[] a, int first, int last, Comparator<? super T> comp)
	{
		Comparable<T> min = a[first];
		int indexOfMin = first;
		for (int index = first + 1; index <= last; index++)
		{
			if (comp.compare((T)a[index], (T)min) < 0)
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
