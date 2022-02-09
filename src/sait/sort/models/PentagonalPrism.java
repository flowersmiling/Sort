package sait.sort.models;

import sait.sort.contracts.Prism;

public class PentagonalPrism extends Prism
{
	public PentagonalPrism(double height, double side) 
	{
		super(height, side);
	}
	
	@Override
	public double baseArea() {
		return (5 * this.getSide() * this.getSide()) / (4 * Math.tan(Math.PI/5));
	}

	@Override
	public double volume() {
		return this.baseArea() *this.getHeight();
	}
}
