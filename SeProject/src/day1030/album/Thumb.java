package day1030.album;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

//����� �ϳ��� �����Ѵ�
public class Thumb extends JPanel implements MouseListener{
	Toolkit kit;//�÷����� �������� ���
	Image img;
	GalleryApp app;//null
	
	
	private String src;
	public static final int WIDTH=75;
	public static final int HEIGHT=55;
	
	
	public Thumb(String src,GalleryApp app) {
		this.app = app;//injection ���� �޴´ٰ� �Ѵ�
		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage(src);
		img = img.getScaledInstance(WIDTH,HEIGHT, Image.SCALE_SMOOTH);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setBackground(Color.black);
		
		
		this.addMouseListener(this);//�����ʿ� ����
	}
	

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("����� ������?");
		//n�� ���� ����index������
		//���� �г��� ArrayList�������� ���° �ε����� ����ִ��� ������
		app.n = app.list.indexOf(this);//JPanel�� �ؾߵ������ڽ��� JPanel�̹Ƿ� this
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
