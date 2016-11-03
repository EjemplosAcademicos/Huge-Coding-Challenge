package com.huge.drawingtool.boxtool.shapes;

import java.util.ArrayList;
import java.util.List;

import com.huge.drawingtool.Graphic;
import com.huge.drawingtool.boxtool.Contour;

/**
 * @author sebas.monsalve@gmailcom
 *
 */
public class Canvas extends Shape{
	
	private Point dimensions;
	
	public Canvas(Point dimensions){
		this.dimensions = dimensions;
	}

	@Override
	public void draw(Graphic graphic) {
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
	}

	public Point getDimensions() {
		return dimensions;
	}

	public void setDimensions(Point dimensions) {
		this.dimensions = dimensions;
	}
	
	

}
