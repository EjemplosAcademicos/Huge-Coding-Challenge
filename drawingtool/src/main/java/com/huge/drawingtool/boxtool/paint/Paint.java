/**
 * 
 */
package com.huge.drawingtool.boxtool.paint;

import com.huge.drawingtool.boxtool.Color;

/**
 * @author itos
 *
 */
public abstract class Paint {

	private Color color;
	
	Paint(){
		this.color = new Color();
	}
	
	Paint(Color color){
		this.color = color;
	}
	
	public abstract void paint();
}
