package sait.sort.models;

import sait.sort.contracts.Shape;

/**
 * Cylinder object class
 */
public class Cylinder extends Shape
{
	/**
	 *radiu of cylinder 
	 */
	private double radiu;

	/**
	 * cylinder object constructor
	 * @param height- height of Cylinder
	 * @param radiu - radiu of Cylinder
	 */
	public Cylinder(double height, double radiu) {
		super(height);
		this.radiu = radiu;
	}

	/** 
	* Getter of cylinder 
	* @return - radiu of cylinder
	*/
	
	public double getRadiu() {
		return radiu;
	}

	/** 
	* Setter of cylinder 
	* @param radiu - radiu of cylinder
	*/
	
	public void setRadiu(double radiu) {
		this.radiu = radiu;
	}

	@Override
	public double baseArea() {
		return Math.PI*this.radiu*this.radiu;
	}

	@Override
	public double volume() {
		return this.baseArea()*this.getHeight();
	}
}
