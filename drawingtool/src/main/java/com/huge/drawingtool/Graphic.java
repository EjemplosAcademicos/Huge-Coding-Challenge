package com.huge.drawingtool;

import java.util.ArrayList;
import java.util.List;

import com.huge.drawingtool.boxtool.paint.Paint;
import com.huge.drawingtool.boxtool.shapes.Shape;
import com.huge.drawingtool.util.exceptions.ExceptionPaint;
import com.huge.drawingtool.util.exceptions.ExceptionShape;

/**
 * The Graphic class provides operations to draw,to paint and to print shapes.
 * @author sebas.monsalve@gmailcom
 */
public class Graphic {
	
	private Shape canvas;
	private StringBuffer printGraphic;
	private List<List<Character>> panel;
    int lineNum;
	
	public Graphic(Shape canvas) throws ExceptionShape{
		printGraphic = new StringBuffer();
		panel = new ArrayList<List<Character>>();
		this.canvas = canvas;
		this.drawShape(canvas);
	}

	/**
	 * Draw a shape
	 * @param shape value to draw
	 * @throws ExceptionShape if there is a problem drawing the shape
	 */
	public void drawShape(Shape shape) throws ExceptionShape{
		shape.draw(this);	
		printPanel();
	}
	
	/**
	 * Paint a graphic
	 * @param paintTool value to paint
	 * @throws ExceptionPaint if there is a problem painting the graphic
	 */
	public void paint(Paint paintTool) throws ExceptionPaint{
		paintTool.paint(this);	
		printPanel();
	}
	
	/**
	 * Print the shapes inthe panel of the graphics
	 */
	public void printPanel(){
		List<Character> row;//
		for(int i=0; i<panel.size(); i++){
			row = panel.get(i);
			for(int j=0; j<row.size(); j++){
				printGraphic.append(row.get(j));
			}
			printGraphic.append("\n");
		}
	}

	public Shape getCanvas() {
		return canvas;
	}

	public void setCanvas(Shape canvas) {
		this.canvas = canvas;
	}
	
	public List<List<Character>> getPanel() {
		return panel;
	}

	public void setPanel(List<List<Character>> panel) {
		this.panel = panel;
	}

	public StringBuffer getPrintGraphic() {
		return printGraphic;
	}

	public void setPrintGraphic(StringBuffer printGraphic) {
		this.printGraphic = printGraphic;
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}
}
