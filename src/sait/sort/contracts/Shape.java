package sait.sort.contracts;

import java.lang.Comparable;

/**
 * The super class of all polygon
 */
public abstract class Shape implements Comparable<Shape>
{
	/**
	 *height of shape 
	 */
	private double height;
	
	/** 
	* Calculate the base area of shape 
	* @return - base area
	*/
	
	public abstract double baseArea();
	
	/** 
	* Calculate the volume of shape 
	* @return - volume
	*/
	
	public abstract double volume();

	/**
	 * Constructor of shape
	 * @param height - height of the shape
	 */
	public Shape(double height) 
	{
		super();
		this.height = height;
	}

	/** 
	* Getter of shape 
	* @return return height of shape
	*/
	
	public double getHeight() 
	{
		return height;
	}

	/** 
	* Setter of shape 
	* @param height set height of shape
	*/
	
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
