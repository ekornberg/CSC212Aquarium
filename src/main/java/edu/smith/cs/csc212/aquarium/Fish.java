package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

public class Fish {
	// Every fish has an x which is an int
	int x;
	int y;
	Color color;
	boolean isLittle;
	boolean facingLeft;
	// Every fish has a destination (rand use guess game code but try withgiven #)
	int destX;
	int destY;

	public Fish(Color c,
			int startX,
			int startY, boolean isLittle) {
		this.color = c;
		this.x = startX;
		this.y= startY;
		this.isLittle = isLittle;
		//this.facingLeft = facingLeft;
		
		this.destX = 450;
		this.destY = 450; //move current guess twds secr #
	}
	
	public void swim() {
		if (this.y < this.destY ) {
		this.y += 1;
		}	
	}
	
	public void draw(Graphics2D g) {		
		this.swim();
		// fish face left and are small
		// smallFacingRight, facingLeft, and facingRight
		DrawFish.smallFacingLeft(g,
				this.color, this.x, this.y);
		
	}
}

// get red fish back