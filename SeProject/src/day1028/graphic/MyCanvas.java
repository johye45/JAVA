package day1028.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MyCanvas extends Canvas {
	Toolkit kit;//�÷����� ���� �˸°� �ڿ��� ������ �� �ֵ��� ���ִ� ��ü
	Image img;//�߻���, ��Ŷ�� �̿��� ������
	
	public MyCanvas() {
		kit = Toolkit.getDefaultToolkit();//��ü Ŭ���� �޼���(static)�� ���� �ν��Ͻ� ��� ���
		//img = kit.getImage("..\workspace\java\SeProject\res\travel2\aa.jpg");//������ os
	}
	
	//�θ��� Canvas�� ������ paint�޼��� �����ع�����, �츮 ��Ȳ�� �°�
	//������ ���� override
	@Override
	public void paint(Graphics g) {
		//g�� �Ű������� Graphics��ü�� ���ǿ����� �ȷ�Ʈ�� ������ �� ������,
		//���� ���� �����ϴ� ���� �ƴ϶�
		//����, �ؽ�Ʈ, �̹��� , �� , �� �� �پ��� �׷��� ó���� ���� ����� �����ϴ�
		//������ �׷��� ó�� ����� �̴�
		g.drawLine(50,50,300,300);//ĵ������ �� �׸���
		g.drawOval(0,50, 200, 200);
		g.drawRect(50,100,100,200);
		
		//���� ����
		g.setColor(Color.GRAY);
		g.fillRect(200, 100, 50, 50);//ä���� �簢��

		g.setColor(Color.BLUE);
		g.drawString("�̰� �׸� �۾���", 50, 200);
		
		//image: �̹����� ǥ���� ��ü
		//image�� �߻� Ŭ���� 
		//�߻� Ŭ���� �� ��� �����ڰ� �ڽ� Ŭ������ ���� �� , �ڽ��� new�ؼ� ��� �ؾ� ���� ��Ģ������
		//sun�簡 ���� ���ִ� ��κ��� �߻�Ŭ������ ���, �̹� �ν��Ͻ��� ������ ���� ���������� ����
		//��� �޼��带 �������ְų�, �ν��Ͻ��� ������ �ִ� ��ü �޼��带 �������ִ� ��찡 �� ����
		//�ý��ۿ� �ϵ��ũ ��θ� �̿��Ͽ� �̹����� ������ ��쿣, �÷����� ���� �̹��� ��ü��
		//������ �� �ִ� Toolkit��ü�� �̿��ؾ� �ϹǷ�, �̹����� ������� �켱 ��Ŷ ��ü�� �ν��Ͻ�
		//���� ����
		g.drawImage(img, 20, 20, this);
	}

}
