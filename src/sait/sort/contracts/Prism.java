package sait.sort.contracts;

/**
 * Prism Object
 */
public abstract class Prism extends Shape
{
	//A subclass that inherits from an abstract class must be abstract 
	//if it does not override all the abstract methods of the parent class.
	//Abstraction-oriented programming.
	
	/**
	 *Prism edge length 
	 */
	private double side;

	/**
	 * Prism Constructor
	 * @param height - height of prism
	 * @param side - edge length of prism
	 */
	public Prism(double height, double side) {
		super(height);
		this.side = side;
	}

	/** 
	* Getter of side 
	* @return - edge length of prism
	*/
	
	public double getSide() {
		return side;
	}

	/** 
	* Setter of side 
	* @param side - edge length of prism
	*/
	
	public void setSide(double side) {
		this.side = side;
	}
	
}
