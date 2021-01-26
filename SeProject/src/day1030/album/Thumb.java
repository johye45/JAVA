package day1030.album;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

//썸네일 하나를 정의한다
public class Thumb extends JPanel implements MouseListener{
	Toolkit kit;//플랫폼에 의존적인 경로
	Image img;
	GalleryApp app;//null
	
	
	private String src;
	public static final int WIDTH=75;
	public static final int HEIGHT=55;
	
	
	public Thumb(String src,GalleryApp app) {
		this.app = app;//injection 주입 받는다고 한다
		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage(src);
		img = img.getScaledInstance(WIDTH,HEIGHT, Image.SCALE_SMOOTH);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setBackground(Color.black);
		
		
		this.addMouseListener(this);//리스너와 연결
	}
	

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("썸네일 눌렀어?");
		//n을 지금 나의index값으로
		//현재 패널이 ArrayList내에서의 몇번째 인덱스에 들어있는지 역추적
		app.n = app.list.indexOf(this);//JPanel을 해야되지만자신이 JPanel이므로 this
		app.updateData();
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
