package day1028.graphic.line;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LineMaker extends JFrame{
	JLabel la_x1,la_y1, la_x2,la_y2;
	JTextField t_x1, t_y1, t_x2,t_y2;
	MyButton bt;//쓸데 없는 짓이지만, 공부 목적으로 해봄
	JPanel p_north;
	XCanvas can;
	
	public LineMaker() {
		super("선 그리기 어플리케이션");
		
		//객체 생성
		la_x1 = new JLabel("x1");
		la_y1 = new JLabel("y1");
		la_x2 = new JLabel("x2");
		la_y2 = new JLabel("y2");
		
		t_x1 = new JTextField("0",10);
		t_y1 = new JTextField("0",10);
		t_x2 = new JTextField("100",10);
		t_y2 = new JTextField("200",10);
		
		bt = new MyButton("커스텀 버튼"); 
		//JButton("커스텀 버튼"); 이렇게 사용되지만 클래스가 따로 존재하므로 해당 클래스로 가서 해줘야함
		
		p_north = new JPanel();
		can = new XCanvas();
		can.setLineMaker(this);//canvas에게 나의 주소값 넘기기
		
		
		//스타일 적용
		can.setBackground(Color.yellow);
		
		//조립
		p_north.add(la_x1);
		p_north.add(t_x1);
		p_north.add(la_y1);
		p_north.add(t_y1);
		p_north.add(la_x2);
		p_north.add(t_x2);
		p_north.add(la_y2);
		p_north.add(t_y2);
		p_north.add(bt);
		
		//부분조립이 완성 되었으면 프레임에 부착
		add(p_north,BorderLayout.NORTH);//프레임의 북쪽에 부착
		add(can);//센터 영역에 캔버스 추가
		
		//버튼과 리스너 연결
		bt.addActionListener(new MyListener(can));
		
		//윈도우와 관련된 속성 지정
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	public static void main(String[] args) {
		new LineMaker();
	}

}
