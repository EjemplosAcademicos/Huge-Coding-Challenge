package com.huge.drawingtool;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.huge.drawingtool.util.exceptions.ExceptionFormatFile;

@RunWith(Parameterized.class)
public class DrawingToolCanvasTest {

	private DrawingTool drawingTool;
	private String pathFile;
	
	public DrawingToolCanvasTest(String pathFile) {
		this.pathFile = pathFile;
	}
	
	@Parameters
	public static Collection<Object[]> paths(){
		Object[][] paths = new Object[][]{
			{"/test_files/emptyfirstline.txt"},
			{"/test_files/nocanvas.txt"},
			{"/test_files/wrongfile.png"},
		};
		return Arrays.asList(paths);
	}
	
	@Before
	public void constructor(){
		drawingTool = new DrawingTool();
	}
		
	@After
	public void destroy(){}

	@Test
	public void testNewGraphicValidCanvas(){
		try {
			drawingTool.newGraphic(pathFile);
			fail("Excepted exception no exist canvas. "+pathFile);
		} catch (ExceptionFormatFile e) {
			assertEquals("You need a canvas to draw", e.getMsnUser());
		} catch(Exception e){
			fail("Don't excepted this exception");
		}
	}

}
