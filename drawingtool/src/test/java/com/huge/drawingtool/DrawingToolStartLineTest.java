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
public class DrawingToolStartLineTest {
	
	private DrawingTool drawingTool;
	private String pathFile;
	
	public DrawingToolStartLineTest(String pathFile) {
		this.pathFile = pathFile;
	}
	
	@Parameters
	public static Collection<Object[]> paths(){
		Object[][] paths = new Object[][]{
			{"D:/Huge/Coding Challenge/wk_luna_huge/drawingtool/src/test/resources/test_files/wrong_start_line_1.txt"},
			{"D:/Huge/Coding Challenge/wk_luna_huge/drawingtool/src/test/resources/test_files/wrong_start_line_2.txt"},
			{"D:/Huge/Coding Challenge/wk_luna_huge/drawingtool/src/test/resources/test_files/nocanvas.txt"},
			{"D:/Huge/Coding Challenge/wk_luna_huge/drawingtool/src/test/resources/test_files/bucketbadcolor.txt"},
			{"D:/Huge/Coding Challenge/wk_luna_huge/drawingtool/src/test/resources/test_files/bucketbadcolor2.txt"},
			{"D:/Huge/Coding Challenge/wk_luna_huge/drawingtool/src/test/resources/test_files/bucketbadcolor3.txt"}

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
	public void testNewGraphicValidFormatLine() {
		try {
			drawingTool.newGraphic(pathFile);
			fail("Excepted exception invalid format option. "+pathFile);
		} catch (ExceptionFormatFile e) {
			assertTrue(true);
		} catch(Exception e){
			fail("Don't excepted this exception");
		}
	}

}
