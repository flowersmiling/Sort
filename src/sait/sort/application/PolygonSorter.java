package sait.sort.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Scanner;

import sait.sort.contracts.BaseAreacomp;
import sait.sort.contracts.Shape;
import sait.sort.contracts.Volumecomp;
import sait.sort.utilities.Allsorts;

public class PolygonSorter 
{
	public static Shape[] Loadpolygonarray(String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException
	{
		FileInputStream inputStream = null;
		Scanner sc = null;
		Shape[] polyArray = null;
		
		inputStream = new FileInputStream(path);
		
        sc = new Scanner(inputStream, "utf-8");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            polyArray = new Shape[Integer.parseInt(arr[0])];
            int k = (arr.length-1) / 3;
            
            for(int i = 0; i < k; i++) {
            	String className = arr[(3*i)+1];
            	double height = Double.parseDouble(arr[(3*i)+2]);
            	double rs = Double.parseDouble(arr[(3*i)+3]);
            	
            	//forName: must use the whole path name of the class
            	Class ref = Class.forName("sait.sort.models."+className);
            	
    			@SuppressWarnings("unchecked")
    			Constructor ct = ref.getConstructor(Double.TYPE, Double.TYPE);
    			
    			polyArray[i] = (Shape) ct.newInstance(height,rs);
            }
        }
		
        inputStream.close();
        sc.close();
        
		return polyArray;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void SortPolygon(Comparable<T>[] array, char compAlgor, char compType) 
	{
		Comparator<? super T> comp;
		long startTime;
		long endTime;
		long totalTime;		
		
		if(compType == 'v') 
		{
			comp = (Comparator<? super T>) new Volumecomp();
		}else if(compType == 'a') {
			comp = (Comparator<? super T>) new BaseAreacomp();
		}else {
			comp = null;
		}
			
		
		//sort array according the compAlgor
		switch (compAlgor) 
		{
			case 'b':
			break;
			case 's':
				startTime = System.currentTimeMillis();
				Allsorts.selectionSort(array, comp);
				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime;
				
				// -ta -ss -f"res\polyfor1".txt
				// test print
				
				System.out.println(array.length);
				
//				System.out.println(((Shape) array[0]).baseArea());
//				System.out.println(((Shape) array[array.length/2]).baseArea());
//				System.out.println(((Shape) array[array.length-1]).baseArea());
				
				System.out.println(((Shape) array[0]).getHeight());
				System.out.println(((Shape) array[array.length/2]).getHeight());
				System.out.println(((Shape) array[array.length-1]).getHeight());
				
//				System.out.println(((Shape) array[0]).volume());
//				System.out.println(((Shape) array[array.length/2]).volume());
//				System.out.println(((Shape) array[array.length-1]).volume());
				
				System.out.println("Spend time:"+totalTime);
			break;
			case 'i':
			break;
			case 'm':
				//Allsorts.mergeSort(array, comp);
			break;
			case 'q':
			break;
			case 'z':
			break;
		}
		
	}
}
