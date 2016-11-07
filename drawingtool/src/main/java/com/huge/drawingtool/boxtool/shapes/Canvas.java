package com.huge.drawingtool.boxtool.shapes;

import java.util.ArrayList;
import java.util.List;

import com.huge.drawingtool.Graphic;
import com.huge.drawingtool.boxtool.Contour;
import com.huge.drawingtool.util.exceptions.ExceptionShape;

/**
 * The Canvas class provides the structure to represent a canvas and the operation to draw it. 
 * @author sebas.monsalve@gmailcom
 */
public class Canvas extends Shape{
	
	private Point dimensions;
	private static final int MAX_WIDTH = 1024;
	private static final int MAX_HEIGHT = 768;
	
	public Canvas(Point dimensions){
		super.setNameShape("CANVAS");
		this.dimensions = dimensions;
	}

	@Override
	public void draw(Graphic graphic)  throws ExceptionShape{

		if(dimensions.getX()>0 && dimensions.getY()>0 &&
		   dimensions.getX()<=MAX_WIDTH && dimensions.getY()<=MAX_HEIGHT	){
			
			List row = new ArrayList<Character>();
			for(int width=0; width<dimensions.getX()+2; width++){
				row.add(Contour.HYPHEN.getContour());
			}
			graphic.getPanel().add(row);
			for(int height=0;height<dimensions.getY(); height++){
				row = new ArrayList<Character>();
				row.add(Contour.VERTICAL_BAR.getContour());
				for(int width=0; width<dimensions.getX(); width++){
					row.add(Contour.SPACE.getContour());
				}
				row.add(Contour.VERTICAL_BAR.getContour());
				graphic.getPanel().add(row);
			}
			row = new ArrayList<Character>();
			for(int width=0; width<dimensions.getX()+2; width++){
				row.add(Contour.HYPHEN.getContour());
			}
			graphic.getPanel().add(row);	
		}else{
			ExceptionShape exceptionShape = new ExceptionShape();
			exceptionShape.setId(super.getNameShape()+" "+ExceptionShape.ERROR);
			exceptionShape.setMsnUser("Dimensions canvas doesn't allowed. "+toString()+".  MAX("+MAX_WIDTH+" x "+MAX_HEIGHT+")");
			throw exceptionShape;
		}
	}

	public Point getDimensions() {
		return dimensions;
	}

	public void setDimensions(Point dimensions) {
		this.dimensions = dimensions;
	}
	
	@Override
	public String toString() {
		return "C "+dimensions.getX()+" x "+dimensions.getY();
	}

}
