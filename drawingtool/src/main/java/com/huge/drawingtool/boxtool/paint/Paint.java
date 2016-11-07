/**
 * 
 */
package com.huge.drawingtool.boxtool.paint;

import com.huge.drawingtool.Graphic;
import com.huge.drawingtool.boxtool.Color;
import com.huge.drawingtool.util.exceptions.ExceptionPaint;

/**
 * The Paint abstract class provides the structure and operations to 
 * represent different forms to paint a graphic, 
 * @author sebas.monsalve@gmailcom
 */
public abstract class Paint {

	private Color color_1;
	
	Paint(){
		this.color_1 = new Color();
	}
	
	Paint(Color color_1){
		this.color_1 = color_1;
	}
		
	public Color getColor_1() {
		return color_1;
	}

	public void setColor_1(Color color_1) {
		this.color_1 = color_1;
	}

	/**
	 * Implementation to paint a specific grapchic
	 * @param graphic  contain the panel 
	 * @throws ExceptionPaint if there is a problem painting the graphic
	 */
	public abstract void paint(Graphic graphic) throws ExceptionPaint;
}
