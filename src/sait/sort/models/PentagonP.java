package sait.sort.models;

import sait.sort.contracts.Prism;

public class PentagonP extends Prism{
	 private float side;
	 private float height;

	public PentagonP(float height, float side) {
		super(height, side);
		// TODO Auto-generated constructor stub
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
		return (5 * this.side * this.side) / (4 * Math.tan(Math.PI/5));
	}

	@Override
	public double volume() {
		return this.baseArea() *this.height;
	}

}
