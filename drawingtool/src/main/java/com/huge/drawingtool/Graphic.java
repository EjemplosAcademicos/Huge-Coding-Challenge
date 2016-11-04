package com.huge.drawingtool;

import java.util.ArrayList;
import java.util.List;

import com.huge.drawingtool.boxtool.paint.Paint;
import com.huge.drawingtool.boxtool.shapes.Shape;
import com.huge.drawingtool.util.exceptions.ExceptionDrawingTool;

public class Graphic {
	
	private Shape canvas;
	private StringBuffer printGraphic;
	private List<List<Character>> panel;
	
	public Graphic(Shape canvas) throws ExceptionDrawingTool{
		printGraphic = new StringBuffer();
		panel = new ArrayList<List<Character>>();
		this.canvas = canvas;
		this.drawShape(canvas);
	}

	public void drawShape(Shape shape) throws ExceptionDrawingTool{
		shape.draw(this);	
		printPanel();
	}
	
	public void paint(Paint paintTool) throws ExceptionDrawingTool{
		paintTool.paint(this);	
		printPanel();
	}
	
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
	
}
