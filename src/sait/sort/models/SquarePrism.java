package sait.sort.models;

import sait.sort.contracts.Prism;

/**
 * SquarePrism object class
 */
public class SquarePrism extends Prism 
{

	/**
	 * constructor of SquarePrism
	 * @param height - height of SquarePrism
	 * @param side - side of SquarePrism
	 */
	public SquarePrism(double height, double side) 
	{
		super(height, side);
	}

	@Override
	public double baseArea() 
	{
		return this.getSide()*this.getSide();
	}

	@Override
	public double volume() {
		return this.baseArea()*this.getHeight();
	}
	
}
