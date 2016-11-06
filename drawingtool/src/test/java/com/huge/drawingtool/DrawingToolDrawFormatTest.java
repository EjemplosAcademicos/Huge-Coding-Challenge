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
public class DrawingToolDrawFormatTest {
	
	private DrawingTool drawingTool;
	private String[] shape;
	private int numParam;
	private int limit;
		
	public DrawingToolDrawFormatTest(String[] shapeCanvas, int numParam, int limit) {
		this.shape = shapeCanvas;
		this.numParam = numParam;
		this.limit = limit;
	}
	
	@Parameters
	public static Collection<Object[]> shapes(){
		Object[][] shapes= new Object[][]{
			{new String[]{"C"},	3, 3},						//0
			{new String[]{"C","",""}, 3, 3},				//1
			{new String[]{"C","3"},	3, 3},					//2
			{new String[]{"C","-3","-4"}, 3, 3},			//3
			{new String[]{"C","rr","sd"}, 3, 3},			//4
			{new String[]{"C","3.4","4"}, 3, 3},			//5
			{new String[]{"C"," "," "},	4, 4},				//6
			{new String[]{"C","0","0"},	 3, 3}	,			//7
			{new String[]{"C","34"}, 3, 3},					//8
			{new String[]{"C","343","0"}, 3, 3},			//9
			{new String[]{"P","3","-6"}, 3, 3},				//10
			{new String[]{"P","","6"}, 3, 3},				//11
			{new String[]{"P","9A","4F"}, 3, 3},			//12
			{new String[]{"P","$$"}, 3, 3}, 				//13
			{new String[]{"P","3"," "}, 3, 3},				//14
			{new String[]{"L","","","",""}, 5, 5},			//15
			{new String[]{"L"," "," "," "," "}, 5, 5},		//16
			{new String[]{"L","dsd","33","43","3"}, 5, 5},	//17
			{new String[]{"L","0","0","0","0"}, 5, 5},		//18
			{new String[]{"L","231","32","32"}, 5, 5},		//19
			{new String[]{"L","-5","5","-6","8"}, 5, 5},	//20
			{new String[]{"L","6","5","5","-6"}, 5, 5},		//21
			{new String[]{"L","2","3","5","6,6"}, 5, 5},	//22
			{new String[]{"B","","",""}, 4, 3},				//23
			{new String[]{"B"," "," "," "}, 4, 3},			//24
			{new String[]{"B","2"," "}, 4, 3},				//25
			{new String[]{"B","as","ad","asd"}, 4, 3},		//26
			{new String[]{"B","-2","3",""}, 4, 3},			//27
			{new String[]{"B","2","-4",""}, 4, 3},			//28
			{new String[]{"B"," 3","4",""}, 4, 3},			//29
			{new String[]{"B","0","0","s"}, 4, 3},			//30
			{new String[]{"B","3","4.4","3"}, 4, 3},		//31
			
		};
		return Arrays.asList(shapes);
	}
	
	@Before
	public void constructor(){
		drawingTool = new DrawingTool();
	}
		
	@After
	public void destroy(){}

	@Test
	public void testcanDrawShape() {
		try {
			drawingTool.canDrawShape(shape, numParam, limit, "");
			fail("Excepted exception invalid format option. "+Arrays.toString(shape));
		} catch (ExceptionFormatFile e) {
			assertTrue(true);
		} catch(Exception e){
			fail("Don't excepted this exception");
		}
	}
}
