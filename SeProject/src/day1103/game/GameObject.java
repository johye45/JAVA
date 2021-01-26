//���ӿ� �����ϴ� ��� ��Ҵ� �� ��ü�� �ڽ��̴�
//���� gameObjectŬ������ �������� Ư¡�� �����ؾ� �Ѵ�


package day1103.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameObject {
	Image img;
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	
	//�浹�˻縦 ���ؼ��� �簢�� ��ü�� �����ؾ� �Ѵ�
	Rectangle rect;
	
	public GameObject(Image img, int x, int y, int width, int height, int velX, int velY) {
		this.img =img;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.velX=velX;
		this.velY=velY;
		rect = new Rectangle(x, y, width, height);//������ ������ �ִ� ��ǥ, �ʺ�, ���� ������ �̿��Ͽ�
		//�簢���� ��������
	}
	public abstract void tick();//���� ��ü�� � �������� �������� ��ȭ ��ų�� 
	//�θ��� ���� ���� ������ �� �� �� ���� �˾Ƽ��� �ȵ�
	//�̿ϼ����� ���ܳ�����, �̷� ��������� �ڽ���, �� �޼��带 �ڽ���
	//��Ȳ�� �°� �������� ���� �� ���̴�.(�������̵�)
	public abstract void render(Graphics2D g2) ;


}
