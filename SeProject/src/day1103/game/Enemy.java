package day1103.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Enemy extends GameObject{

	public Enemy(Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);
		// TODO Auto-generated constructor stub
	}
	public void tick() {
		this.x+=this.velX;
		//����� ��ǥ�� ��� �簢���� �ݿ��Ǿ��, �Ѿ˰� ������ �浹�˻簡 �� �� �ִ�.
		this.rect.x=x;
		this.rect.y=y;
		
		
	}
	public void render(Graphics2D g2) {
		g2.drawRect(rect.x, rect.y, rect.width, rect.height);
		g2.drawImage(img, x, y,null);//���� �������� ���� �̹���
		
	}
}
