package com.huge.drawingtool.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.huge.drawingtool.util.exceptions.ExceptionAccessFile;
import com.huge.drawingtool.util.exceptions.ExceptionFormatFile;

/**
 * The AccessFile class provides operations to read and to write in a specific file
 * @author sebas.monsalve@gmailcom
 */
public class AccessFile {
	
	private RandomAccessFile raf;
		
	public List<String> readFile(String filePath) throws ExceptionAccessFile{
		try{
			List<String> listLine = new ArrayList<String>();
			raf = new RandomAccessFile(filePath, "r");
		    String line;
		    while((line = raf.readLine()) != null) {
		    	listLine.add(line);
		    }
		    raf.close();
		    return listLine;
		} catch (IOException e) {
			ExceptionAccessFile excepAccessFile = new ExceptionAccessFile();
			excepAccessFile.setExceptionSource(e);
			excepAccessFile.setId("FILE "+ExceptionFormatFile.ERROR);
			excepAccessFile.setMsnTechnical("Error class readFile,  method readFile");
			excepAccessFile.setMsnUser("Error reading the input file. Please, check the file or the path");
			throw excepAccessFile;
		}
	}
	
	public void writeToFile(String filePath, String data, int position) throws IOException, ExceptionAccessFile {
		try{
			File file = new File(filePath);
			file.delete();
			raf = new RandomAccessFile(filePath, "rw");
	        raf.seek(raf.length());
	        raf.write(data.getBytes());
	        raf.close();
		}catch (IOException e) {
			ExceptionAccessFile excepAccessFile = new ExceptionAccessFile();
			excepAccessFile.setExceptionSource(e);
			excepAccessFile.setId("FILE "+ExceptionFormatFile.ERROR);
			excepAccessFile.setMsnTechnical("Error class DrawingTool,  method newGraphic");
			excepAccessFile.setMsnUser("Error saving the graphic in the output file. (Check the permissions of your directory)");
			throw excepAccessFile;
		}
	}

}
