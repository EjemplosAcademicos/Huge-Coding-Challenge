package com.huge.drawingtool.boxtool.shapes;

import java.util.ArrayList;
import java.util.List;

import com.huge.drawingtool.Graphic;
import com.huge.drawingtool.boxtool.Color;
import com.huge.drawingtool.boxtool.Contour;

public class Line extends Shape{

	private Point point_1;
	private Point point_2;
	
	public Line(Point point_1, Point point_2){
		super();
		this.point_1 = point_1;
		this.point_2 = point_2;
	}
	
	public Line(Point point_1, Point point_2, Contour lineForm){
		super(lineForm);
		this.point_1 = point_1;
		this.point_2 = point_2;
	}
	
	public Line(Point point_1, Point point_2, Color color){
		super(color);
		this.point_1 = point_1;
		this.point_2 = point_2;
	}
	
	public Line(Point point_1, Point point_2, Contour lineForm, Color color){
		super(color, lineForm);
		this.point_1 = point_1;
		this.point_2 = point_2;
	}
	
	@Override
	public void draw(Graphic graphic) {
		
		String line = "";
		//Vertical line
		if(point_1.getX() == point_2.getX()){
			//go to Y
			for(int i=0; i<point_1.getY(); i++){
				line += "\n";
			}
			for(int i=point_1.getY(); i<=point_2.getY(); i++){
				//go to x
				for(int j=0; j<point_1.getX(); j++){
					line += " ";
				}
				line += this.getContour().getContour()+"\n";
			}
		}
		//horizontal line
		if(point_1.getY() == point_2.getY()){
			//go to Y
			for(int i=0; i<point_1.getY(); i++){
				line += "\n";
			}
			//go to x
			for(int i=0; i<point_1.getX(); i++){
				line += Contour.SPACE.getContour();
			}
			//draw line
			Point dimensionCanvas = ((Canvas)graphic.getCanvas()).getDimensions();
			for(int i=point_1.getX(); i<=point_2.getX() && i<=dimensionCanvas.getX(); i++){
				line += this.getContour().getContour();
				graphic.getPanel().get(point_1.getY()).remove(i);
				graphic.getPanel().get(point_1.getY()).add(i,this.getContour().getContour());
			}
		}
		graphic.setCacheGraphic(graphic.getCacheGraphic().concat(line+"\n"));
	}

}
