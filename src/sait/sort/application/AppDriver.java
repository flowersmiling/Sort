package sait.sort.application;

import java.util.Scanner;

public class AppDriver {

	public static void main(String[] args) 
	{
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
					System.out.println(cmds[i].charAt(2));
				}
				if(Character.toLowerCase(cmds[i].charAt(1))=='s')
				{
					System.out.println(cmds[i].charAt(2));
				}
				if(Character.toLowerCase(cmds[i].charAt(1))=='f')
				{
					String file = cmds[i].toString().replace("\"", "").substring(2);
					System.out.println(file);
				}
				//System.out.println(cmds[i].toString());
			}
		}
		
		scan.close();

	}

}
