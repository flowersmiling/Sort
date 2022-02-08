package sait.sort.application;

import java.io.File;
import java.io.FileNotFoundException;
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
	public static Shape[] Loadpolygonarray(String path) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		Scanner input = null;
		File newFile = new File(path);
		Shape[] polyArray = null;
		int size = 0;
		String className = "";
		double height = 0;
		double rs = 0;
		
		if (!newFile.exists()) {
		    System.out.println("Data file does not exists");		      
		    System.exit(0);
		}
		else 
		{
			input = new Scanner( newFile );
			polyArray = new Shape[input.nextInt()];
		}
		
		while( input.hasNext() ) {
			className = input.next();
			height = input.nextDouble();
			rs = input.nextDouble();
			
			Class ref = Class.forName(className);
			Class paramTypes[] = new Class[1];
			paramTypes[0] = Double.TYPE;
			paramTypes[1] = Double.TYPE;
			
			@SuppressWarnings("unchecked")
			Constructor ct = ref.getConstructor(paramTypes);
			Object args[] = new Object[1];
			args[0] = new Double( height );
			args[1] = new Double( rs );
			
			polyArray[size] = (Shape) ct.newInstance(args);
			size++;
		}
		
		input.close();
		return polyArray;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void SortPolygon(Comparable<T>[] array, char compAlgor, char compType) 
	{
		Comparator<? super T> comp;
		
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
				Allsorts.selectionSort(array, comp);
				// -ta -ss -f"res\polyfor1".txt
				System.out.println(array.length);
				System.out.println("Spend time:");
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
