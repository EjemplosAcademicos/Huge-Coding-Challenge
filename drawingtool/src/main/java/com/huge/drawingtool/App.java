package com.huge.drawingtool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Path;

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
        System.out.print("Enter path file (C:/xxx/xxx/namefile): ");
        try {
			String pathFile = br.readLine();
			drawingTool.newGraphic(pathFile);
	        drawingTool.saveGraphic();
	        System.out.print("Graphic created!!. It is in the same directory that input.txt with the name output.txt");
		}     
        catch (ExceptionDrawingTool e) {
			e.showUserMessage();
		}
        catch(IOException e){
        	e.printStackTrace();
        }
        catch(Exception e){
        	e.printStackTrace();
        }
    }
}
