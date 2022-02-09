package sait.sort.models;

import sait.sort.contracts.Prism;

public class TriangularPrism extends Prism
{
	private double side;
	private double height;

	public TriangularPrism(double height, double side) 
	{
		super(height, side);
	}

/**
	 * @return the side
	 */
	public double getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(double side) {
		this.side = side;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double baseArea() {
		return (Math.sqrt(3)/4)*(this.side*this.side);
	}

	@Override
	public double volume() {
		return this.baseArea()*this.height;
	}
}
