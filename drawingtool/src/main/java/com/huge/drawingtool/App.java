package com.huge.drawingtool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.huge.drawingtool.util.exceptions.ExceptionDrawingTool;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DrawingTool drawingTool = new DrawingTool();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter path file (C:/xxx/xxx/input.txt): ");
        try {
			String pathFile = br.readLine();
        	//String pathFile = "D:/input.txt";
			drawingTool.newGraphic(pathFile);
	        drawingTool.saveGraphic();
	        System.out.print("Graphic created!!. It is in the same directory that input.txt with the name output.txt");
		}     
        catch (ExceptionDrawingTool e) {
			e.showUserMessage();
		}
        catch(Exception e){
        	e.printStackTrace();
        }
    }
}
