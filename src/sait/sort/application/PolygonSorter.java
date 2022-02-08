package sait.sort.application;

import java.util.Comparator;

import sait.sort.contracts.BaseAreacomp;
import sait.sort.contracts.Shape;
import sait.sort.contracts.Volumecomp;
import sait.sort.utilities.Allsorts;

public class PolygonSorter 
{
	public static Shape[] Loadpolygonarray(String inputStr)
	{
		//load txt file to array (use Reflection) 
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void SortPolygon(Comparable<T>[] array, String compAlgor, String compType) 
	{
		Comparator<? super T> comp;
		
		if(compType == "v") 
		{
			comp = (Comparator<? super T>) new Volumecomp();
		}else if(compType == "a") {
			comp = (Comparator<? super T>) new BaseAreacomp();
		}else {
			comp = null;
		}
			
		
		//sort array according the compAlgor
		switch (compAlgor) 
		{
			case "b":
			break;
			case "s":
				Allsorts.selectionSort(array, 0, comp);
			break;
			case "i":
			break;
			case "m":
			break;
			case "q":
			break;
			case "z":
			break;
		}
		
	}
}
