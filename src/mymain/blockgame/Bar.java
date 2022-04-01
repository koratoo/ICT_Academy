package mymain.blockgame;

import java.awt.Graphics;

import myutil.MyConstant;

public class Bar extends Item{

	int width;
	int height;
	
	int key_state = MyConstant.Key.NONE;
	int speed = 10;
	
	@Override
	public void draw(Graphics g){
		
		g.setColor(color);
		g.fillRect(pos.x,pos.y,width,height);
		
	}
	
	@Override
	public void move(){
		
		if(key_state == MyConstant.Key.LEFT){
			pos.x -= speed;
		}else if(key_state == MyConstant.Key.RIGHT){
			pos.x += speed;
		}
	}
}
