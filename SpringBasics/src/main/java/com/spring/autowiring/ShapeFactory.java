package com.spring.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {

	// autowiring by type
	IShape shape; //  = new Rectangle()
	//setter method
	@Autowired
	public void setShape(@Qualifier("rectangle") IShape shape) {
		this.shape = shape;
	}

	// autowiring by name - instance variable name and bean name are same
	@Autowired
	IShape square; //  = new Square();


	//autowiring by constr
	IShape myshape;  // new Triangle()
    public ShapeFactory(@Qualifier("triangle") IShape myshape) {
		super();
		this.myshape = myshape;
	}

	
	void printArea(int x, int y) {
		// call the method of interface
		shape.calcArea(10, 20);
		square.calcArea(x, y);
		myshape.calcArea(20, 30);
		
		
	}
}
