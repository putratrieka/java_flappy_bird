package com.simulation.adapter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.simulation.enumaration.ID;
import com.simulation.gameobject.GameObject;
import com.simulation.gameobject.Particle;
import com.simulation.manager.Handler;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0 ; i < handler.object.size(); i ++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.PARTICLE) {
				if (key == KeyEvent.VK_SPACE) {
					Particle p = (Particle) tempObject;
					p.setUp(true);
					p.setY(p.getY() -85);
					tempObject = p;

				}
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.PARTICLE) {
				if (key == KeyEvent.VK_SPACE) {
					Particle p = (Particle) tempObject;
					p.setUp(false);
					tempObject = p;
				}
			}
		}

	}

	public void keyTyped(KeyEvent e) {
		int key = e.getKeyCode();
		
	}

}
