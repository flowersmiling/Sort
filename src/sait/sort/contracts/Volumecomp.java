package sait.sort.contracts;

import java.util.Comparator;

public class Volumecomp implements Comparator<Shape>
{

	@Override
	public int compare(Shape s1, Shape s2) 
	{
		if(s1.volume() > s2.volume()) {
			return 1;
		}else if(s1.volume() < s2.volume()) {
			return -1;
		}else {
			return 0;
		}
	}
}
