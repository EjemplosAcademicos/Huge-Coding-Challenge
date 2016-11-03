package com.huge.drawingtool.boxtool.shapes;

import com.huge.drawingtool.Graphic;
import com.huge.drawingtool.boxtool.Color;
import com.huge.drawingtool.boxtool.Contour;
import com.huge.drawingtool.util.exceptions.ExceptionShape;

public class Line extends Shape{

	private Point point_1;
	private Point point_2;
	
	public Line(Point point_1, Point point_2){
		super();
		super.setNameShape("LINE");
		this.point_1 = point_1;
		this.point_2 = point_2;
	}
	
	public Line(Point point_1, Point point_2, Contour lineForm){
		super(lineForm);
		super.setNameShape("LINE");
		this.point_1 = point_1;
		this.point_2 = point_2;
	}
	
	public Line(Point point_1, Point point_2, Color color){
		super(color);
		super.setNameShape("LINE");
		this.point_1 = point_1;
		this.point_2 = point_2;
	}
	
	public Line(Point point_1, Point point_2, Contour lineForm, Color color){
		super(color, lineForm);
		super.setNameShape("LINE");
		this.point_1 = point_1;
		this.point_2 = point_2;
	}
	
	@Override
	public void draw(Graphic graphic) throws ExceptionShape {
		Point dimensionCanvas = ((Canvas)graphic.getCanvas()).getDimensions();
		//check if the points represents horizontal or vertical lines
		if((point_1.getX() == point_2.getX()) || (point_1.getY() == point_2.getY())){
			
			//check if la linea este dentro del canvas
			if( point_1.getX()>0 && point_1.getX()<=dimensionCanvas.getX() &&
				point_1.getY()>0 && point_1.getY()<=dimensionCanvas.getY()){
				
				//check si el origen es menor que el destino
				if( point_1.getX() <= point_2.getX() && point_1.getY() <= point_2.getY()){
					
					//Vertical line
					if(point_1.getX() == point_2.getX()){
						for(int i=point_1.getY(); i<=point_2.getY() && i<=dimensionCanvas.getY(); i++){
							graphic.getPanel().get(i).remove(point_1.getX());
							graphic.getPanel().get(i).add(point_1.getX(),this.getContour().getContour());
						}
					}
					//horizontal line
					if(point_1.getY() == point_2.getY()){
						//draw line
						for(int i=point_1.getX(); i<=point_2.getX() && i<=dimensionCanvas.getX(); i++){
							graphic.getPanel().get(point_1.getY()).remove(i);
							graphic.getPanel().get(point_1.getY()).add(i,this.getContour().getContour());
						}
					}
					
				}else{
					ExceptionShape exceptionShape = new ExceptionShape();
					exceptionShape.setId(super.getNameShape()+" "+ExceptionShape.ERROR);
					exceptionShape.setMsnUser("Can't draw a line from "+point_1.toString()+" to "+point_2.toString());
					throw exceptionShape;
				}
			}else{
				ExceptionShape exceptionShape = new ExceptionShape();
				exceptionShape.setId(super.getNameShape()+" "+ExceptionShape.WARNING);
				exceptionShape.setMsnUser("The line is out of the canvas. "+point_1.toString()+" to "+point_2.toString());
				throw exceptionShape;
			}
		}else{
			ExceptionShape exceptionShape = new ExceptionShape();
			exceptionShape.setId(super.getNameShape()+" "+ExceptionShape.ERROR);
			exceptionShape.setMsnUser("The points doesn't represent a horizontal or vertical lines. "+point_1.toString()+" to "+point_2.toString());
			throw exceptionShape;
		}
	}

}
