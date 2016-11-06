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

import com.huge.drawingtool.boxtool.Color;
import com.huge.drawingtool.boxtool.paint.BucketFill;
import com.huge.drawingtool.boxtool.paint.Paint;
import com.huge.drawingtool.boxtool.shapes.Canvas;
import com.huge.drawingtool.boxtool.shapes.Point;
import com.huge.drawingtool.util.exceptions.ExceptionPaint;
import com.huge.drawingtool.util.exceptions.ExceptionShape;

@RunWith(Parameterized.class)
public class PaintTest {

	private Graphic graphic;
	private Paint paintTool;
	
	public PaintTest(Paint paintTool){
		this.paintTool = paintTool;
	}
	
	@Before
	public void constructor() throws ExceptionShape{
		Canvas canvas = new Canvas(new Point(5,5));
		graphic = new Graphic(canvas);
	}
		
	@After
	public void destroy(){}
	
	@Parameters
	public static Collection<Object[]> tools(){
		Object[][] tools= new Object[][]{
			//Bucket Fill
		    {new BucketFill(new Point(0,0), new Color('o'))},   //0
		    {new BucketFill(new Point(-1,-1), new Color('o'))},   //0
		    {new BucketFill(new Point(6,6), new Color('o'))},   //0
		    {new BucketFill(new Point(7,4), new Color('o'))},   //0
		    {new BucketFill(new Point(4,6), new Color('o'))},   //0
		    
		};
		return Arrays.asList(tools);
	}
	

	@Test
	public void testPainTool() {
		try {
			graphic.paint(paintTool);;
			fail("Excepted exception can´t draw the shape . "+paintTool.toString());
		} catch (ExceptionPaint e) {
			assertTrue(e.getMsnUser(),true);
		} catch(Exception e){
			fail("Don't excepted this exception");
		}
	}

}
