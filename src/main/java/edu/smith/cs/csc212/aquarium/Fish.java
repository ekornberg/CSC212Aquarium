package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

// Emma Kornberg; no lab buddy (followed along in class)

public class Fish {
	// Every fish has its own position
	// Every fish has an x and a y which is an int
	int x;
	int y;
	// Every fish should have its own color.
	Color color;
	// Boolean isLittle
	boolean isLittle;
	// Boolean facesLeft
	boolean facesLeft;
	// Create a random number generator:
	Random rand = new Random();
			
	// Every fish has random destination when not hungry
	int destX;
	int destY;
	
	// When hungry, every fish goes to food
	int foodX;
	int foodY;	
	
	// Is fish hungry?
	boolean hungry;
	// Has fish been fed?
	boolean fed; // Fed and not hungry
	
	// Fish constructor
	public Fish(Color c,
			int startX,
			int startY, 
			boolean isLittle) {
		this.color = c;
		this.x = startX;
		this.y= startY;
		this.isLittle = isLittle;
	}	
	
	// Is fish hungry?
		public void hungry(Graphics2D g) {
			// If fish is near food, fish is fed and isn't hungry
			if (this.x > 375 && this.y > 375) {
				this.fed = true;
				this.hungry = false;
				g.setColor(color);
				g.setColor(Color.red);
				Food hunger = new Food(Color.pink);
				hunger.drawm(g, Color.pink);
				swim(g); // Fish move away from food
			
			// If fish is far from food, fish gets hungry
			} else if (this.x < 150 || this.y < 150) {
				this.fed = false;
				this.hungry = true;
				g.setColor(color);
				g.setColor(Color.gray);
				
				// Fish is hungry so moves to food
				final int High = 495;
				final int Low = 375;
				this.foodX = rand.nextInt(High - Low) + Low;
				this.foodY = rand.nextInt(High - Low) + Low;
				
				// If hungry fish are at top, move down toward food 
				} if (this.y < this.foodY ) {
					this.y += 1;
				// If hungry fish to left, move right toward food
				} else if (this.x < foodX ) {
					this.facesLeft = false;
					this.x += 1;
					
				// If fish is between zones, fish moves to random destination	
				} else {
					this.fed = true;
					this.hungry = false;
					g.setColor(color);
					g.setColor(Color.red);
					Food hunger = new Food(Color.pink);
					hunger.drawm(g, Color.pink);
					swim(g); // Fish move away from food
					}		
			}
	
	// If not hungry, fish go to random destination and face destination
		private void dest() {
			this.destX = rand.nextInt(375);
			this.destY = rand.nextInt(375);
			if (this.x < this.destX) {
				this.facesLeft = false;
			} else {
				this.facesLeft = true;
			}
		}	
	
	// If not hungry, fish move at fixed speed toward random destination
	public void swim(Graphics2D g) {
		// When reach destination, choose new
		if (this.x == this.destX && 
				this.y == this.destY) {
			dest();
		// If fish are at bottom, move up toward destination
		} if (this.y < this.destY ) {
			this.y += 10;
		// If fish are at top, move down toward destination 
		} if (this.y > this.destY ) {
			this.y -= 10;
		// If fish to left, move right toward destination
		} if (this.x < destX ) {
			this.x += 10;
		// If fish to right, move left toward destination
		} if (this.x > destX ) {
			this.x -= 10;
		}
	}
	
	public void draw(Graphics2D g) {		
		hungry(g);
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