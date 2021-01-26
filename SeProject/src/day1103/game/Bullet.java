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
	//�Ѿ˿� �˸´� ������ ��ȭ �ڵ� �ۼ�
	public void tick() {
		this.x+=this.velX;
		this.y+=this.velY;//�Ѿ��� y������ ���ư� ��� ����
		
		rect.y =y;
		rect.x=x;
		
		//ȭ������� ������, ȭ���� BulletArray���� ���� �ؾ� �׷��� ����� ���� ����
		//���� BulletArray�� ũ�⸦ �ٿ����ƾ� , ���� �浹 �˻�� �ݺ����� Ƚ���� ���� �� �ִ�
		if(this.x > gamePanel.WIDTH) {
			gamePanel.bulletList.remove(this);//����Ʈ���� bullet�� ������~
		}
		
		//�Ѿ˰� ��Ÿ ������Ʈ���� �浹�˻�
		collisionCheck();
		
	}
	public void collisionCheck() {
		//�Ѿ��� ���� �ټ��� ������ �������θ� �Ǵ��Ͽ�, �����ߴٸ� ���װ� ���װ� ������ 10 �ø���
		for(int i =0; i<gamePanel.enemyList.size();i++) {
			
			Enemy enemy = gamePanel.enemyList.get(i);
			if(this.rect.intersects(enemy.rect)) {
				//���װ�(List���� �����ϸ� ���̻� tick(), render()ȣ���� �Ͼ�� �����Ƿ� ȭ�鿡�� �����
				gamePanel.bulletList.remove(this);
				
				//������
				gamePanel.enemyList.remove(enemy);
				gamePanel.score+=10;
				break;
			}		
		}
		
		//�Ѿ��� ���� �ټ��� ���� ��������
		for(int i=0;i<gamePanel.blockList.size();i++) {
			Block block = gamePanel.blockList.get(i);
			
			if(this.rect.intersects(block.rect)) {
				//���װ�(List���� �����ϸ� ���̻� tick(), render()ȣ���� �Ͼ�� �����Ƿ� ȭ�鿡�� �����
				gamePanel.bulletList.remove(this);
				
				//������
				gamePanel.blockList.remove(block);
				
				//��������
				gamePanel.score+=10;
				break;
				
			}
		
		}
	}
	
	
	@Override
	//�Ѿ˿� �´� �׷��� ó��
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
