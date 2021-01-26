package day1030.album;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class GalleryApp extends JFrame implements ActionListener{
	JPanel p_west;
	JPanel p_center;
	JScrollPane scroll;
	JLabel la_name;//���� ���� ��
	XCanvas can;//���Ϳ� ũ�� ���� �̹����� �׸� ĵ����
	JPanel p_south;//��ư �ΰ� �� �� 
	JButton bt_prev, bt_next;
	
	
	ArrayList<Thumb> list=new ArrayList<Thumb>();//����� �迭 ����
	String dir="D:/workspace/java/SeProject/res/travel2/";
	String[] src= {
			"aa.jpg","ab.jpg","ax.jpg","bm.jpg","et.jpg","kg.jpg","mx.jpg","pk.jpg","ub.jpg","ya.jpg"
	};
	int n =0;
	
	public GalleryApp() {
		
		super("�ڹ� �ַ���");
		//���� 
		p_west = new JPanel();
		p_center = new JPanel();
		scroll = new JScrollPane(p_west);
		la_name = new JLabel(src[n],SwingConstants.CENTER);//���� ���ڿ�,���� �����
		can = new XCanvas(dir+src[n]);
		p_south = new JPanel();
		bt_prev = new JButton("����");
		bt_next = new JButton("����");
		
		//����ϻ���
		for(int i=0;i<src.length;i++) {
			Thumb thumb=null;
			list.add(thumb=new Thumb(dir+src[i],this));
			p_west.add(thumb);
		}
		
		//��Ÿ�� 
		la_name.setPreferredSize(new Dimension(700,50));
		la_name.setFont(new Font("Verdana",Font.BOLD ,25));
		
		p_west.setPreferredSize(new Dimension(100,600));
		p_center.setPreferredSize(new Dimension(700,600));
//		p_west.setBackground(Color.YELLOW);
//		p_center.setBackground(Color.GREEN);
		
		//���� 
		add(scroll, BorderLayout.WEST);
		add(p_center);
		p_south.add(bt_prev);
		p_south.add(bt_next);
		p_center.add(la_name);
		p_center.add(can);
		p_center.add(p_south);
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		//�����츦 ȭ�� �߾ӿ� ���� ��
		setVisible(true);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		updateData();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//�̺�Ʈ ����Ų ������Ʈ
		if(obj == bt_prev) {
			prev();
		}else if(obj==bt_next) {
			next();
		}
		updateData();//�ڵ� �ߺ��� �ּ�ȭ �ϱ� ���� prev�� next�� ���� �κ��� ���� ����
	}
	
	public void updateData() {
		can.setSrc(dir+src[n]);
		can.repaint();
		la_name.setText(src[n]+"("+(n+1)+"/"+src.length+")");//���񺯰�
		
	}
	public void prev() {
		if(n>0) {
			n--;			
		}else {
			//�ƴϸ� ���â ����
		JOptionPane.showMessageDialog(this,"ó�� �̹��� �Դϴ�.");
		}
		
	}
	public void next() {
		//�׸��� XCanvas�� ����ϹǷ�, �׷��� img�� ������� �ְ�, �ٽ� �׸���� �ϸ��
		
		//�迭�� �Ѿ����� �ʴ� ���� ������ ++
		if(n<src.length-1) {
			n++;			
		}else {
			//�ƴϸ� ���â ����
			JOptionPane.showMessageDialog(this,"������ �̹��� �Դϴ�.");
		}
	}
	
	public static void main(String[] args) {
		new GalleryApp();
	}



}
