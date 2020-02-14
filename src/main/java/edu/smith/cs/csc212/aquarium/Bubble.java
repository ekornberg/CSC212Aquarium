package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Random;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

// https://www.youtube.com/watch?v=QkGI5_HhiU8&feature=youtu.be

public class Bubble {
	int x;
	int y;
	Color color;
	int size;

	// Create a random number generator:
	Random rand = new Random();

	// Bubble constructor
	public Bubble(Color c) {
		this.color = c;
		this.x = rand.nextInt(150);
		final int MIN = 400;
		this.y = rand.nextInt(440 - MIN);
	}

	public void move() {
		// If bubble reaches top, wrap and start at random x-coordinate between 0-150
		if (this.y <= 0) {
			this.y = 440;
			this.x = rand.nextInt(150);
		} else {
			this.y -= 1;
		} // Wiggle bubble
		this.x = this.x + rand.nextInt(5);
		this.x = this.x - rand.nextInt(5);
	}

	public void draw(Graphics2D g) {
		// Draw the bubble
		g.setColor(color);
		final int size = 2;
		this.size = rand.nextInt(12 - size);
		Shape bub = new Ellipse2D.Double(this.x, this.y, this.size, this.size);
		g.fill(bub);
		g.draw(bub);

		// Move bubble
		this.move();
	}

	public void drawChest(Graphics2D g) {
		this.chest(g); // Draw box for chest
	}
	
	public void chest(Graphics2D g) {
		// Box for chest
		g.setColor(color);
		Shape box = new Rectangle2D.Double(20, 440, 150 , 100);
		g.fill(box);
		g.draw(box);
	}
	
	public void drawLock(Graphics2D g) {
		this.lock(g); // Draw lock for chest
	}
	
	public void lock(Graphics2D g) {
		// Lock for chest
		g.setColor(color);
		Shape lock = new Rectangle2D.Double(70, 470, 50, 15);
		g.fill(lock);
		g.setColor(Color.yellow);
	}
	
	public void drawLine(Graphics2D g) {
		this.line(g); // Draw lock for chest
	}
	
	public void line(Graphics2D g) {
		// Lock for chest
		g.setColor(color);
		Shape line = new Rectangle2D.Double(20, 470, 150, 3);
		g.fill(line);
		g.setColor(Color.yellow);
	}
}
