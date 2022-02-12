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
	/** 
	* Load the data file into array 
	* Generates the objects using reflection 
	* @param path - data file path
	* @return - Shape object array
	* @throws ClassNotFoundException
	* @throws InstantiationException
	* @throws IllegalAccessException
	* @throws NoSuchMethodException
	* @throws SecurityException
	* @throws IllegalArgumentException
	* @throws InvocationTargetException
	* @throws IOException
	*/
	
	@SuppressWarnings("rawtypes")
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
	
	/** 
	* Invoke kinds of sort algorithm to sort array 
	* @param <T> - placeholder of Type
	* @param array - array to be sorted
	* @param compAlgor - algorithm to be choose:b is bubble, s is selection, i is insertion, m is merge, q is quick, z is self-choose.
	* @param compType - type to be compared:v is volume, h is height, a is base area
	*/
	
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
				startTime = System.currentTimeMillis();
				Allsorts.bubbleSort(array, comp);
				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime;
				System.out.println("Spend time(Millisecond): "+totalTime);
				showResult(array, compType);
								
				// -ts -sb -f"res\polyfor1".txt
			break;
			case 's':
				startTime = System.currentTimeMillis();
				Allsorts.selectionSort(array, comp);
				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime;
				System.out.println("Spend time(Millisecond): "+totalTime);
				showResult(array, compType);
				
				// -ta -ss -f"res\polyfor1".txt
			break;
			case 'i':
				startTime = System.currentTimeMillis();
				Allsorts.insertionSort(array, comp);
				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime;
				System.out.println("Spend time(Millisecond): "+totalTime);
				showResult(array, compType);
				
				// -th -si -f"res\polyfor1".txt
			break;
			case 'm':
				startTime = System.currentTimeMillis();
				Allsorts.mergeSort(array,0,array.length-1,comp);
				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime;
				System.out.println("Spend time(Millisecond): "+totalTime);
				showResult(array, compType);
				
				// -tv -sm -f"res\polyfor1".txt
			break;
			case 'q':
				startTime = System.currentTimeMillis();
				Allsorts.quickSort(array, 0, array.length-1, comp);
				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime;
				System.out.println("Spend time(Millisecond): "+totalTime);
				showResult(array, compType);
				
				// -tv -sq -f"res\polyfor1".txt
			break;
			case 'z':
				startTime = System.currentTimeMillis();
				Allsorts.shellSort(array, comp);
				endTime = System.currentTimeMillis();
				totalTime = endTime - startTime;
				System.out.println("Spend time(Millisecond): "+totalTime);
				showResult(array, compType);

				// -tv -sz -f"res\polyfor1".txt
			break;
		}
		
	}
	
	/** 
	* TODO 
	* @param <T>- placeholder of Type
	* @param array - array been sorted
	* @param compType - Comparator
	*/
	
	private static <T> void showResult(Comparable<T>[] array, char compType) 
	{
		if(compType == 'v') {
			System.out.println("first stored value: "+((Shape) array[0]).volume());
			System.out.println("last stored value: "+((Shape) array[array.length-1]).volume());
			System.out.println("every thousandth value: ");
			for(int i=999;i<array.length;i+=1000) {
				System.out.println(((Shape) array[i]).volume());
			}
		}else if(compType == 'a') {
			System.out.println("first stored value: "+((Shape) array[0]).baseArea());
			System.out.println("last stored value: "+((Shape) array[array.length-1]).baseArea());
			System.out.println("every thousandth value: ");
			for(int i=999;i<array.length;i+=1000) {
				System.out.println(((Shape) array[i]).baseArea());
			}
		}else {
			System.out.println("first stored value: "+((Shape) array[0]).getHeight());
			System.out.println("last stored value: "+((Shape) array[array.length-1]).getHeight());
			System.out.println("every thousandth value: ");
			for(int i=999;i<array.length;i+=1000) {
				System.out.println(((Shape) array[i]).getHeight());
			}
		}
	}
}
