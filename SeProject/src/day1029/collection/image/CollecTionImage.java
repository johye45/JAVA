package day1029.collection.image;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CollecTionImage extends JFrame implements ActionListener{
	Toolkit kit = Toolkit.getDefaultToolkit();//ÇÃ·§Æû¿¡ ¸Â°Ô Áö¿øÇØÁÜ
	Label la;
	JPanel p_north, p_south, p_west;
	JButton prev, next;
	JPanel p_center;
	int n=0;
	String dir = "D:/workspace/java/SeProject/res/travel2/";
	String[] src = {
			"aa.jpg",
			"ab.jpg",
			"ax.jpg",

			"et.jpg",
			"kg.jpg",
			"mx.jpg",
			"pk.jpg",
			"ub.jpg",
			"ya.jpg"
			};
	Image[] img = new Image[src.length];
	
	public CollecTionImage() {
		p_north = new JPanel();
		p_south = new JPanel();
		p_west = new JPanel();
		p_center = new JPanel();
		la = new Label();
		prev = new JButton("ÀÌÀü");
		next = new JButton("´ÙÀ½");
		p_west.setBackground(Color.RED);
	
		
		
		add(p_north, BorderLayout.NORTH);
		add(p_south, BorderLayout.SOUTH);
		add(p_west, BorderLayout.WEST);
		add(p_center);
		p_north.add(la);
		
		p_south.add(prev);
		p_south.add(next);
		
		for(int i = 0; i<img.length; i++) {
			img[i] = kit.getImage(dir + src[i]);
			img[i] = img[i].getScaledInstance(500, 400, Image.SCALE_SMOOTH);
		}
		prev.addActionListener(this);
		next.addActionListener(this);
		
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == next) {
			n++;
		}else if(obj == e.getSource()) {
			n--;
		}
		p_center.repaint();

	}
	public void paint(Graphics g) {
		g.drawImage(img[n],0,0,this);
		
	}
	public static void main(String[] args) {
		new CollecTionImage();
	}

}
