package day1029.graphic.image;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



//�̹��� ����Ͽ� ����� ĵ����
public class ThumbCanvas extends Canvas implements MouseListener {
	Toolkit kit ;
	Image img;
	DetailPanel p_center;
	
	public ThumbCanvas(DetailPanel p_center, String path) {
		kit = Toolkit.getDefaultToolkit();//static�޼��� ȣ��
		img = kit.getImage(path);//�̹��� ��θ� �Ѱ� ����
		this.setPreferredSize(new Dimension(100,100));
		this.p_center = p_center;
		
		//���콺 �����ʿ� ����
		this.addMouseListener(this);
		
	}
	
	
	//��ȭ���� �׸��� �׸���
	public void Paint(Graphics g) {
		g.drawImage(img,0,0,this);//this�� �̹��� ������
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
	public void mouseReleased(MouseEvent e) {
		//p_center �гο� �̹����� �׸��� �ϵ�, ���� ���� �̹����� ������
		
		p_center.setImg(img);//p_center���� ���� img����
		p_center.repaint();//�ٽ� �׷���
		
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

