package sait.sort.application;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Entry into the program.
 */
public class AppDriver {

	/** 
	* TODO 
	* @param args - main method args
	* @throws ClassNotFoundException - an application tries to load in a class through itsstring name using
	* @throws InstantiationException - an application tries to create an instance of a classusing the newInstance 
	* @throws IllegalAccessException - an application triesto reflectively create an instance 
	* @throws NoSuchMethodException - a particular method cannot be found
	* @throws SecurityException - to indicate a security violation
	* @throws IllegalArgumentException - a method has been passed an illegal orinappropriate argument.
	* @throws InvocationTargetException - wrapsan exception thrown by an invoked method or constructor. 
	* @throws IOException - produced by failed orinterrupted I/O operations
	*/
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException 
	{
		char type = ' ';
		char algo = ' ';
		String path = "";
		boolean isContinue = true;
		String input = null;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the Search Command: Type yes for contiue, ? for help, quit to exit");
		
		
		while(isContinue) 
		{
			input = scan.next();
			
			if(input.equals("yes")) {
				System.out.println("Please enter the Search Command: ");
				
				Scanner incmd = new Scanner(System.in);
				String strComd = incmd.nextLine();
				
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
				
				PolygonSorter.SortPolygon(PolygonSorter.Loadpolygonarray(path), algo, type);
				
				incmd.close();
				isContinue = false;
			}else if(input.equals("?"))
			{
				Message();
				System.out.println("Please enter the Search Command: Type yes for contiue, ? for help, quit to exit");
			}else if(input.equals("quit")) {
				isContinue = false;
				System.out.println("Thanks for using!");
			}else
			{
				System.out.println("Please enter the Search Command: Type yes for contiue, ? for help, quit to exit");
			}
		}
			
		scan.close();
	}
	
	/** 
	* command line arguments manual  
	*/
	
	public static void Message() 
	{
		System.out.println("[Syntax:] -t[h|v|a] -s[b|s|m|q|z] -f[path]");
		System.out.println("-t:compare type, v is volume, h is height, a is base area");
		System.out.println("-s:algorithm name, b is bubble, s is selection, i is insertion,\r\n"
				+ "m is merge,q is quick, z is some algorithm ^-^");
		System.out.println("-f:the path of the data file");
	}

}
