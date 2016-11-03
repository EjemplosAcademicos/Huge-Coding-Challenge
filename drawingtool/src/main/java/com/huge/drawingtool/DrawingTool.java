package com.huge.drawingtool;

import com.huge.drawingtool.boxtool.Contour;
import com.huge.drawingtool.boxtool.shapes.Canvas;
import com.huge.drawingtool.boxtool.shapes.Line;
import com.huge.drawingtool.boxtool.shapes.Point;

public class DrawingTool {
	
	private Graphic graphics;
	
	public void openGraphic(){
		
		//create graphics and canvas
		int width = 20;
		int height = 4;
		Point dimensions = new Point(width, height);
		Canvas canvas = new Canvas(dimensions);
		graphics = new Graphic(canvas);
		
		//create a point
		int x1 = 3;
		int y1 = 4;
		Point point = new Point(x1, y1);
		//graphics.drawShape(point);
		
		//create a line horizontal
		Point point1 = new Point(3, 5);
		Point point2 = new Point(25, 5);
		Line lineH = new Line(point1,point2);
		graphics.drawShape(lineH);
		
		//create a line horizontal
		Line lineV = new Line(new Point(6, 3),new Point(6, 4));
		//graphics.drawShape(lineV);
	}
	
	public void saveGraphic(){
		//System.out.println(graphics.getCacheGraphic());
		System.out.println(graphics.getPrintGraphic());

	}
}
