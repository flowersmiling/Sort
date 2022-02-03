package sait.sort.models;

import sait.sort.contracts.Prism;

public class SquareP extends Prism 
{

	public SquareP(float height, float side) 
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
