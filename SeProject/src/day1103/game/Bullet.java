package day1103.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class Bullet extends GameObject{
	GamePanel gamePanel;
	public Bullet(GamePanel gamePanel,Image img,int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);
		this.gamePanel=gamePanel;
	}

	@Override
	//총알에 알맞는 물리량 변화 코드 작성
	public void tick() {
		this.x+=this.velX;
		this.y+=this.velY;//총알이 y축으로 날아갈 경우 구현
		
		rect.y =y;
		rect.x=x;
		
		//화면밖으로 나가면, 화살을 BulletArray에서 제거 해야 그려질 대상이 되지 않음
		//또한 BulletArray의 크기를 줄여놓아야 , 추후 충돌 검사시 반복문의 횟수를 줄일 수 있다
		if(this.x > gamePanel.WIDTH) {
			gamePanel.bulletList.remove(this);//리스트에서 bullet을 지워라~
		}
		
		//총알과 기타 오브젝트와의 충돌검사
		collisionCheck();
		
	}
	public void collisionCheck() {
		//총알인 나와 다수의 적군과 교차여부를 판단하여, 교차했다면 나죽고 너죽고 점수를 10 올리자
		for(int i =0; i<gamePanel.enemyList.size();i++) {
			
			Enemy enemy = gamePanel.enemyList.get(i);
			if(this.rect.intersects(enemy.rect)) {
				//나죽고(List에서 제거하면 더이상 tick(), render()호출이 일어나지 않으므로 화면에서 사라짐
				gamePanel.bulletList.remove(this);
				
				//너죽자
				gamePanel.enemyList.remove(enemy);
				gamePanel.score+=10;
				break;
			}		
		}
		
		//총알인 나와 다수의 블럭간 교차여부
		for(int i=0;i<gamePanel.blockList.size();i++) {
			Block block = gamePanel.blockList.get(i);
			
			if(this.rect.intersects(block.rect)) {
				//나죽고(List에서 제거하면 더이상 tick(), render()호출이 일어나지 않으므로 화면에서 사라짐
				gamePanel.bulletList.remove(this);
				
				//너죽자
				gamePanel.blockList.remove(block);
				
				//점수증가
				gamePanel.score+=10;
				break;
				
			}
		
		}
	}
	
	
	@Override
	//총알에 맞는 그래픽 처리
	public void render(Graphics2D g2) {
		if(img==null) {
			g2.setColor(Color.black);
			g2.fillOval(x, y, width, height);
			
		}else {
			g2.drawRect(rect.x, rect.y, rect.width, rect.height);
			g2.drawImage(img, x, y, null);
		}
	}

	
	
}
