package com.snowdrama.leetest.entitys;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {
	
	public float speed = 0.5f;
	public Rectangle rect;
	
	public Player(int x, int y){
		this.x = x;
		this.y = y;
		rect = new Rectangle(x,y,16,16);
	}
	
	public void move(float x, float y){
		this.x += (x*speed);
		this.y += (y*speed);
		rect.setPosition(new Vector2(this.x,this.y));
	}
}
