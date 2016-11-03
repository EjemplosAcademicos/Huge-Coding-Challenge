package com.huge.drawingtool.boxtool;

public enum Contour {
	
	X('x'),
	DOT('.'),
	HYPHEN('-'),
	HASH('#'),
	ASTERISK('*'),
	FORWARD_SLAH('/'),
	VERTICAL_BAR('|'),
	SPACE(' ');
		
	private char contour;
	
	private Contour(){
		this.contour = 'x';
	}
	
	private Contour(char contour){
		this.contour = contour;
	}

	public char getContour() {
		return contour;
	}

	public void setContour(char contour) {
		this.contour = contour;
	}
	
	
}
