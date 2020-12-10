package com.simulation.manager;

import java.awt.Graphics;
import java.util.LinkedList;

import com.simulation.gameobject.GameObject;

/*
 *  This class is used to maintain and update render object
 */
public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
		
	};
	
	public void render(Graphics g) {
		
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	};
	
	public void addObject(GameObject o) {
		this.object.add(o);
	}
	
	public void removeObject(GameObject o) {
		this.object.remove(o);
	}
}
