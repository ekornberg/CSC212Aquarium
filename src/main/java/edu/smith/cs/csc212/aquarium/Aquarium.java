package edu.smith.cs.csc212.aquarium;

import java.awt.Color;

// https://github.com/jjfiv/CSC212Aquarium

import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

/**
 * Aquarium is a graphical "application" that uses some code I built and have
 * shared with you that takes care of opening a window and communicating with
 * the user in a simple way.
 * 
 * The method draw is called 50 times per second, so we make an animation by
 * drawing our fish in one place, and moving that place slightly. The next time
 * draw gets called, our fish looks like it moved!
 * 
 * @author jfoley
 *
 */
public class Aquarium extends GFX {
	/**
	 * This is a static variable that tells us how wide the aquarium is.
	 */
	public static int WIDTH = 500;
	/**
	 * This is a static variable that tells us how tall the aquarium is.
	 */
	public static int HEIGHT = 500;

	/**
	 * Put a snail on the top of the tank.
	 */
	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top");

	/**
	 * This is a constructor, code that runs when we make a new Aquarium.
	 */
	public Aquarium() {
		// Here we ask GFX to make our window of size WIDTH and HEIGHT.
		// Don't change this here, edit the variables instead.
		super(WIDTH, HEIGHT);

		// Many bubbles
		for (int i = 0; i < bubbles.length; i++) {
			bubbles[i] = new Bubble(Color.white);
		}

		// Many seaweeds
		for (int i = 0; i < sea.length; i++) {
			sea[i] = new Food(Color.green);
		}
	}

	// Make fish
	Fish nemo = new Fish(Color.red, 250, 250, true);
	Fish marlin = new Fish(Color.cyan, 100, 100, false);
	Fish trout = new Fish(Color.orange, 400, 200, true);
	Fish dory = new Fish(Color.magenta, 50, 50, false);

	// Make chest
	Bubble treasure = new Bubble(Color.black);
	Bubble lock = new Bubble(Color.yellow);
	Bubble line = new Bubble(Color.gray);

	// Make bubbles
	Bubble bubb = new Bubble(Color.white);
	Bubble[] bubbles = new Bubble[10];

	// Make seaweed
	Food seaweed = new Food(Color.green);
	Food[] sea = new Food[10];

	// Make sand
	Food sand = new Food(Color.orange);
	
	// Make hunger meter
	Food empty = new Food(Color.white);
	Food label = new Food(Color.darkGray);
	
	//public void meter(Graphics2D g) {
		//Fish.hungry();
	//}

	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());

		// Draw sand
		sand.drawSand(g, Color.orange);
		
		// Draw hunger meter
		empty.drawE(g, Color.white);
		label.drawLabel(g);

		// Draw fish
		nemo.draw(g);
		marlin.draw(g);
		trout.draw(g);
		dory.draw(g);

		// Draw treasure chest
		treasure.drawChest(g);
		lock.drawLock(g);
		line.drawLine(g);

		// Draw bubbles
		for (Bubble b : this.bubbles) {
			b.draw(g);
		}

		// Draw our snail!
		algorithm.draw(g);

		// Draw seaweed
		for (Food f : this.sea) {
			f.draw(g);
		}
	}

	public static void main(String[] args) {
		// Uncomment this to make it go slower!
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many
		// print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}
}