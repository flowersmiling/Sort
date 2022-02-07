package sait.sort.contracts;

import java.lang.Comparable;

public abstract class Shape implements Comparable<Shape>
{
	private float height;
	
	public abstract double baseArea();
	
	public abstract double volume();

	public Shape(float height) 
	{
		super();
		this.height = height;
	}

	public float getHeight() 
	{
		return height;
	}

	public void setHeight(float height) 
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
