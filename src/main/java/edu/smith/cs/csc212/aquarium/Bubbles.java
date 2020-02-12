package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
// import java.util.Random;
import java.awt.geom.Ellipse2D;

// 1. make one bubble 2. make + w/ array
public class Bubbles {

	public Bubbles(Color white, int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics2D g, Color color,
						int x, int y) {
		// Draw the bubble
		g.setColor(color);
		
		Shape bub = new Ellipse2D.Double(
				x - 15, y - 10, 10, 10);
		
		g.fill(bub);
		g.draw(bub);
		g.setColor(Color.white);		
	}
}
