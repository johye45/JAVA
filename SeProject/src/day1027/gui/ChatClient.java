package day1027.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements KeyListener{
					//   is	a           is a	
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt;
	JPanel p_south;
	public ChatClient() {
		// TODO Auto-generated constructor stub
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(15);
		bt = new JButton("전송");
		p_south = new JPanel();
		
		//패널조립 디폴트가 FlowLayout이기때문
		p_south.add(t_input);
		p_south.add(bt);

		add(scroll);//센터에 스크롤 부착
		add(p_south,BorderLayout.SOUTH);//남쪽에 패널 부착
		
		
		//스타일 적용
		area.setBackground(Color.YELLOW);
		t_input.setBackground(Color.green);
		t_input.setForeground(Color.black);
		bt.setBackground(Color.BLACK);
		bt.setForeground(Color.WHITE);
		
		t_input.setPreferredSize(new Dimension(285,30));//텍스트 박스 크기
		
			
		//보여주기 직전에 미리 연결(컴포넌트와 리스너 연결)
		bt.addActionListener(new MyActionListener(t_input,area));
		
		t_input.addKeyListener(this);//프레임이 리스너임
		
		setSize(300,400);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}
	
	//어노테이션이다. java5부터 지원되는 일종의 주석
	//일반적인 주석은 프로그램에 사용되지 않지만, 
	//어노테이션은 프로그래밍에서 어떤 표시를 하기 위해 사용됨
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//엔터키를 누르면 area에 입력 데이터를 반영하자(누적 시키자)
		int key = e.getKeyCode(); //키 코드값 반환
		if(key == 10) {
			String msg = t_input.getText();//텍스트 필드 값을 구하자
			area.append(msg+"\n");//내용 추가
			t_input.setText("");//초기화 빈텍스트로
		}
		
	}
	
	
	public static void main(String[] args) {
		new ChatClient();

	}




}
