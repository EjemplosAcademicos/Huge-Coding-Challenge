/**
 * 
 */
package com.huge.drawingtool.boxtool.shapes;

import com.huge.drawingtool.Graphic;
import com.huge.drawingtool.boxtool.Color;
import com.huge.drawingtool.boxtool.Contour;

/**
 * This is the abstract parent class for different shape classes,
 * It provides an abstract method draw().
 * 
 * @author sebas.monsalve@gmailcom
 */
public abstract class Shape {
	
	private Color color;
	private Contour contour;
	
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

	/**
	 * @param canvas
	 */
	public abstract void draw(Graphic graphic);

}
