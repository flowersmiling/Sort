package sait.sort.models;

import sait.sort.contracts.Shape;

/**
 * Pyramid object class
 */
public class Pyramid extends Shape
{
	/**
	 *edge length of Pyramid 
	 */
	private double edge_length;
	
	/**
	 * construtor of Pyramid
	 * @param height - height of Pyramid
	 * @param edge_length - edge length of Pyramid
	 */
	public Pyramid(double height, double edge_length) 
	{
		super(height);
		this.edge_length = edge_length;
	}
	
	/** 
	* Getter of Pyramid 
	* @return - edge length of Pyramid
	*/
	
	public double getEdge_length() 
	{
		return edge_length;
	}
	
	/** 
	* Setter of Pyramid 
	* @param edge_length - edge length of Pyramid
	*/
	
	public void setEdge_length(double edge_length) 
	{
		this.edge_length = edge_length;
	}
	
	@Override
	public double baseArea() 
	{
		return this.edge_length*this.edge_length;
	}

	@Override
	public double volume() 
	{
		return this.baseArea()*this.getHeight() / 3;
	}

}
