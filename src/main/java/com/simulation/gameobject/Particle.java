package com.simulation.gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.stream.Collectors;

import com.simulation.Constanta;
import com.simulation.Game;
import com.simulation.enumaration.ID;
import com.simulation.manager.Handler;

public class Particle extends GameObject{

	private boolean right = true;
	private boolean bottom = true;
	
	private boolean yInit = true;
	private boolean up;
	
	private Handler handler;
	
	private boolean collide;
	private Score score;

	public boolean isUp() {
		return up;
	}


	public void setUp(boolean up) {
		this.up = up;
	}


	public Particle(int x, int y, ID id, Handler handler, Score score) {
		super(x, y, id);
		
		this.handler = handler;
		this.score = score;
		velX = 5;
		velY = 5;
	}
	public Rectangle getBound() {
		return new  Rectangle(x, y, 50, 50);
	}
	

	public void tick() {
		
		if (collide) {
			Game.reset();
		}
		y += velY;
	
		if (y >= Constanta.HEIGHT -50) {
			y = Constanta.HEIGHT - 50;
		}else if (y <=0) {
			y = 0;
		}
		collide();
		
	}

	private void collide() {
		
		for (int i = 0 ; i < handler.object.size(); i++) {			
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.OBSTACLE) {
				Obstacle ob  = (Obstacle) tempObject;
				if (getBound().intersects(ob.getFirstBound())) {
					collide = true;
					return;
				}else if (getBound().intersects(ob.getSecondBound())) {
					collide = true;
					return;
				}else {
					collide = false;
					
				}		
			}
		}		
	}

	public void render(Graphics g) {
		
		if (collide) {
			g.setColor(Color.RED);	
		}else {
			g.setColor(Color.GRAY);
		}
		
		g.fillOval(x, y, 50, 50);
		if (up) {
			g.fillRect(x+25, y, 25, 25);
		}else {
			g.fillRect(x+25, y+25, 25, 25);
		}
		
		g.drawRect(x, y, 50, 50);
		
	}
}
