package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {
	// Every fish has its own position
	// Every fish has an x and a y which is an int
	int x;
	int y;
	// Every fish should have its own color.
	Color color;
	// boolean isLittle
	boolean isLittle;
	// boolean facesLeft
	boolean facesLeft;
	// Create a random number generator:
	Random rand = new Random();
			
	// Every fish has a destination
	int destX;
	int destY;
	

	public Fish(Color c,
			int startX,
			int startY, 
			boolean isLittle) {
		this.color = c;
		this.x = startX;
		this.y= startY;
		this.isLittle = isLittle;
		dest();
	}
	
	// fish faces random destination
	private void dest() {
		this.destX = rand.nextInt(475);
		this.destY = rand.nextInt(475);
		if (this.x < this.destX) {
			this.facesLeft = false;
		} else {
			this.facesLeft = true;
		}
	}
	
	// fish move at fixed speed toward destination
	public void swim() {
		// when reach destination, choose new
		if (this.x == this.destX && 
				this.y == this.destY) {
			dest();
		} if (this.y < this.destY ) {
			this.y += 1;
		} if (this.y > this.destY ) {
			this.y -= 1;
		} if (this.x < destX ) {
			this.x += 1;
		} if (this.x > destX ) {
			this.x -= 1;
		}
	}
	
	public void draw(Graphics2D g) {		
		this.swim();	
		// If small and facing right
		if (isLittle && !facesLeft) {
			DrawFish.smallFacingRight(g,
				this.color, this.x, this.y);
		}
		// If small and facing left
		if (isLittle && facesLeft) {
		DrawFish.smallFacingLeft(g,
				this.color, this.x, this.y);
		}
		// If large and facing right
		if (!isLittle && !facesLeft) {
		DrawFish.facingRight(g,
				this.color, this.x, this.y);
		}
		// If large and facing left
		if (!isLittle && facesLeft) {
		DrawFish.facingLeft(g,
				this.color, this.x, this.y);
		}
	}
}

// set side L/R/bot/top (for snail)
//trig for bubbles