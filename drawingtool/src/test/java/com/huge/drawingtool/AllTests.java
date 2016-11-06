package com.huge.drawingtool;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DrawingToolCanvasTest.class, DrawingToolDrawFormatTest.class,
		DrawingToolParameterTest.class, DrawingToolStartLineTest.class,
		DrawingToolTest.class, DrawShapesTest.class, PaintTest.class })
public class AllTests {

}
