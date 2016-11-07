/**
 * 
 */
package com.huge.drawingtool.boxtool.shapes;

import com.huge.drawingtool.Graphic;
import com.huge.drawingtool.boxtool.Color;
import com.huge.drawingtool.boxtool.Contour;
import com.huge.drawingtool.util.exceptions.ExceptionShape;

/**
 * The Shape abstract class provides the structure and operations to 
 * represent different shape, 
 * @author sebas.monsalve@gmailcom
 */
public abstract class Shape {
	
	private Color color;
	private Contour contour;
	private String nameShape;
	
	Shape(){
		this.color = new Color();
		this.contour = Contour.X;
	}
	
	Shape(Color color){
		this.color = color;
		this.contour = Contour.X;
	}
	
	Shape(Contour contour){
		this.contour = contour;
		this.color = new Color();
	}
	
	Shape(Color color, Contour contour){
		this.color = color;
		this.contour = contour;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Contour getContour() {
		return contour;
	}

	public void setContour(Contour contour) {
		this.contour = contour;
	}

	public String getNameShape() {
		return nameShape;
	}

	public void setNameShape(String nameShape) {
		this.nameShape = nameShape;
	}

	/**
	 * Implementation to draw a specific shape
	 * @param graphic contain the panel
	 * @throws ExceptionShape if there is a problem drawing the shape
	 */
	public abstract void draw(Graphic graphic) throws ExceptionShape;

}
