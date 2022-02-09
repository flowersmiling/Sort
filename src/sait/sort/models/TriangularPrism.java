package sait.sort.models;

import sait.sort.contracts.Prism;

public class TriangularPrism extends Prism
{
	public TriangularPrism(double height, double side) 
	{
		super(height, side);
	}

	@Override
	public double baseArea() {
		return (Math.sqrt(3)/4)*(this.getSide()*this.getSide());
	}

	@Override
	public double volume() {
		return this.baseArea()*this.getHeight();
	}
}
