package day1028.graphic.album;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

//Canvas�� ������� �ʰ� �г��� �̿��ϸ� ������ ȿ���� �� �� �ִ�
public class AlbumPanel extends JPanel{
	Toolkit kit = Toolkit.getDefaultToolkit();//�÷����� �°� ��������
	
	
	//������ �̹���10���� �迭�� �غ��ϸ� ȿ���� ����
	String dir = "D:/workspace/java/SeProject/res/travel2/";
	String[] src = {
			"aa.jpg",
			"ab.jpg",
			"ax.jpg",
			"bm.jpg",
			"et.jpg",
			"kg.jpg",
			"mx.jpg",
			"pk.jpg",
			"ub.jpg",
			"ya.jpg"
			};
	Image[] img = new Image[src.length];
	int n = 0;//�ν��Ͻ� ���� ���� 
	public AlbumPanel() {
		for(int i = 0; i<img.length; i++) {
			img[i] = kit.getImage(dir + src[i]);
			img[i] = img[i].getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		}
	}
	
	//�츮�� �г��� ������ ���� �ִٴ� ���� �̹� paint�޼��� ȣ�⿡ ���� , �׸��� �ϼ��Ǿ��� ������
	public void paint(Graphics g) {
		g.drawImage(img[n],0,0,this);
		
	}
}
