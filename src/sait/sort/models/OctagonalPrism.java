package sait.sort.models;

import sait.sort.contracts.Prism;

/**
 * OctagonalPrism object class
 */
public class OctagonalPrism extends Prism
{
	/**
	 * constructor of OctagonalPrism
	 * @param height - height of OctagonalPrism
	 * @param side - edge length of OctagonalPrism
	 */
	public OctagonalPrism(double height, double side) 
	{
		super(height, side);
	}

	@Override
	public double baseArea() {
	
		return (2 * (1 + Math.sqrt(2)) * this.getSide() * this.getSide());
	}


	@Override
	public double volume() {
		
		return this.baseArea() *this.getHeight();
	}

}
