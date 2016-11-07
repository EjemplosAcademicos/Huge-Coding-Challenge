package com.huge.drawingtool.boxtool.shapes;

import com.huge.drawingtool.Graphic;
import com.huge.drawingtool.boxtool.Color;
import com.huge.drawingtool.boxtool.Contour;
import com.huge.drawingtool.util.exceptions.ExceptionShape;

/**
 * The Rectangle class provides the structure to represent a rectangle and the operation to draw it. 
 * @author sebas.monsalve@gmailcom
 */
public class Rectangle extends Shape{
	
	private Point upper_left_corner;
	private Point lower_left_corner;
	
	public Rectangle(Point upper_left_corner, Point lower_left_corner) {
		super();
		super.setNameShape("RECTANGLE");
		this.upper_left_corner = upper_left_corner;
		this.lower_left_corner = lower_left_corner;
	}
	
	public Rectangle(Point upper_left_corner, Point lower_left_corner, Color color) {
		super(color);
		super.setNameShape("RECTANGLE");
		this.upper_left_corner = upper_left_corner;
		this.lower_left_corner = lower_left_corner;
	}
	
	public Rectangle(Point upper_left_corner, Point lower_left_corner, Contour contour) {
		super(contour);
		super.setNameShape("RECTANGLE");
		this.upper_left_corner = upper_left_corner;
		this.lower_left_corner = lower_left_corner;
	}
	
	public Rectangle(Point upper_left_corner, Point lower_left_corner, Color color, Contour contour) {
		super(color, contour);
		super.setNameShape("RECTANGLE");
		this.upper_left_corner = upper_left_corner;
		this.lower_left_corner = lower_left_corner;
	}

	@Override
	public void draw(Graphic graphic) throws ExceptionShape {
		Point dimensionCanvas = ((Canvas)graphic.getCanvas()).getDimensions();
		
		if( upper_left_corner.getX()>0 && upper_left_corner.getX()<=dimensionCanvas.getX() &&
			upper_left_corner.getY()>0 && upper_left_corner.getY()<=dimensionCanvas.getY()){
			
			if( upper_left_corner.getX() <= lower_left_corner.getX() && upper_left_corner.getY() <= lower_left_corner.getY()){
			
				for(int i=upper_left_corner.getY(); i<=lower_left_corner.getY() && i<=dimensionCanvas.getY(); i++){
					for(int j=upper_left_corner.getX(); j<=lower_left_corner.getX() && j<=dimensionCanvas.getX(); j++){
						if(i==upper_left_corner.getY() || i==lower_left_corner.getY() ||
						   j==upper_left_corner.getX() || j==lower_left_corner.getX()){
							graphic.getPanel().get(i).remove(j);
							graphic.getPanel().get(i).add(j,this.getContour().getContour());
						}else{
							graphic.getPanel().get(i).remove(j);
							graphic.getPanel().get(i).add(j,Contour.SPACE.getContour());
						}
					}
				}
			}else{
				ExceptionShape exceptionShape = new ExceptionShape();
				exceptionShape.setId(super.getNameShape()+" "+ExceptionShape.ERROR);
				exceptionShape.setMsnUser("Can't draw a "+super.getNameShape()+" from "+upper_left_corner.toString()+" to "+lower_left_corner.toString());
				throw exceptionShape;
			}
		}else{
			ExceptionShape exceptionShape = new ExceptionShape();
			exceptionShape.setId(super.getNameShape()+" "+ExceptionShape.WARNING);
			exceptionShape.setMsnUser("The "+super.getNameShape()+" is out of the canvas. "+upper_left_corner.toString()+" to "+lower_left_corner.toString());
			throw exceptionShape;
		}
	}
	
	@Override
	public String toString() {
		return "R "+upper_left_corner.toString()+" to "+lower_left_corner.toString();
	}
	
}
