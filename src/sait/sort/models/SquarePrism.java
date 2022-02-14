package sait.sort.models;

import sait.sort.contracts.Prism;

/**
 * SquarePrism object class
 */
public class SquarePrism extends Prism 
{
	//don't need to declare private fields height and side,
	//they would be inherited from parent class Prism.
	//if declare private fields height and side at here, it would 
	//get a SquarePrism object whose height and side is 0.0 when you 
	//instantiate the object, cause it will take priority to use the local 
	//private attributes to instantiate the object rather than the attributes 
	//inherited from parent class. That is the reason we abstract the Prism class
	//to extract the common character: side for all Prisms. 

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
