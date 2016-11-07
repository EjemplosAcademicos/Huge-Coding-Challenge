/**
 * 
 */
package com.huge.drawingtool.boxtool.shapes;

import com.huge.drawingtool.Graphic;
import com.huge.drawingtool.boxtool.Color;
import com.huge.drawingtool.boxtool.Contour;
import com.huge.drawingtool.util.exceptions.ExceptionShape;

/**
 * The Point class provides the structure to represent a point and the operation to draw it. 
 * @author sebas.monsalve@gmailcom
 */
public class Point extends Shape{

	private int x;
	private int y;
	private boolean empty;
	
	public Point() {
		super(Contour.DOT);
		super.setNameShape("POINT");
		this.x = 0;
		this.y = 0;
		this.empty = false;
	}
	
	public Point(int x, int y) {
		super(Contour.DOT);
		super.setNameShape("POINT");
		this.x = x;
		this.y = y;
		this.empty = false;
	}
	
	public Point(int x, int y, Color color) {
		super(color, Contour.DOT);
		super.setNameShape("POINT");
		this.x = x;
		this.y = y;
		this.empty = false;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void draw(Graphic graphic) throws ExceptionShape {
		Point dimensionCanvas = ((Canvas)graphic.getCanvas()).getDimensions();
		if( x>0 && x<=dimensionCanvas.getX() &&
			y>0 && y<=dimensionCanvas.getY()){
			
			graphic.getPanel().get(y).remove(x);
			graphic.getPanel().get(y).add(x,this.getContour().getContour());
			
		}else{
			ExceptionShape exceptionShape = new ExceptionShape();
			exceptionShape.setId(super.getNameShape()+" "+ExceptionShape.WARNING);
			exceptionShape.setMsnUser("The point is out of the canvas. "+toString());
			throw exceptionShape;
		}
	}

	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	
	public boolean isEmpty(){
		return empty;
	}
	
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	
}
