package sait.sort.contracts;

import java.lang.Comparable;

public abstract class Shape implements Comparable<Shape>
{
	private double height;
	
	public abstract double baseArea();
	
	public abstract double volume();

	public Shape(double height) 
	{
		super();
		this.height = height;
	}

	public double getHeight() 
	{
		return height;
	}

	public void setHeight(double height) 
	{
		this.height = height;
	}

	@Override
	public int compareTo(Shape that) 
	{
		if( this.height > that.height )
		{
			return 1;
		}else if( this.height < that.height ) {
			return -1;
		}else
		{
			return 0;
		}
	}
	
}
