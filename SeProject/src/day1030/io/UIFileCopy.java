package day1030.io;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UIFileCopy extends JFrame implements ActionListener{
	JLabel la_ori,la_dest;
	JTextField t_ori, t_dest;
	JButton bt;
	

	public UIFileCopy() {
		//생성
		la_ori = new JLabel("원본 경로");
		la_dest = new JLabel("복사 경로");
		t_ori = new JTextField(50);
		t_dest = new JTextField(50);
		bt = new JButton("복사 실행");
		
		//스타일
		la_ori.setPreferredSize(new Dimension(150,30));
		la_dest.setPreferredSize(new Dimension(150,30));
		t_ori.setPreferredSize(new Dimension(500,30));
		t_ori.setPreferredSize(new Dimension(500,30));
		
		
		//조립
		setLayout(new FlowLayout());//프레임의 레이아웃을 FlowLayout으로 교체
		add(la_ori);
		add(t_ori);
		add(la_dest);
		add(t_dest);
		add(bt);
		
		//연결
		bt.addActionListener(this);
		JFileChooser chooser = new JFileChooser();//파일 찾아줌
		chooser.showOpenDialog(this);
		
		setSize(740,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//스트림을 닫을 기회가 없기 때문에
		//해결책) 윈도우 창을 닫을 때 이벤트를 구현해야 한다
		//즉 WindowListener 구현
		
	}
	public void copy() {
		//두개의 클래스가 메모리에 올라와야 하는 시점은?
		//메서드 내의 지역변수는 반드시 개발자가 초기화 해야 한다..멤버 변수가 아니므로
		FileInputStream fis= null;
		FileOutputStream fos= null;
		String ori = t_ori.getText();//원본 경로
		String dest = t_dest.getText();//복사본 경로
		
		try {
			fis = new FileInputStream(ori);
			fos = new FileOutputStream(dest);
			
			//읽고 출력
			int data;//읽혀진 데이터를 받을 변수
			while(true) {
				data = fis.read();
				if(data == -1)break;
				fos.write(data);
			}
			JOptionPane.showMessageDialog(this, "복사완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis !=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}if(fos !=null) {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		copy();
	}
	public static void main(String[] args) {
		new UIFileCopy();
	}

}
