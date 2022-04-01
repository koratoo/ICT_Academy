package mymain.blockgame;

import java.awt.Color;
import java.awt.Graphics;

public class Block extends Item {

	
	int width;
	int height;
	Color color;
	
	boolean bShow = true;//깨졌냐 유무?
		
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setColor(color); // (super.color)
		//pos는 상속받은 것
		//블록이 딱 붙는 것을 방지
		g.fillRect(pos.x+1, pos.y+1, width-2, height-2);
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

}
