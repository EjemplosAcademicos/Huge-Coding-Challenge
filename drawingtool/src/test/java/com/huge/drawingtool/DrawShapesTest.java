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

import com.huge.drawingtool.Graphic;
import com.huge.drawingtool.boxtool.shapes.Canvas;
import com.huge.drawingtool.boxtool.shapes.Line;
import com.huge.drawingtool.boxtool.shapes.Point;
import com.huge.drawingtool.boxtool.shapes.Rectangle;
import com.huge.drawingtool.boxtool.shapes.Shape;
import com.huge.drawingtool.util.exceptions.ExceptionShape;

@RunWith(Parameterized.class)
public class DrawShapesTest {
	
	private Graphic graphic;
	private Shape shape;
	
	public DrawShapesTest(Shape shape){
		this.shape = shape;
	}
	
	@Before
	public void constructor() throws ExceptionShape{
		Canvas canvas = new Canvas(new Point(5,5));
		graphic = new Graphic(canvas);
	}
		
	@After
	public void destroy(){}
	
	@Parameters
	public static Collection<Object[]> shapes(){
		Object[][] shapes= new Object[][]{	
			//lines
		    {new Line(new Point(0,0), new Point(0,2))},			//0
		    {new Line(new Point(1,1), new Point(-2,-4))},		//1
			{new Line(new Point(1,1), new Point(3,2))},			//2
			{new Line(new Point(6,6), new Point(6,7))},			//3
			{new Line(new Point(-3,-3), new Point(-3,-2))},		//4
			{new Line(new Point(1,2), new Point(2,3))},			//5
			{new Line(new Point(3,3), new Point(1,3))},			//6

			//rectangle
			{new Rectangle(new Point(0,0), new Point(2,2))},	//7
			{new Rectangle(new Point(5,5), new Point(1,1))},	//8
			{new Rectangle(new Point(-4,-2), new Point(2,2))},	//9
			{new Rectangle(new Point(1,1), new Point(-2,-2))},	//10
			{new Rectangle(new Point(6,3), new Point(7,9))},	//11
			{new Rectangle(new Point(0,0), new Point(2,2))},	//12
			
			//canvas
			{new Canvas(new Point(0, 0))},						//13
			{new Canvas(new Point(-1, -5))},					//14
			{new Canvas(new Point(1, -5))},					    //15
			{new Canvas(new Point(-4, 5))},					    //16
			{new Canvas(new Point(1025, 769))},					//17
			{new Canvas(new Point(1025, 76))},					//18
			{new Canvas(new Point(100, 769))},					//19
			
		};
		return Arrays.asList(shapes);
	}
	

	@Test
	public void testDrawShape() {
		try {
			graphic.drawShape(shape);
			fail("Excepted exception can´t draw the shape . "+shape.toString());
		} catch (ExceptionShape e) {
			assertTrue(e.getMsnUser(),true);
		} catch(Exception e){
			fail("Don't excepted this exception");
		}
	}

}
