package com.huge.drawingtool.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class AccessFile {
	
	private RandomAccessFile raf;
		
	public List<String> readFile(String filePath) throws IOException{
		List<String> listLine = new ArrayList<String>();
		raf = new RandomAccessFile(filePath, "r");
	    String line;
	    while((line = raf.readLine()) != null) {
	    	listLine.add(line);
	    }
	    raf.close();
	    return listLine;
	}
	
	public void writeToFile(String filePath, String data, int position) throws IOException {
		File file = new File(filePath);
		file.delete();
		raf = new RandomAccessFile(filePath, "rw");
        raf.seek(raf.length());
        raf.write(data.getBytes());
        raf.close();
	}

}
