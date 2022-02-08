package sait.sort.models;

import sait.sort.contracts.Prism;

public class SquarePrism extends Prism 
{

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
