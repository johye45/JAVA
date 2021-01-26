package day1027.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class KakaoTalk extends JFrame {
	JTextArea area = new JTextArea();
	JTextArea p1 = new JTextArea();
	JTextArea p2 = new JTextArea();
	JPanel p_south = new JPanel();
	
	public KakaoTalk() {
		this.setLayout(new BorderLayout());
		this.add(area,BorderLayout.CENTER);
		area.setBackground(Color.YELLOW);
		
		p_south = new JPanel();
		p_south.setBackground(Color.red);
		p_south.setLayout(new GridLayout(1,1));
		p_south.add(p1);
		p_south.add(p2);
		p1.setBackground(Color.BLUE);
		p2.setBackground(Color.black);
		
		
		
		this.add(p_south,BorderLayout.SOUTH);
		
		setSize(300,400);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KakaoTalk();
	}

}
