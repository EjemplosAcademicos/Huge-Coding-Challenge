package com.huge.drawingtool;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.huge.drawingtool.boxtool.Color;
import com.huge.drawingtool.boxtool.paint.BucketFill;
import com.huge.drawingtool.boxtool.shapes.Canvas;
import com.huge.drawingtool.boxtool.shapes.Line;
import com.huge.drawingtool.boxtool.shapes.Point;
import com.huge.drawingtool.boxtool.shapes.Rectangle;
import com.huge.drawingtool.file.AccessFile;
import com.huge.drawingtool.util.exceptions.ExceptionAccessFile;
import com.huge.drawingtool.util.exceptions.ExceptionFormatFile;
import com.huge.drawingtool.util.exceptions.ExceptionPaint;
import com.huge.drawingtool.util.exceptions.ExceptionShape;

/**
 * The DrawingTool class provides operations to charge a new graphic, draw shapes and print the graphic.
 * @author sebas.monsalve@gmailcom
 */
public class DrawingTool {
	
	private Graphic graphics;
	private AccessFile accessFile;
	private String filePath;
    private int lineNum;
    
	public DrawingTool(){
		this.accessFile = new AccessFile();
	}
	
	/**
	 * Validates and draws the different shapes inside the file
	 * @param filePath - path of the file with the instructions to draw
	 * @throws IOException if there is a problem reading the file
	 * @throws ExceptionAccessFile if there is a problem accessing to the file
	 * @throws ExceptionFormatFile if there is a problem with the format of each instruction
	 * @throws ExceptionShape if there is a problem drawing the shape
	 * @throws ExceptionPaint if there is a problem painting the graphic
	 */
	public void newGraphic(String filePath) throws IOException, ExceptionAccessFile, ExceptionFormatFile, ExceptionShape, ExceptionPaint {
		
		this.filePath = filePath;
		ExceptionFormatFile excepFormatFile;
		List<String> file = accessFile.readFile(filePath);
		
		existCanvas(file);
		int x1,y1,x2,y2;
		String[] draw;
		for(int numLine=0;numLine<file.size(); numLine++){
			lineNum = numLine+1;
			String drawLine = file.get(numLine);
			draw = drawLine.split(" ");
			
			if(!drawLine.isEmpty() && draw.length>0 ){
				switch (draw[0]) {
					case "C": //Canvas
						canDrawShape(draw, 3, 3, "C w h");
						x1 = Integer.parseInt(draw[1]);
						y1 = Integer.parseInt(draw[2]);
						Canvas canvas = new Canvas(new Point(x1, y1));
						graphics = new Graphic(canvas);
						break;
					case "P": //Point
						canDrawShape(draw, 3, 3, "P x y");
						x1 = Integer.parseInt(draw[1]);
						y1 = Integer.parseInt(draw[2]);
						Point point = new Point(x1, y1);
						graphics.drawShape(point);
						break;
					case "L": //Line
						canDrawShape(draw, 5, 5, "L x1 y1 x2 y2");
						x1 = Integer.parseInt(draw[1]);
						y1 = Integer.parseInt(draw[2]);
						x2 = Integer.parseInt(draw[3]);
						y2 = Integer.parseInt(draw[4]);
						Line line = new Line(new Point(x1,y1),new Point(x2,y2));
						graphics.drawShape(line);
						break;
					case "R": //rectangle
						canDrawShape(draw, 5, 5, "R x1 y1 x2 y2");
						x1 = Integer.parseInt(draw[1]);
						y1 = Integer.parseInt(draw[2]);
						x2 = Integer.parseInt(draw[3]);
						y2 = Integer.parseInt(draw[4]);
						Rectangle rectangle = new Rectangle(new Point(x1,y1),new Point(x2,y2));
						graphics.drawShape(rectangle);
						break;
					case "B": //BucketFill
						canDrawShape(draw, 4, 3, "B x y c");
						int x = Integer.parseInt(draw[1]);
						int y = Integer.parseInt(draw[2]);
						if(draw[3].isEmpty() || draw[3].length()>1){
							excepFormatFile = new ExceptionFormatFile();
							excepFormatFile.setId("PAINT "+ExceptionFormatFile.ERROR);
							excepFormatFile.setMsnUser("Invalid format color Bucket. Please check B x y c. "+Arrays.toString(draw)+". Line: "+lineNum);
							throw excepFormatFile;
						}
						char color = draw[3].charAt(0);
						BucketFill bucketfill = new BucketFill(new Point(x, y),new Color(color));
						graphics.paint(bucketfill);
						break;
					
					default:
						excepFormatFile = new ExceptionFormatFile();
						excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
						excepFormatFile.setMsnUser("Invalid format, this option doesn´t exist. "+Arrays.toString(draw)+". Line: "+lineNum);
						throw excepFormatFile;
				}
			}else{
				//Do nothing if there is a empty line in the file
			}
		}
	}

	private void existCanvas(List<String> file) throws ExceptionFormatFile {
		ExceptionFormatFile excepFormatFile;
		if(file!=null && !file.isEmpty()){ 
			//check if exists a canvas at the first line
			if(file.get(0)==null || file.get(0).isEmpty() || file.get(0).charAt(0) != 'C'){
				excepFormatFile = new ExceptionFormatFile();
				excepFormatFile.setId("FILE "+ExceptionFormatFile.ERROR);
				excepFormatFile.setMsnUser("You need a canvas to draw");
				throw excepFormatFile;
			}
		}else{
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setId("FILE "+ExceptionFormatFile.WARNING);
			excepFormatFile.setMsnUser("File Empty!!");
			throw excepFormatFile;
		}
	}
	
	/**
	 * Validate if the instruction to draw has the correct format
	 * @param draw array with the instruction to draw
	 * @param numParm number of parameters of the instruction
	 * @param limit limited position of parameters
	 * @param format format of the instruction
	 * @throws ExceptionFormatFile if there is a problem with the format of the shape's parameters
	 */
	public void canDrawShape(String[]draw, int numParm, int limit, String format) throws ExceptionFormatFile{
		ExceptionFormatFile excepFormatFile;
		String param;
		if(draw.length==numParm){
			for(int i=1; i<limit; i++){
				param = draw[i];
				if(param.isEmpty() || !isNaturalNumber(param)){
					excepFormatFile = new ExceptionFormatFile();
					excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
					excepFormatFile.setMsnUser("Invalid parameters format. Please check "+format+" ."+Arrays.toString(draw)+". Line: "+lineNum);
					throw excepFormatFile;
				}
			}
		}else{
			excepFormatFile = new ExceptionFormatFile();
			excepFormatFile.setId("SHAPE "+ExceptionFormatFile.ERROR);
			excepFormatFile.setMsnUser("Invalid parameters format. Please check "+format+" ."+Arrays.toString(draw)+". Line: "+lineNum);
			throw excepFormatFile;
		}
	}
	
	/**
	 * Save the results of the graphic in a file 
	 * @throws ExceptionAccessFile if there is a problem saving the graphic in a file
	 * @throws IOException if there is a problem accessing to the file
	 */
	public void saveGraphic() throws ExceptionAccessFile, IOException{
		accessFile.writeToFile(filePath.substring(0,filePath.lastIndexOf('/'))+"/output.txt", graphics.getPrintGraphic().toString(), 0);	
	}

	/**
	 * Validate if a number belongs a the set of natural numbers
	 * @param number value to validate
	 * @return true is the number is natural
	 */
	public boolean isNaturalNumber(String number){
		try{
			int num = Integer.parseInt(number);
		    return (num>0? true : false);
		}catch(NumberFormatException nfe){
			return false;
		}
	}
}
