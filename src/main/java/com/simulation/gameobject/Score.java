package com.simulation.gameobject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.simulation.Constanta;
import com.simulation.enumaration.ID;
import com.simulation.manager.Handler;

public class Score extends GameObject {

	private int score;
	private Handler handler;
	
	private boolean counting;
	

	private boolean prevState = false;
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	
	public Score(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick() {
		calcScore();
	}

	private void calcScore() {
		List<GameObject> obs = handler.object.stream().filter(o -> o.getId() == ID.OBSTACLE).collect(Collectors.toList());
		Rectangle checkPoint = new Rectangle(0, 0, 1, Constanta.HEIGHT);
		List<Boolean> intersect = new ArrayList<Boolean>();
		
// 		intersect.add(false);
// 		intersect.add(false);
		for (GameObject g : obs) {
			Obstacle ob = (Obstacle) g;
			if (checkPoint.intersects(ob.scorringBound())) {
					score = score+1;
					counting = true;
			}
		}
	}
	
	public void render(Graphics g) {
//		g.setColor(Color.WHITE);
//		g.fillRect(x, y, 50, 25);
//		g.fillRect(Constanta.WIDTH, 0, 10, Constanta.HEIGHT);
		
		Font myFont = new Font ("Courier New", 1, 20);
		g.setColor(Color.WHITE);
		g.setFont(myFont);
		g.drawString("Score : "+ Integer.toString(score), x + 25, y + 15);

			g.setColor(Color.GREEN);
		
		g.drawRect(0, 0, 2, Constanta.HEIGHT);
	
	}

}
