package mymain.blockgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import myutil.MyConstant;

public class 벽돌게임 extends JFrame {

	JPanel gamePan;
	//코딩순서 (2)
	Timer timer = null;
	//바
	Bar bar = new Bar();
	//볼(6)
	Ball ball = new Ball();
	//벽돌생성(8)
	Block [][] block_array = new Block[6][6];
	
	public 벽돌게임() {
		// TODO Auto-generated constructor stub
		super("벽돌게임");

		
		init_gamePan();
		
		//타이머 초기화 (2)
		init_timer();
		//(3)
		init_Key_event();

		//바초기화(4)
		init_bar();
		
		//볼 초기화(6)
		init_ball();

		//블럭생성(8)
		init_block();
		
		this.setLocation(200, 100);

		
		//this.setSize(400, 400);
		pack();
		
		setResizable(false); 

		this.setVisible(true);

							
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	//(8)
	private void init_block() {
		// TODO Auto-generated method stub
		
		int block_w = MyConstant.BlockGame.GAMEPAN_WIDTH/block_array[0].length;
		int block_h =30;
		
		Color [] color_array = { Color.red, Color.green, Color.yellow, Color.cyan};
		
		for(int i = 0;i<block_array.length;i++){//행 첨자
			for(int k =0;k<block_array[i].length;k++){ //열 첨자
				
				Block block = new Block();
				block.pos.x = k*block_w;
				block.pos.y = i*block_h;
				block.width = block_w;
				block.height = block_h;
				block.color = color_array[(i+k)%color_array.length];
				
				block_array[i][k] = block;
				
				//어떤건 채우고 어떤건 안채우고
				//if(i==0||k==0)block.bShow=false;
			}
		}
		
	}
	//(6)
	private void init_ball() {
		// TODO Auto-generated method stub
		ball.pos.x = bar.pos.x + bar.width/2;//MyConstant.BlockGame.GAMEPAN_WIDTH/2;
		ball.pos.y = bar.pos.y - ball.radius;
	}
	//(4)
	private void init_bar() {
		// TODO Auto-generated method stub
		
		bar.color = Color.blue;
		
		bar.width =130;
		bar.height =30;
		
		bar.pos.x =MyConstant.BlockGame.GAMEPAN_WIDTH/2 - bar.width/2;
		bar.pos.y =MyConstant.BlockGame.GAMEPAN_HEIGH - bar.height-5;
		
	}
	//(3)
	private void init_Key_event() {
		// TODO Auto-generated method stub
			
		this.addKeyListener(new KeyAdapter() {		
			
			@Override//익명 메소드
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
					
				super.keyPressed(e);
					
				int key = e.getKeyCode();
				
				if( key == KeyEvent.VK_S) {
						//게임시작(7) : s를 누르면 시작됨
						timer.start();
					
				}
				//(7)
				if( key == KeyEvent.VK_LEFT) {
					
					bar.key_state = bar.key_state | MyConstant.Key.LEFT;
					
				}else if (key == KeyEvent.VK_RIGHT) {	
					
					bar.key_state = bar.key_state | MyConstant.Key.RIGHT;
					
			}	
		}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				//super.keyReleased(e);
				
				int key = e.getKeyCode();
						//(7)
				if( key == KeyEvent.VK_LEFT) {
					
					bar.key_state = bar.key_state ^ MyConstant.Key.LEFT;
					
				}else if (key == KeyEvent.VK_RIGHT) {	
					
					bar.key_state = bar.key_state ^ MyConstant.Key.RIGHT;
					
				}else if (key == KeyEvent.VK_RIGHT) {	
			}	
		}
	});
		
		
	}
	//(2)
	private void init_timer() {
		// TODO Auto-generated method stub
		
		ActionListener timer_listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				process();
				
				gamePan.repaint();
				
			}
		};

		timer = new Timer(10, timer_listener);		
		
	}

	
	protected void process() {
		// TODO Auto-generated method stub
		//공 움직이기(6)
		ball.move();
		//바 움직이기(6)
		bar.move();
		//충돌체크하기
		
	}

	private void init_gamePan() {
		// TODO Auto-generated method stub
		
		gamePan = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
			
				//블럭그리기(8)
				draw_block(g);
				
				//(5)바 그리기
				bar.draw(g);
				
				//(6)
				ball.draw(g);
			
			}
		};

		gamePan.setPreferredSize(new Dimension(MyConstant.BlockGame.GAMEPAN_WIDTH, 
											   MyConstant.BlockGame.GAMEPAN_HEIGH));
		
		this.add(gamePan); 
		
	}

	//(8)
	protected void draw_block(Graphics g) {
		// TODO Auto-generated method stub
		for(int i=0; i<block_array.length;i++){
			
			for(int k =0; k< block_array[i].length;k++){
				
				Block block = block_array[i][k];
				//안깨진 블록이면 보여줘라
				if(block.bShow)
						block.draw(g);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new 벽돌게임();
	}

}