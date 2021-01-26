//주인공을 정의한다

package day1103.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class Hero extends GameObject{
		GamePanel gamePanel;
	public Hero(GamePanel gamePanel, Image img,int x, int y, int width, int height, int velX, int velY) {
		super(img,x,y,width,height,velX,velY);
		this.gamePanel = gamePanel;
	}
	
	//물리량 변화
	public void tick() {
		this.x+=this.velX;
		this.y+=this.velY;
		
		rect.x =x;
		rect.y =y;
		
		if(gamePanel.hpList.size()>=1) {
			collisionCheck();			
		}else {
			System.out.println("게임종료");
			gamePanel.over = true;
			gamePanel.flag = false;
		}
	}
	
	public void collisionCheck() {
		//적군과 나의 충돌여부를 판단하고, 만일 충돌하면 나의hp죽고 너죽고 
		for(int i=0;i<gamePanel.enemyList.size();i++) {
			Enemy enemy = gamePanel.enemyList.get(i);
			if(this.rect.intersects(enemy.rect)) {
				gamePanel.hpList.remove(gamePanel.hpList.size()-1);
				gamePanel.enemyList.remove(enemy);//적군 죽임
				
			}
		}
	}
	
	//그래픽 처리(화면에 그려질 처리)
	//모든 게임 캐릭터는 패널에 그려져야 하므로, g2를 패널의 paint()메서드
	//의 지역변수를 받아오자
	public void render(Graphics2D g2) {

		//패널에 그려야 한다
//		g2.setColor(Color.red);
//		g2.fillRect(rect.x, rect.y, rect.width, rect.height);	
				
		//우리가 이미 보유하고 있는 사각형을 시각화 시켜보자
		g2.drawImage(img, x, y, null);
	
	
	}
	
}
