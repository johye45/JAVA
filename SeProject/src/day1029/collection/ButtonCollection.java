package day1029.collection;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCollection extends JFrame implements ActionListener{
	JPanel p_north, p_center;
	JButton bt_create, bt_bg;
	
	
	//배열은 크기를 정해야 하기 때문에, 크기를 알 수 없는 프로그램에선 사용에 제한이 있다
//	JButton[] btn = new JButton[];//배열의 가장 큰 특징 , 배열은 생성시 반드시 크기 명시
	
	ArrayList<JButton> btn = new ArrayList<JButton>();
	
	public ButtonCollection() {
		p_north = new JPanel();
		p_center = new JPanel();
		bt_create = new JButton("버튼생성");
		bt_bg = new JButton("배경색");
				
		p_north.add(bt_create);
		p_north.add(bt_bg);
		
		//프레임에 부착
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
		//버튼과 리스너 연결
		bt_create.addActionListener(this);
		bt_bg.addActionListener(this);
	
		
				
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//이벤트를 일으킨 컴포넌트 반환 -> 버튼 구분하기 위해
		if(obj == bt_create) {
			create();
		}else if(obj.equals(bt_bg)) {
			setBg();
		}
	}
	
	public void create() {
		//버튼 생성하여 p_center에 부착

		JButton bt = new CustonButton();
		p_center.add(bt);
		
		//리스트에 추가하기 js의 push()
		btn.add(bt);
		System.out.println("현재까지 누적된 리스트의 수는"+btn.size());
		bt.setText("버튼"+Integer.toString(btn.size()));// 버튼에 적힐 수를 적용하기
		
		
		//p_center에 버튼을 그린게 아니라, 버튼을 추가한 것이다
		//따라서 이때는 p_center를 갱신하면 된다 updateUI()이다
		p_center.updateUI();
		
	}
	public void setBg() {
		
		//btn이라는 리스트에 들어있는 모든 요소를 대상으로 배경색 바꾸기
		//ArrayList는 순서있는 집합 이므로 for문 사용 가능
		for(int i=0; i<btn.size();i++) {
			JButton bt = btn.get(i);
			bt.setBackground(Color.yellow);		
		}
	
	}
	

	public static void main(String[] args) {
		new ButtonCollection();
	}


}
