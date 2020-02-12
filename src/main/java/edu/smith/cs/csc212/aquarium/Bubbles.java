package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
// import java.util.Random;
import java.awt.geom.Ellipse2D;
import java.util.Random;

// 1. make one bubble 2. make + w/ array
public class Bubbles {
	int x;
	int y;
	Color color;
	int destX;
	int destY;

	// Create a random number generator:
	Random rand = new Random();

	public Bubbles(Color c, int startX, int startY) {
		this.color = c;
		this.x = startX;
		this.y = startY;
		dest();
	}

	// random destination
	private void dest() { 
		this.destX = rand.nextInt(475);
		this.destY = rand.nextInt(475);
	}

	public void move() {
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
		this.move();
		this.one(g, color, destX, destX);
	}

	public void one(Graphics2D g, Color color, int x, int y) {

		// Draw the bubble
		g.setColor(color);

		Shape bub = new Ellipse2D.Double(x - 15, y - 10, 10, 10);

		g.fill(bub);
		g.draw(bub);

	}
}
