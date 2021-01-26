//���ΰ��� �����Ѵ�

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
	
	//������ ��ȭ
	public void tick() {
		this.x+=this.velX;
		this.y+=this.velY;
		
		rect.x =x;
		rect.y =y;
		
		if(gamePanel.hpList.size()>=1) {
			collisionCheck();			
		}else {
			System.out.println("��������");
			gamePanel.over = true;
			gamePanel.flag = false;
		}
	}
	
	public void collisionCheck() {
		//������ ���� �浹���θ� �Ǵ��ϰ�, ���� �浹�ϸ� ����hp�װ� ���װ� 
		for(int i=0;i<gamePanel.enemyList.size();i++) {
			Enemy enemy = gamePanel.enemyList.get(i);
			if(this.rect.intersects(enemy.rect)) {
				gamePanel.hpList.remove(gamePanel.hpList.size()-1);
				gamePanel.enemyList.remove(enemy);//���� ����
				
			}
		}
	}
	
	//�׷��� ó��(ȭ�鿡 �׷��� ó��)
	//��� ���� ĳ���ʹ� �гο� �׷����� �ϹǷ�, g2�� �г��� paint()�޼���
	//�� ���������� �޾ƿ���
	public void render(Graphics2D g2) {

		//�гο� �׷��� �Ѵ�
//		g2.setColor(Color.red);
//		g2.fillRect(rect.x, rect.y, rect.width, rect.height);	
				
		//�츮�� �̹� �����ϰ� �ִ� �簢���� �ð�ȭ ���Ѻ���
		g2.drawImage(img, x, y, null);
	
	
	}
	
}
