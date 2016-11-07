package com.huge.drawingtool.boxtool.paint;

import java.util.Stack;

import com.huge.drawingtool.Graphic;
import com.huge.drawingtool.boxtool.Color;
import com.huge.drawingtool.boxtool.Contour;
import com.huge.drawingtool.boxtool.shapes.Canvas;
import com.huge.drawingtool.boxtool.shapes.Point;
import com.huge.drawingtool.util.exceptions.ExceptionPaint;

/**
 * The BucketFill class provides the structure to represent a Bucket Fill and the operation to paint. 
 * @author sebas.monsalve@gmailcom
 */
public class BucketFill extends Paint{
	
	private Point areaConnected;
	
	public BucketFill(Point areaConnected, Color color){
		super(color);
		this.areaConnected = areaConnected;
	}

	@Override
	public void paint(Graphic graphic) throws ExceptionPaint {
		Point dimensionCanvas = ((Canvas)graphic.getCanvas()).getDimensions();
		
		if( areaConnected.getX()>0 && areaConnected.getX()<=dimensionCanvas.getX() &&
			areaConnected.getY()>0 && areaConnected.getY()<=dimensionCanvas.getY()){
			
			Point point = areaConnected;
			
			if(!((Character)graphic.getPanel().get(point.getY()).get(point.getX()) == Contour.SPACE.getContour())){
				graphic.getPanel().get(point.getY()).remove(point.getX());
				graphic.getPanel().get(point.getY()).add(point.getX(),this.getColor_1().getColor());
				return;
			}
			
			Stack stackPoint = new Stack();
			stackPoint.push(point);
			graphic.getPanel().get(point.getY()).remove(point.getX());
			graphic.getPanel().get(point.getY()).add(point.getX(),this.getColor_1().getColor());
			
			Point newPoint;
			while(!stackPoint.isEmpty()){
				point = (Point)stackPoint.peek();
				newPoint = canMove(point,graphic);
				if(!newPoint.isEmpty()){
					graphic.getPanel().get(newPoint.getY()).remove(newPoint.getX());
					graphic.getPanel().get(newPoint.getY()).add(newPoint.getX(),this.getColor_1().getColor());
					stackPoint.push(newPoint);
				}else{
					stackPoint.pop();
				}	
			}
			
		}else{
			ExceptionPaint exceptionPaint = new ExceptionPaint();
			exceptionPaint.setId("Bucket Fill "+ExceptionPaint.WARNING);
			exceptionPaint.setMsnUser("The point is out of the canvas. "+areaConnected.toString());
			throw exceptionPaint;
		}
	}
	
	private Point canMove(Point point, Graphic graphic){
		//check move up
		if((Character)graphic.getPanel().get(point.getY()-1).get(point.getX()) == Contour.SPACE.getContour())
			return new Point(point.getX(),point.getY()-1);
		//check move left
		if((Character)graphic.getPanel().get(point.getY()).get(point.getX()-1) == Contour.SPACE.getContour())
			return new Point(point.getX()-1,point.getY());
		//check move right
		if((Character)graphic.getPanel().get(point.getY()).get(point.getX()+1) == Contour.SPACE.getContour())
			return new Point(point.getX()+1,point.getY());
		//check move down
		if((Character)graphic.getPanel().get(point.getY()+1).get(point.getX()) == Contour.SPACE.getContour())
			return new Point(point.getX(),point.getY()+1);
		
		Point pointEmpty = new Point();
		pointEmpty.setEmpty(true);
		return pointEmpty;
	}
	
	@Override
	public String toString() {
		return "Bucket Fill "+areaConnected.toString()+", color: "+this.getColor_1().getColor();
	}
}
