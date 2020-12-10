package com.simulation.gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import com.simulation.Constanta;
import com.simulation.enumaration.ID;

public class Obstacle extends GameObject {

	private int WIDTH = 86;
	private int LAST_OBS_POS_X = Constanta.WIDTH;
	private int HEIGHT = randomHeight();
//	private int SECOND_PIPE = Constanta.HEIGHT - (HEIGHT + 200);
	public static int DIST = 277;
	
	Random r;
	public Obstacle(int x, int y, ID id) {
		super(x, y, id);
		
	}
	
	
	
	public void tick() {
		x -= 2;
		
		if (x < (-WIDTH)) {
			x = Constanta.WIDTH + WIDTH;
	
			HEIGHT = randomHeight();
		}
	}
	
	public Rectangle scorringBound() {
		return new  Rectangle(x+WIDTH, 0, 1, Constanta.HEIGHT);
	}
	
	public Rectangle getFirstBound() {
		return new  Rectangle(x-10, 0, WIDTH+20, HEIGHT);
	}
	
	public Rectangle getSecondBound() {
		int SECOND_PIPE = Constanta.HEIGHT - (HEIGHT + 200);
		return new Rectangle(x-10, Constanta.HEIGHT - SECOND_PIPE, WIDTH+20, SECOND_PIPE);
	}

	private int randomHeight() {
		r = new Random();
		int max = Constanta.HEIGHT -200;
		int min = 10;
		return r.nextInt(max - min) + min;
	}

	public void render(Graphics g) {
		
		Graphics2D a = (Graphics2D) g;


		

		
		g.setColor(Color.GREEN);
		g.fillRect(x, 0, WIDTH, HEIGHT);
		g.fillRect(x-10, HEIGHT-20, WIDTH + 20, 20);
	
		int SECOND_PIPE = Constanta.HEIGHT - (HEIGHT + 200);
		g.fillRect(x, (Constanta.HEIGHT - SECOND_PIPE), WIDTH, SECOND_PIPE);
		g.fillRect(x-10, (Constanta.HEIGHT - SECOND_PIPE) - 20, WIDTH + 20, 20);
		
		a.setColor(Color.green);
		a.drawRect(x-10, Constanta.HEIGHT - SECOND_PIPE, WIDTH+20, SECOND_PIPE);
//		
		a.drawRect(x-10, 0, WIDTH+20, HEIGHT);		
		a.drawRect(x+WIDTH, 0, 1, Constanta.HEIGHT);
	}

	private void addObs(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
