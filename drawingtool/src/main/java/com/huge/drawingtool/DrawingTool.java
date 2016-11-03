package com.huge.drawingtool;

import com.huge.drawingtool.boxtool.Contour;
import com.huge.drawingtool.boxtool.shapes.Canvas;
import com.huge.drawingtool.boxtool.shapes.Line;
import com.huge.drawingtool.boxtool.shapes.Point;
import com.huge.drawingtool.boxtool.shapes.Rectangle;
import com.huge.drawingtool.util.exceptions.ExceptionDrawingTool;

public class DrawingTool {
	
	private Graphic graphics;
	
	public void openGraphic(){
		try {
			//create graphics and canvas
			int width = 20;
			int height = 4;
			Point dimensions = new Point(width, height);
			Canvas canvas = new Canvas(dimensions);
			graphics = new Graphic(canvas);
			
			//create a point
			int x1 = 6;
			int y1 = 3;
			Point point = new Point(x1, y1);
			graphics.drawShape(point);
			
			//create a line horizontal
			Point point1 = new Point(1,2);
			Point point2 = new Point(6,2);
			Line lineH = new Line(point1,point2);
			graphics.drawShape(lineH);
			
			//create a line horizontal
			Line lineV = new Line(new Point(6,3),new Point(6,4));
			graphics.drawShape(lineV);
			
			//create rectangle
			Rectangle rectangle = new Rectangle(new Point(16,1),new Point(19,3));
			graphics.drawShape(rectangle);
			
			Rectangle rectangle2 = new Rectangle(new Point(16,2),new Point(19,4));
			//graphics.drawShape(rectangle2);
			
		}catch (ExceptionDrawingTool e) {
			e.showUserMessage();
		}
	}
	
	public void saveGraphic(){
		//System.out.println(graphics.getCacheGraphic());
		System.out.println(graphics.getPrintGraphic());

	}
}
