//���ݱ����� sun���ǰ����ڰ� �������� �״�� ������Ʈ���� ���ƿ�����
//�̿��������� �츮�� ������Ʈ�� �׷����� ����� �����Ͽ�,
//���ϴ� �׸����� ������Ʈ�� ���������� ó���غ���(�׷��� ó���� ����)
//�츮 �ֵ��Ͽ� �׷�����

package day1028.graphic;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;

public class PaintTest extends JFrame{
	MyCanvas can ;//��ȭ���� ������ ������Ʈ
	
	public PaintTest() {
		can = new MyCanvas();
		
		//ĵ������ �׸��� �׸�����, ĵ������ ������ �׸��� �޼�����.paint()�޼��� ������
		
		add(can);//ĵ������ �����ӿ� ����
		can.setBackground(Color.CYAN);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//���� Ŭ������ PaintTest�� JFrame�� paint. �޼��带 �������̵��ϸ�
	//����� �ڽ��� ������ �� �޼��带 �켱������ ȣ�����ش�
	//Button, JFrame, Choice���� �� ���� ���� �״�� ������ ��� ��
	//������ ������Ʈ �� �����ڰ� �ֵ��ؼ� �׸��� �׸� �� �ִ� ������Ʈ
	//Canvas(AWT), JPanel(��� �ִ� ������Ʈ)
/*
	public void paint(Graphics g) {
		System.out.println("�� ���� ���� �����θ� �׷���");
	}
*/
	public static void main(String[] args) {
		new PaintTest();
		
	}

}
