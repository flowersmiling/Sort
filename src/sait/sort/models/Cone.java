package sait.sort.models;

import sait.sort.contracts.Shape;

/**
 * Cone object class
 */
public class Cone extends Shape
{
	/**
	 *radiu of cone 
	 */
	private double radiu;
	
	/**
	 * constructor of cone
	 * @param height - height of cone
	 * @param radiu - radiu of cone
	 */
	public Cone(double height, double radiu) 
	{
		super(height);
		this.radiu = radiu;
	}
	
	/** 
	* Getter of cone 
	* @return - radiu of cone
	*/
	
	public double getRadiu() 
	{
		return radiu;
	}
	
	/** 
	* Setter of cone 
	* @param radiu- radiu of cone
	*/
	
	public void setRadiu(double radiu) 
	{
		this.radiu = radiu;
	}

	@Override
	public double baseArea() 
	{
		return Math.PI*this.radiu*this.radiu;
	}

	@Override
	public double volume() 
	{
		return this.baseArea()*this.getHeight()/3;
	}
}
