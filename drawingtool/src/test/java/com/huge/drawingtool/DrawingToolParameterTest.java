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

@RunWith(Parameterized.class)
public class DrawingToolParameterTest {
	
	private DrawingTool drawingTool;
	private String number;
	private String natural;
	
	public DrawingToolParameterTest(String number, String natural) {
		this.number = number;
		this.natural = natural;
	}
	
	@Parameters
	public static Collection<Object[]> nums(){
		Object[][] nums = new Object[][]{
			{"AA","1"},
			{"cc","22"},
			{"-34","03"},
			{"5.5","45"},
			{"0","04"},
			{"vss3","3344"},
			{"3ff","3453453"},
			{"*","0239"},
			{" ","0500"},
			{"","53"},
			{"#$%","68"},
			{"#$%hddhjtdhdsjducheruregndklgmghghgnghjjhgjghjhgjhgjhgjghjghjhgjghjhgjhgjhgjghjhgjghjghjghjhgjghjghjhgjghjgherigjriggkdmgkdgkdgmdfgkmdfgldmgdlfmggdf",
			 "43534534543535345345345345534534534534534534534534534534534534543534534534534534534534534534534534534534534534534534534534446556756765867868767897978978978978978979789546456456455464564578"},
		};
		return Arrays.asList(nums);
	}
	
	@Before
	public void constructor(){
		drawingTool = new DrawingTool();
	}
		
	@After
	public void destroy(){}

	@Test
	public void testIsNaturalNumberFalse() {
		assertTrue(!drawingTool.isNaturalNumber(number));
	}
	
	@Test
	public void testIsNaturalNumberTrue() {
		assertTrue(drawingTool.isNaturalNumber(natural));
	}

}
