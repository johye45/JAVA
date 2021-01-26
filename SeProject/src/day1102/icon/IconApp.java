package day1102.icon;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class IconApp extends JFrame{
	JButton bt;
	ImageIcon icon;	
	
	public IconApp() {
		//os�� �������� ��θ� ������� ����, Ŭ�����н��� �������� �� ��η� �ڿ��� �̿��غ���
		
//		icon = new ImageIcon("D:/workspace/java/SeProject/bin/res/line.png");
		URL url = this.getClass().getClassLoader().getResource("res/line.png");
		icon = new ImageIcon(url);
		bt = new JButton(icon);
		//ImageŬ������ �̹��� ũ�⸦ ������ �� �ִ� ����� �ִ�. getScaledInstance
		Image img = icon.getImage();
		img = img.getScaledInstance(100, 45, Image.SCALE_SMOOTH);
		icon.setImage(img);//�����ܿ� ����� �̹����� �ٽ� ����
		bt.setPreferredSize(new Dimension(100,45));
		
		setLayout(new FlowLayout());
		add(bt);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new IconApp();

	}

}
