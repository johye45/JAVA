package day1030.album;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class GalleryApp extends JFrame implements ActionListener{
	JPanel p_west;
	JPanel p_center;
	JScrollPane scroll;
	JLabel la_name;//제목 나올 라벨
	XCanvas can;//센터에 크게 나올 이미지를 그릴 캔버스
	JPanel p_south;//버튼 두개 올 곳 
	JButton bt_prev, bt_next;
	
	
	ArrayList<Thumb> list=new ArrayList<Thumb>();//썸네일 배열 선언
	String dir="D:/workspace/java/SeProject/res/travel2/";
	String[] src= {
			"aa.jpg","ab.jpg","ax.jpg","bm.jpg","et.jpg","kg.jpg","mx.jpg","pk.jpg","ub.jpg","ya.jpg"
	};
	int n =0;
	
	public GalleryApp() {
		
		super("자바 겔러리");
		//생성 
		p_west = new JPanel();
		p_center = new JPanel();
		scroll = new JScrollPane(p_west);
		la_name = new JLabel(src[n],SwingConstants.CENTER);//적힐 글자와,라벨을 가운데로
		can = new XCanvas(dir+src[n]);
		p_south = new JPanel();
		bt_prev = new JButton("이전");
		bt_next = new JButton("다음");
		
		//썸네일생성
		for(int i=0;i<src.length;i++) {
			Thumb thumb=null;
			list.add(thumb=new Thumb(dir+src[i],this));
			p_west.add(thumb);
		}
		
		//스타일 
		la_name.setPreferredSize(new Dimension(700,50));
		la_name.setFont(new Font("Verdana",Font.BOLD ,25));
		
		p_west.setPreferredSize(new Dimension(100,600));
		p_center.setPreferredSize(new Dimension(700,600));
//		p_west.setBackground(Color.YELLOW);
//		p_center.setBackground(Color.GREEN);
		
		//조립 
		add(scroll, BorderLayout.WEST);
		add(p_center);
		p_south.add(bt_prev);
		p_south.add(bt_next);
		p_center.add(la_name);
		p_center.add(can);
		p_center.add(p_south);
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		//윈도우를 화면 중앙에 띄우는 법
		setVisible(true);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		updateData();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//이벤트 일으킨 컴포넌트
		if(obj == bt_prev) {
			prev();
		}else if(obj==bt_next) {
			next();
		}
		updateData();//코드 중복을 최소화 하기 위해 prev와 next의 공통 부분을 따로 뺀다
	}
	
	public void updateData() {
		can.setSrc(dir+src[n]);
		can.repaint();
		la_name.setText(src[n]+"("+(n+1)+"/"+src.length+")");//제목변경
		
	}
	public void prev() {
		if(n>0) {
			n--;			
		}else {
			//아니면 경고창 띄우기
		JOptionPane.showMessageDialog(this,"처음 이미지 입니다.");
		}
		
	}
	public void next() {
		//그림은 XCanvas가 담당하므로, 그려질 img를 변경시켜 주고, 다시 그리라고 하면됨
		
		//배열을 넘어지는 않는 범위 내에서 ++
		if(n<src.length-1) {
			n++;			
		}else {
			//아니면 경고창 띄우기
			JOptionPane.showMessageDialog(this,"마지막 이미지 입니다.");
		}
	}
	
	public static void main(String[] args) {
		new GalleryApp();
	}



}
