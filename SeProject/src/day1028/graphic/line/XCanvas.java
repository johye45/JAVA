package day1028.graphic.line;

import java.awt.Canvas;
import java.awt.Graphics;

public class XCanvas extends Canvas{
	//default ���������ڴ� ���� ��Ű���� �ִ� Ŭ������ ���� ����
	LineMaker lineMaker;
	int x1, y1, x2, y2;//MyListener�� �� �� �ְ�
	//�� �޼��带 ȣ���ϴ� �ڴ�, LineMaker�� �ּҰ��� �ѱ�� �ȴ�
	public void setLineMaker(LineMaker lineMaker) {
		this.lineMaker = lineMaker;
	}
	
	//ĵ������ �����ڰ� ���� �׸� �� �ִ� �� ��ȭ�� �̴�
	//���� print() �޼��带 ������ �ϸ� �ȴ�
	public void paint(Graphics g) {
		x1 = Integer.parseInt(lineMaker.t_x1.getText());//js�� parseInt
		y1 = Integer.parseInt(lineMaker.t_y1.getText());
		x2 = Integer.parseInt(lineMaker.t_x2.getText());
		y2 = Integer.parseInt(lineMaker.t_y2.getText());
		
		g.drawLine(x1, y1, x2, y2);//�� ���� ������ �� �׸���
	
	}
	
	
}
