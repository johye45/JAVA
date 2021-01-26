package com.swingmall.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.swingmall.admin.board.Board;
import com.swingmall.admin.member.Member;
import com.swingmall.admin.order.Order;
import com.swingmall.admin.product.Product;
import com.swingmall.util.db.DBManager;

public class AdminMain extends JFrame{
	//상수 선언
	public static final int WIDTH=1200;
	public static final int HEIGHT=800;
	public static final int HOME=0;
	public static final int PRODUCT=1;//상품관리
	public static final int MEMBER=2;//회원정보
	public static final int ORDER=3;//주문관리
	public static final int BOARD=4;//게시판 관리
	
	JPanel p_navi;//Home, Product등이 올 메뉴를 포함 할 컨테이너 패널
	String[] navi_title = {"Home","상품관리","회원정보","주문관리","게시판관리"};
	JButton[] navi = new JButton[navi_title.length];//[][][][][]배열 생성

	//페이지 구성
	Page[] page = new Page[5];
	
	
	JPanel user_container;//관리자, 사용자 화면을 구분지을 수 있는 컨테이너
	JPanel p_content;//여기에 모든 페이지가 미리 붙어져 있을 것
					//추후 showPage메서드로 보일지 여부 설정
	JLabel la_footer;//윈도우 하단의 카피라이트 영역
	private DBManager dbManager;//오라클 접속 보유하기


	private Connection con;
	
	
	
	public AdminMain() {
		dbManager = new DBManager();
		user_container = new JPanel();
		p_content = new JPanel();
		la_footer=new JLabel("SwingMall All rihts reserved",SwingConstants.CENTER);//라벨 가운데 정렬

		p_navi = new JPanel();
		
		
		
		con = dbManager.connect();//접속
		if(con==null) {
			JOptionPane.showMessageDialog(this, "접속 실패");
			System.exit(0);
		}else {
			this.setTitle("Swingmall관리자로 이용중입니다");
		}
		
		//메인 네비게이션 생성
		for(int i = 0; i<navi.length;i++) {
			navi[i] = new JButton(navi_title[i]);
			navi[i].setBackground(Color.black);
			navi[i].setForeground(Color.white);
			p_navi.add(navi[i]);
		}
		
		//페이지 구성
		page[0] = new Home(this);
		page[1] = new Product(this);
		page[2] = new Member(this);
		page[3] = new Order(this);
		page[4] = new Board(this);
		
		//스타일 적용
		user_container.setPreferredSize(new Dimension(WIDTH,HEIGHT-50));
		user_container.setBackground(Color.white); 
		la_footer.setPreferredSize(new Dimension(WIDTH,50));
//		la_footer.setBackground(Color.white); 
		la_footer.setFont(new Font("Arial Black",Font.BOLD,22));
		
		//조립
		user_container.setLayout(new BorderLayout());
		user_container.add(p_navi,BorderLayout.NORTH);//메뉴 북쪽에 부착
		
		user_container.add(p_content);
		for(int i = 0 ; i<page.length;i++) {//모든 페이지 부착
			p_content.add(page[i]);
		}
		//처음에 나와야 하는 페이지 설정
		showPage(AdminMain.HOME);//Home페이지
		
		this.add(user_container);
		this.add(la_footer,BorderLayout.SOUTH);
		
		
		setSize(1200,800);
		setVisible(true);
		setLocationRelativeTo(null);

		//프레임과 리스너 연결
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dbManager.disConnect(con);
				System.exit(0);
			}
		});
		
		//네비게이션 버튼과 리스너 연결
		for(int i = 0; i<navi.length;i++) {
			navi[i].addActionListener((e)->{
				Object obj = e.getSource();
				if(obj == navi[0]) {
					showPage(0);
				}else if(obj == navi[1]) {
					showPage(1);
				}else if(obj == navi[2]) {
					showPage(2);
				}else if(obj == navi[3]) {
					showPage(3);
				}else if(obj == navi[4]) {
					showPage(4);
				}
			
			});
		}
		
	}
	
	//봉질 페이지와 안보여질 페이지를 설정하는 메서드
	public void showPage(int showIndex) {//매개변수로 보여주고 싶은 페이지 넘버
		for(int i= 0; i<page.length;i++) {//모든 페이지를 대상으로
			if(i==showIndex) {
				page[i].setVisible(true);
			}else {
				page[i].setVisible(false);			
			}			
		}
	}
	
	
	
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public DBManager getDbManager() {
		return dbManager;
	}

	public void setDbManager(DBManager dbManager) {
		this.dbManager = dbManager;
	}
	public static void main(String[] args) {
		new AdminMain();
	}

}
