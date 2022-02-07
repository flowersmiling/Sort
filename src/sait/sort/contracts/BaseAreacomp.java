package sait.sort.contracts;

import java.util.Comparator;

public class BaseAreacomp implements Comparator<Shape> 
{

	@Override
	public int compare(Shape s1, Shape s2) 
	{
		if(s1.baseArea() > s2.baseArea()) {
			return 1;
		}else if(s1.baseArea() < s2.baseArea()) {
			return -1;
		}else {
			return 0;
		}
	}
}
