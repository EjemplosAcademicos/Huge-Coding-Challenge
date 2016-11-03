/**
 * 
 */
package com.huge.drawingtool.boxtool.shapes;

import com.huge.drawingtool.Graphic;
import com.huge.drawingtool.boxtool.Color;
import com.huge.drawingtool.boxtool.Contour;

/**
 * @author sebas.monsalve@gmailcom
 *
 */
public class Point extends Shape{

	private int x;
	private int y;
	
	public Point() {
		super(Contour.DOT);
		this.x = 0;
		this.y = 0;
	}
	
	public Point(int x, int y) {
		super(Contour.DOT);
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, Color color) {
		super(color, Contour.DOT);
		this.x = x;
		this.y = y;
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
	public void draw(Graphic graphic) {
		graphic.setCacheGraphic(
				graphic.getCacheGraphic().concat(this.getContour().getContour()+"\n"));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+x+","+y+")";
	}
	
	
	
}
