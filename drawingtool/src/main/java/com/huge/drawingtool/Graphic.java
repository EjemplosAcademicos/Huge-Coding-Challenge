package com.huge.drawingtool;

import java.util.ArrayList;
import java.util.List;

import com.huge.drawingtool.boxtool.shapes.Shape;
import com.huge.drawingtool.util.ExceptionDrawingTool;

public class Graphic {
	
	private Shape canvas;
	private String cacheGraphic;
	private StringBuffer printGraphic;
	private List<List<Character>> panel;
	
	public Graphic(Shape canvas) throws ExceptionDrawingTool{
		cacheGraphic = "";
		printGraphic = new StringBuffer();
		panel = new ArrayList<List<Character>>();
		this.canvas = canvas;
		this.drawShape(canvas);
	}

	public void drawShape(Shape shape) throws ExceptionDrawingTool{
		shape.draw(this);	
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

	public String getCacheGraphic() {
		return cacheGraphic;
	}

	public void setCacheGraphic(String cacheGraphic) {
		this.cacheGraphic = cacheGraphic;
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
