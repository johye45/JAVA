package day1028.graphic.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoAlbum extends JFrame implements ActionListener{
	AlbumPanel p;//페인트 메서드를 재정의 하려면, 클래스로 정의 해야 한다
	
	JPanel p_south;//버튼 두개를 포할할 패널
	JButton bt_prev, bt_next;
	
	public PhotoAlbum() {
		p =new AlbumPanel();
		p.setBackground(Color.YELLOW);
		
		p_south = new JPanel();
		bt_prev = new JButton("이전");
		bt_next = new JButton("다음");
		 
		
		//조립
		add(p);//중앙에 앨범패널 넣기
		p_south.add(bt_prev);
		p_south.add(bt_next);
		add(p_south,BorderLayout.SOUTH);//남쪽에 패널 넣기
		
		//이전 버튼과 리스너 연결
		bt_prev.addActionListener(this);
		//다음 버튼과 리스너 연결
		bt_next.addActionListener(this);
		
		setSize(500,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//이벤트를 일으킨 이벤트 소스 구현하기
		
		if(obj == bt_prev) {
			//이전 버튼이면 n감소
			p.n--;
			
		}else if(obj == bt_next) {
			//다음 버튼이면 n증가
			p.n++;
		}
		
		//화면 갱신 (직접 ALbumPanel의 paint()호출 불가)
		//갱신하도록 요청
		p.repaint();//다시 그리기
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PhotoAlbum();
	}

}
