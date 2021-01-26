package day1029.graphic.image;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



//이미지 썸네일에 사용할 캔버스
public class ThumbCanvas extends Canvas implements MouseListener {
	Toolkit kit ;
	Image img;
	DetailPanel p_center;
	
	public ThumbCanvas(DetailPanel p_center, String path) {
		kit = Toolkit.getDefaultToolkit();//static메서드 호출
		img = kit.getImage(path);//이미지 경로를 넘겨 받지
		this.setPreferredSize(new Dimension(100,100));
		this.p_center = p_center;
		
		//마우스 리스너와 연결
		this.addMouseListener(this);
		
	}
	
	
	//도화지에 그림을 그리자
	public void Paint(Graphics g) {
		g.drawImage(img,0,0,this);//this는 이미지 감시자
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
		//p_center 패널에 이미지를 그리게 하되, 현재 나의 이미지를 가지고
		
		p_center.setImg(img);//p_center에게 나의 img전달
		p_center.repaint();//다시 그려라
		
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

