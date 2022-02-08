package sait.sort.models;

import sait.sort.contracts.Shape;

public class Pyramid extends Shape
{
	private double edge_length;
	
	public Pyramid(double height, double edge_length) 
	{
		super(height);
		this.edge_length = edge_length;
	}
	
	public double getEdge_length() 
	{
		return edge_length;
	}
	
	public void setEdge_length(double edge_length) 
	{
		this.edge_length = edge_length;
	}
	
	@Override
	public double baseArea() 
	{
		return this.edge_length*this.edge_length;
	}

	@Override
	public double volume() 
	{
		return this.baseArea()*this.getHeight() / 3;
	}

}
