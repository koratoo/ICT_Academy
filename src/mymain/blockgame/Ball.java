package mymain.blockgame;

import java.awt.Graphics;

import myutil.MyConstant;

public class Ball extends Item {

	int radius = 10;//초기값 나중에 바꿔도 됨
	
	boolean bRight = true; //초기 이동방향 우측
	boolean bDown = false; //위로 이동
	
	int speed = 5; //공의 속도 결정
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setColor(color);
		g.fillOval(pos.x - radius, pos.y - radius, radius*2, radius*2);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		//좌우
		if(bRight) pos.x += speed;
		else pos.x -= speed;
		
		//상하
		if(bDown) pos.y += speed;
		else pos.y -= speed;
		
		if( (pos.x + radius) > MyConstant.BlockGame.GAMEPAN_WIDTH ) {
			
			bRight = false;
			
		}else if( (pos.x - radius) < 0) {//왼쪽
			pos.x = radius;
			bRight = true;	
		}
			
		//아래로 이동했을 때
		if ( ( pos.y + radius) > MyConstant.BlockGame.GAMEPAN_HEIGH){
			
			bDown = false;
		
		}else if((pos.y - radius) < 0) {//윗쪽
			pos.y = radius;
			bDown = true;
		}
	}

}
