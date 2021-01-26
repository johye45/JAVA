package day1029.graphic.image;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

//�� �̹����� �׷��� �г�
//Ŭ������ ������ �����ϴ� ����
//paint�޼��带 ������ �ϱ� ����
public class DetailPanel extends JPanel{
	private Image img;
	
	//�� �޼��带 ȣ���ϴ� �ڴ� � �̹����� ������ �� �Ű������� �ѱ�� ��
	public void setImg(Image img){
		this.img = img;
		this.img = this.img.getScaledInstance(770,500,Image.SCALE_SMOOTH);
	}
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
}
