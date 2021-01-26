package day1030.io;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//GUI 즉 보여지는 객체들은 거의 일반 클래스
public class MemoApp2 extends JFrame implements ActionListener{
	JMenuBar bar ;//메뉴를 올려놓을 막대
	JMenu m_file,m_edit,m_style,m_view,m_help;
	//객체 자료형도 자료형 이므로 배열이 가능
	JMenuItem[] items;//m_file에 하위 메뉴로 총 8개 아이템 추가
	String[] item_title = {"새로만들기","새 창","열기","저장 ","다른이름으로 저장","페이지 설정","인쇄","끝내기"};
	JTextArea area;
	JScrollPane scroll;//area에 붙여질 스크롤
		
	public MemoApp2() {
		bar = new JMenuBar();//바 생성
		
		
		//메뉴들 생성
		m_file = new JMenu("파일");
		m_edit = new JMenu("편집");
		m_style = new JMenu("서식");
		m_view = new JMenu("보기");
		m_help = new JMenu("도움말");
	
		//아이템 생성
		//아이템에 생성된 것이 아닌 아이템이 들어갈 자리 확보
		//js와는 달리, 자바에서는 배열의 자료형이 결정되면, 해당 자료형만 넣을 수 있다
		items = new JMenuItem[item_title.length];
		for(int i= 0; i<items.length;i++) {
			items[i]= new JMenuItem(item_title[i]);//아이템 생성
			if(i==2) {
				items[i].addActionListener(this);
			}
			
			//5번째 도달하면 구분선 추가
			if(i==5 || i==7){
				m_file.addSeparator();//구분선 긋기
			}
			
			
			//파일 메뉴에 아이템 부착
			m_file.add(items[i]);
		}

	
		
		
		
		area = new JTextArea();
		scroll = new JScrollPane(area);//스크롤 담고 싶은 컴포넌트를 생성자 매개변수로 넣는다
		
		//바에 메뉴 부착
		bar.add(m_file);
		bar.add(m_edit);
		bar.add(m_style);
		bar.add(m_view);
		bar.add(m_help);
	
		//바는 워낙 특수성이 있기 때문에 배치관리자와 상관 없이 언제나 윈도우의 상단 영역에 붙여짐
		this.setJMenuBar(bar);
		
		//프레임에 scroll 부착(얼핏 보기엔 area를 부착해야 할 것처럼 보이지만, scroll이 area를 포함하고 있으므로
		//scroll 붙여야 한다
		add(scroll);
		
		//bar 스타일 적용
		bar.setBackground(Color.ORANGE);
		m_file.setForeground(Color.white);
		m_edit.setForeground(Color.white);
		m_style.setForeground(Color.white);
		m_view.setForeground(Color.white);
		m_help.setForeground(Color.white);
		
		//메뉴의 크기 조정
		m_file.setPreferredSize(new Dimension(120,45));
		m_edit.setPreferredSize(new Dimension(120,45));
		m_style.setPreferredSize(new Dimension(120,45));
		m_view.setPreferredSize(new Dimension(120,45));
		m_help.setPreferredSize(new Dimension(120,45));
		
		//스타일 적용
		area.setBackground(Color.PINK);//area배경색 지정
		area.setFont(new Font("돋움",Font.BOLD|Font.ITALIC,20));
		area.setForeground(Color.gray);
		
		setSize(700,600);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	}
	public void file() {
		JFileChooser chooser = new JFileChooser();//파일 찾아줌
		chooser.showOpenDialog(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		file();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MemoApp2();
	}

}
