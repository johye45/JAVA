package day1030.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements KeyListener,ActionListener{
					//   is	a           is a	

	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt;
	JButton bt_open;//대화 상대방을 띄우는 버튼
	JPanel p_south;
	private ChatB chatB;//보유
	private ChatC chatC;
	
	public ChatA() {
		//나보다 부모가 먼저 태어나야 함super(), JFrame();
		super("대화창A");
		
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(10);
		bt = new JButton("send");
		bt_open = new JButton("open");
		p_south = new JPanel();
		
		//패널조립 디폴트가 FlowLayout이기때문
		p_south.add(t_input);
		p_south.add(bt);
		p_south.add(bt_open);

		add(scroll);//센터에 스크롤 부착
		add(p_south,BorderLayout.SOUTH);//남쪽에 패널 부착
		
		
		//스타일 적용
		area.setBackground(Color.YELLOW);
		t_input.setBackground(Color.green);
		t_input.setForeground(Color.black);
		bt.setBackground(Color.BLACK);
		bt.setForeground(Color.WHITE);
		
		t_input.setPreferredSize(new Dimension(255,30));//텍스트 박스 크기
		
			
		//보여주기 직전에 미리 연결(컴포넌트와 리스너 연결)
		t_input.addKeyListener(this);//프레임이 리스너임
		
		//send버튼에 리스너 연결
		bt.addActionListener(this);
		
		//open버튼에 리스너 연결
		bt_open.addActionListener(this);
		
		setBounds(200, 150, 300, 400);//수평하게 창을 띄우기 위해
//		setSize(300,400);
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
			send();
		}
		
	}
	
	//send open버튼 눌렀을때 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton btn = (JButton)obj;//하위 자룧ㅇ으로 변환
		if(btn == bt) {
			System.out.println("send 버튼 눌렀어?");	
			send();
		}else if(btn.equals(bt_open)) {//누른 버튼과 열기 버튼이 같은 버튼이라면
			System.out.println("open 버튼 눌렀어?");			
			open();
		}
		
		
	}
	//메세지 창에 대화내용 누적하기
	public void send() {
		//나에 대한 채팅 처리
		String msg = t_input.getText();//텍스트 필드 값을 구하자
		area.append(msg+"\n");//내용 추가
		t_input.setText("");//초기화 빈텍스트로
		
		//상대방에 대한 채팅 처리
		chatB.area.append(msg+"\n");//내용 추가
		chatC.area.append(msg+"\n");//내용 추가
//		chatB.t_input.setText("");//초기화 빈텍스트로
		
	
	}
	//대화할 상대방 윈도우 띄우기
	public void open() {
		//ChatB,ChatC 태어나게 
		chatB = new ChatB();
		chatC = new ChatC();
	
//		ChatB한테 ChatA와 ChatC를 넘겨주고
		chatB.setChatA(this);
		chatB.setChatC(chatC);
//		ChatC한테 ChatA와 ChatB를 넘겨주고
		chatC.setChatA(this);
		chatC.setChatB(chatB);
	}
		
	public static void main(String[] args) {
		new ChatA();

	}





}
