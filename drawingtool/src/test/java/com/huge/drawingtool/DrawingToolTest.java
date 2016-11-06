package com.huge.drawingtool;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.huge.drawingtool.util.exceptions.ExceptionFormatFile;

public class DrawingToolTest {
	
	private DrawingTool drawingTool;	
	
	@Before
	public void constructor(){
		drawingTool = new DrawingTool();
	}
		
	@After
	public void destroy(){}

	@Test
	public void testNewGraphicEmptyFile() {
		try {
			drawingTool.newGraphic("/test_files/emptyfile.txt");
			fail("Excepted exception empty file");
		} catch (ExceptionFormatFile e) {
			assertEquals("File Empty!!", e.getMsnUser());
		} catch(Exception e){
			fail("Don't excepted this exception");
		}
	}	
}
