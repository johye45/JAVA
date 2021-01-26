package day1028.graphic.color;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorPickerApp extends JFrame{
	ThumbPanel[] thumb = new ThumbPanel[7];
	Color[] colorArray = {
			Color.red,Color.orange,Color.yellow,
			Color.green,Color.blue,Color.cyan,Color.pink
	};//7���� ������ �迭�� ��������
	JPanel p_north;//���� �� ��
	JPanel p_center;
	
	public ColorPickerApp() {//������
		p_north = new JPanel();
		p_center = new JPanel();
		for(int i = 0; i<thumb.length;i++) {
			thumb[i]= new ThumbPanel(p_center,colorArray[i]);
			p_north.add(thumb[i]);
		}
		p_center.setBackground(Color.white);
		
		
		add(p_north, BorderLayout.NORTH);//p_north�� �������� ���ʿ�
		add(p_center);//�����ӿ� ����
		
		
		setSize(770,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ColorPickerApp();
	}

}