package sait.sort.contracts;

public abstract class Prism extends Shape
{
	private float side;

	public Prism(float height, float side) {
		super(height);
		this.side = side;
	}

	public float getSide() {
		return side;
	}

	public void setSide(float side) {
		this.side = side;
	}
	
}
