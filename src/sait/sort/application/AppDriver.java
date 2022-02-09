package sait.sort.application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class AppDriver {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException 
	{
		char type = ' ';
		char algo = ' ';
		String path = "";
		
		Scanner scan = new Scanner(System.in);
		String strComd = scan.nextLine();
		
		if( strComd != "" && strComd != null ) 
		{
			//replace more than one space or tab with one space, split the string to array with one space
			String[] cmds = strComd.replaceAll("\\s+", " ").split(" ");
			
			for(int i = 0; i < cmds.length; i++) 
			{
				if(Character.toLowerCase(cmds[i].charAt(1))=='t') 
				{
					type = cmds[i].charAt(2);
				}
				if(Character.toLowerCase(cmds[i].charAt(1))=='s')
				{
					algo = cmds[i].charAt(2);
				}
				if(Character.toLowerCase(cmds[i].charAt(1))=='f')
				{
					path = cmds[i].toString().replace("\"", "").substring(2);
				}
			}
		}else 
		{
			System.out.println("Please enter the Search Command or Type ? for help");
		}
		
		scan.close();
		
		PolygonSorter.SortPolygon(PolygonSorter.Loadpolygonarray(path), algo, type);
	}

}
