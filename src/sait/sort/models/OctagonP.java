package sait.sort.models;

import sait.sort.contracts.Prism;

public class OctagonP extends Prism{
	
	private float side;
	private float height;
	
	public OctagonP(float height, float side) {
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
	
		return (2 * (1 + Math.sqrt(2)) * this.side * this.side);
	}


	@Override
	public double volume() {
		
		return this.baseArea() *this.height;
	}

}
