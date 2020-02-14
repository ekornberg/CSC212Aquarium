package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.Random;

// https://www.youtube.com/watch?v=QkGI5_HhiU8&feature=youtu.be
// https://gist.github.com/jjfiv/767a8041868caae861278659abc063ac

public class Food {
	int x;
	int y;
	
	
	// Create a random number generator:
	Random rand = new Random();
	
	// Food constructor
	public Food(Color c) {
		// Food placed randomly between 375-480 x and y
		final int High = 480;
		final int Low = 375;
		this.x = rand.nextInt(High-Low) + Low;
		this.y = rand.nextInt(High-Low) + Low;
	}
	
	// Draw seaweed
	public void draw(Graphics2D g) {
		Font f = g.getFont();
		g.setFont(f.deriveFont(40.23f));
		g.setColor(Color.green);
		g.drawString("~", x, y);
	}
	
	// Draw sand
	public void drawSand(Graphics2D g, Color c) {
		this.sand(g, c);
	}
	
	public void sand(Graphics2D g, Color c) {
		Shape sand = new Rectangle2D.Double(0, 480, 500 , 40);
		g.setColor(c);
		g.fill(sand);
		g.setColor(Color.orange);
		g.draw(sand);
	}
	
	// Hunger meter1
	public void meter(Graphics2D g, Color c) {
		Shape hunger = new Rectangle2D.Double(10, 10, 80, 20);
		g.setColor(c);
		g.fill(hunger);
		g.setColor(Color.pink);		
	}
	
	public void meter2(Graphics2D g, Color c) {
		Shape hunger2 = new Rectangle2D.Double(40, 10, 80, 20);
		g.setColor(c);
		g.fill(hunger2);
		g.setColor(Color.pink);		
	}
	
	public void drawm(Graphics2D g, Color c) {
		this.meter(g, c);
	}
	
	public void drawm2(Graphics2D g, Color c) {
		this.meter2(g, c);
	}
	
	public void empty(Graphics2D g, Color c) {
		Shape empty = new Rectangle2D.Double(10, 10, 80, 20);
		g.setColor(c);
		g.fill(empty);
		g.setColor(Color.pink);
	}
	
	public void drawE(Graphics2D g, Color c) {
		this.empty(g, c);
	}
	
	public void drawLabel(Graphics2D g) {
		Font f = g.getFont();
		g.setFont(f.deriveFont(15f));
		g.setColor(Color.darkGray);
		g.drawString("HUNGRY!", 15, 25);
	}
	
	
}
