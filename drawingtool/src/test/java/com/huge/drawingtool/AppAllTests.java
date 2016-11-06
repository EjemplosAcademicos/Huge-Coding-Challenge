package com.huge.drawingtool;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DrawingToolCanvasTest.class, 
				DrawingToolTest.class,
				DrawingToolStartLineTest.class,
				DrawingToolParameterTest.class,
				DrawingToolDrawFormatTest.class})
public class AppAllTests {

}
