package com.huge.drawingtool;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.huge.drawingtool.boxtool.Color;
import com.huge.drawingtool.boxtool.Contour;
import com.huge.drawingtool.boxtool.paint.BucketFill;
import com.huge.drawingtool.boxtool.shapes.Canvas;
import com.huge.drawingtool.boxtool.shapes.Line;
import com.huge.drawingtool.boxtool.shapes.Point;
import com.huge.drawingtool.boxtool.shapes.Rectangle;
import com.huge.drawingtool.file.AccessFile;
import com.huge.drawingtool.util.exceptions.ExceptionAccessFile;
import com.huge.drawingtool.util.exceptions.ExceptionDrawingTool;
import com.huge.drawingtool.util.exceptions.ExceptionFormatFile;
import com.huge.drawingtool.util.exceptions.ExceptionPaint;
import com.huge.drawingtool.util.exceptions.ExceptionShape;

public class DrawingTool {
	
	private Graphic graphics;
	private AccessFile accessFile;
	private String filePath;
	
	public DrawingTool(){
		this.accessFile = new AccessFile();
	}
	
	public void newGraphic(String filePath) throws ExceptionDrawingTool {
		this.filePath = filePath;
		int lineNum = 0;
		ExceptionFormatFile excepFormatFile;
		try {
			List<String> file = accessFile.readFile(filePath);
			if(!file.isEmpty()){ 
				//check if exists a canvas at the first line
				if(file.get(0).charAt(0) != 'C'){
					excepFormatFile = new ExceptionFormatFile();
					excepFormatFile.setId("FILE "+ExceptionFormatFile.ERROR);
					excepFormatFile.setMsnUser("You need a canvas to draw");
					throw excepFormatFile;
				}
				String[] draw;
				for(int numLine=0;numLine<file.size(); numLine++){
					lineNum = numLine+1;
					String drawLine = file.get(numLine);
					draw = drawLine.split(" ");
											
					switch (draw[0]) {
						case "C": //Canvas
							drawCavas(draw);
							break;
						case "P": //Point
							drawPoint(draw);
							break;
						case "L": //Line
							drawLine(draw);
							break;
						case "R": //rectangle
							drawRectagle(draw);
							break;
						case "B": //BucketFill
							paintBucketFill(draw);
							break;

						default:
							excepFormatFile = new ExceptionFormatFile();
							excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
							excepFormatFile.setMsnUser("Invalid format option. "+Arrays.toString(draw));
							throw excepFormatFile;
					}
				}
				
			}else{
				excepFormatFile = new ExceptionFormatFile();
				excepFormatFile.setId("FILE "+ExceptionFormatFile.WARNING);
				excepFormatFile.setMsnUser("File Empty!!");
				throw excepFormatFile;
			}
		}catch (IOException e) {
			ExceptionAccessFile excepAccessFile = new ExceptionAccessFile();
			excepAccessFile.setExceptionSource(e);
			excepAccessFile.setId("FILE "+ExceptionFormatFile.ERROR);
			excepAccessFile.setMsnTechnical("Error class DrawingTool,  method newGraphic");
			excepAccessFile.setMsnUser("Error reading the input file. Please, check the file or the path");
			throw excepAccessFile;
		}catch(ExceptionDrawingTool e){
			e.setMsnUser(e.getMsnUser()+". Line "+lineNum);
			throw e;
		}catch (Exception e){
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setExceptionSource(e);
			excepFormatFile.setId("FILE "+ExceptionFormatFile.ERROR);
			excepFormatFile.setMsnUser("Invalid Format File");
			throw excepFormatFile;
		}
	}

	public void saveGraphic() throws ExceptionAccessFile{
		
		try {
			accessFile.writeToFile(filePath.substring(0,filePath.lastIndexOf('/'))+"/output.txt", graphics.getPrintGraphic().toString(), 0);
		} catch (IOException e) {
			ExceptionAccessFile excepAccessFile = new ExceptionAccessFile();
			excepAccessFile.setExceptionSource(e);
			excepAccessFile.setId("FILE "+ExceptionFormatFile.ERROR);
			excepAccessFile.setMsnTechnical("Error class DrawingTool,  method saveGraphic");
			excepAccessFile.setMsnUser("Error saving the graphic in the output file. (Check the permissions of your directory)");
			throw excepAccessFile;
		}

	}

	private void drawCavas(String[] draw) throws ExceptionDrawingTool {
		ExceptionFormatFile excepFormatFile;
		try{
			if(draw.length==3){
				int width = Integer.parseInt(draw[1]);
				int height = Integer.parseInt(draw[2]);
				if(width>0 && height>0){
					Canvas canvas = new Canvas(new Point(width, height));
					graphics = new Graphic(canvas);
				}else{
					excepFormatFile = new ExceptionFormatFile();
					excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
					excepFormatFile.setMsnUser("Invalid parameters format canvas. "+Arrays.toString(draw));
					throw excepFormatFile;
				}
			}else{
				excepFormatFile = new ExceptionFormatFile();
				excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
				excepFormatFile.setMsnUser("Invalid parameters format canvas. Please check C w h. "+Arrays.toString(draw));
				throw excepFormatFile;	
			}
		}catch(NumberFormatException nfe){
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
			excepFormatFile.setMsnUser("Invalid parameters format canvas. "+Arrays.toString(draw));
			throw excepFormatFile;								
		}catch(ExceptionDrawingTool e){
			throw e;
		}catch (Exception e) {
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
			excepFormatFile.setMsnUser("Invalid format canvas. Please check C w h. "+Arrays.toString(draw));
			throw excepFormatFile;	
		}
	}

	private void drawPoint(String[] draw) throws ExceptionDrawingTool {
		ExceptionFormatFile excepFormatFile;
		try{
			if(draw.length==3){
				int x = Integer.parseInt(draw[1]);
				int y = Integer.parseInt(draw[2]);
				if(x>0 && y>0){
					Point point = new Point(x, y);
					graphics.drawShape(point);
				}else{
					excepFormatFile = new ExceptionFormatFile();
					excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
					excepFormatFile.setMsnUser("Invalid parameters format point. "+Arrays.toString(draw));
					throw excepFormatFile;
				}
			}else{
				excepFormatFile = new ExceptionFormatFile();
				excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
				excepFormatFile.setMsnUser("Invalid parameters format point. Please check P x y. "+Arrays.toString(draw));
				throw excepFormatFile;	
			}
		}catch(NumberFormatException nfe){
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
			excepFormatFile.setMsnUser("Invalid parameters format point. "+Arrays.toString(draw));
			throw excepFormatFile;								
		}catch(ExceptionDrawingTool e){
			throw e;
		}catch (Exception e) {
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
			excepFormatFile.setMsnUser("Invalid format point. Please check P x y. "+Arrays.toString(draw));
			throw excepFormatFile;	
		}
	}

	private void drawLine(String[] draw) throws ExceptionDrawingTool {
		ExceptionFormatFile excepFormatFile;
		try{
			if(draw.length==5){
				int x1 = Integer.parseInt(draw[1]);
				int y1 = Integer.parseInt(draw[2]);
				int x2 = Integer.parseInt(draw[3]);
				int y2 = Integer.parseInt(draw[4]);
				
				if(x1>0 && y1>0 && x2>0 && y2>0){
					Line line = new Line(new Point(x1,y1),new Point(x2,y2));
					graphics.drawShape(line);
				}else{
					excepFormatFile = new ExceptionFormatFile();
					excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
					excepFormatFile.setMsnUser("Invalid parameters format line. "+Arrays.toString(draw));
					throw excepFormatFile;
				}
			}else{
				excepFormatFile = new ExceptionFormatFile();
				excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
				excepFormatFile.setMsnUser("Invalid parameters format line. Please check L x1 y1 x2 y2. "+Arrays.toString(draw));
				throw excepFormatFile;	
			}
		}catch(NumberFormatException nfe){
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
			excepFormatFile.setMsnUser("Invalid parameters format line. "+Arrays.toString(draw));
			throw excepFormatFile;								
		}catch(ExceptionDrawingTool e){
			throw e;
		}catch (Exception e) {
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
			excepFormatFile.setMsnUser("Invalid format line. Please check L x1 y1 x2 y2. "+Arrays.toString(draw));
			throw excepFormatFile;	
		}
	}
	
	private void drawRectagle(String[] draw) throws ExceptionDrawingTool {
		ExceptionFormatFile excepFormatFile;
		try{
			if(draw.length==5){
				int x1 = Integer.parseInt(draw[1]);
				int y1 = Integer.parseInt(draw[2]);
				int x2 = Integer.parseInt(draw[3]);
				int y2 = Integer.parseInt(draw[4]);
				
				if(x1>0 && y1>0 && x2>0 && y2>0){
					Rectangle rectangle = new Rectangle(new Point(x1,y1),new Point(x2,y2));
					graphics.drawShape(rectangle);
				}else{
					excepFormatFile = new ExceptionFormatFile();
					excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
					excepFormatFile.setMsnUser("Invalid parameters format rectangle. "+Arrays.toString(draw));
					throw excepFormatFile;
				}
			}else{
				excepFormatFile = new ExceptionFormatFile();
				excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
				excepFormatFile.setMsnUser("Invalid parameters format rectangle. Please check R x1 y1 x2 y2 "+Arrays.toString(draw));
				throw excepFormatFile;	
			}
		}catch(NumberFormatException nfe){
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
			excepFormatFile.setMsnUser("Invalid parameters format rectangle. "+Arrays.toString(draw));
			throw excepFormatFile;								
		}catch(ExceptionDrawingTool e){
			throw e;
		}catch (Exception e) {
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR); 
			excepFormatFile.setMsnUser("Invalid format rectangle. Please check R x1 y1 x2 y2. "+Arrays.toString(draw));
			throw excepFormatFile;	
		}
	}

	private void paintBucketFill(String[] draw) throws ExceptionDrawingTool  {
		ExceptionFormatFile excepFormatFile;
		try{
			if(draw.length==4){
				int x = Integer.parseInt(draw[1]);
				int y = Integer.parseInt(draw[2]);
				char color = draw[3].charAt(0);
				if(x>0 && y>0){
					BucketFill bucketfill = new BucketFill(new Point(x, y),new Color(color));
					graphics.paint(bucketfill);
				}else{
					excepFormatFile = new ExceptionFormatFile();
					excepFormatFile.setId("Bucket Fill "+ExceptionFormatFile.ERROR);
					excepFormatFile.setMsnUser("Invalid parameters format bucket fill. "+Arrays.toString(draw));
					throw excepFormatFile;
				}
			}else{
				excepFormatFile = new ExceptionFormatFile();
				excepFormatFile.setId("Bucket Fill "+ExceptionFormatFile.ERROR);
				excepFormatFile.setMsnUser("Invalid parameters format bucket fill. Please check B x y c. "+Arrays.toString(draw));
				throw excepFormatFile;	
			}
		}catch(NumberFormatException nfe){
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setId("Bucket Fill "+ExceptionFormatFile.ERROR);
			excepFormatFile.setMsnUser("Invalid parameters format bucket fill. "+Arrays.toString(draw));
			throw excepFormatFile;								
		}catch(ExceptionDrawingTool e){
			throw e;
		}catch (Exception e) {
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setId("Bucket Fill "+ExceptionFormatFile.ERROR);
			excepFormatFile.setMsnUser("Invalid format point. Plese check P x y. "+Arrays.toString(draw));
			throw excepFormatFile;	
		}
	}
}
