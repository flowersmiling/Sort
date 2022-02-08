package sait.sort.models;

import sait.sort.contracts.Shape;

public class Cone extends Shape
{
	private double radiu;
	
	public Cone(double height, double radiu) 
	{
		super(height);
		this.radiu = radiu;
	}
	
	public double getRadiu() 
	{
		return radiu;
	}
	
	public void setRadiu(double radiu) 
	{
		this.radiu = radiu;
	}

	@Override
	public double baseArea() 
	{
		return Math.PI*this.radiu*this.radiu;
	}

	@Override
	public double volume() 
	{
		return this.baseArea()*this.getHeight()/3;
	}
}
