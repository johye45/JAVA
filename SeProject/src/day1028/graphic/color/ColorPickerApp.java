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
	};//7가지 색상을 배열로 보유하자
	JPanel p_north;//색이 올 곳
	JPanel p_center;
	
	public ColorPickerApp() {//생성자
		p_north = new JPanel();
		p_center = new JPanel();
		for(int i = 0; i<thumb.length;i++) {
			thumb[i]= new ThumbPanel(p_center,colorArray[i]);
			p_north.add(thumb[i]);
		}
		p_center.setBackground(Color.white);
		
		
		add(p_north, BorderLayout.NORTH);//p_north를 프레임의 북쪽에
		add(p_center);//프레임에 부착
		
		
		setSize(770,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ColorPickerApp();
	}

}