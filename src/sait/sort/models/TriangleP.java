package sait.sort.models;

import sait.sort.contracts.Prism;

public class TriangleP extends Prism
{

	public TriangleP(float height, float side) 
	{
		super(height, side);
	}

/**
	 * @return the side
	 */
	public float getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(float side) {
		this.side = side;
	}

	/**
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(float height) {
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
