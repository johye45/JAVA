package day1028.graphic.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoAlbum extends JFrame implements ActionListener{
	AlbumPanel p;//����Ʈ �޼��带 ������ �Ϸ���, Ŭ������ ���� �ؾ� �Ѵ�
	
	JPanel p_south;//��ư �ΰ��� ������ �г�
	JButton bt_prev, bt_next;
	
	public PhotoAlbum() {
		p =new AlbumPanel();
		p.setBackground(Color.YELLOW);
		
		p_south = new JPanel();
		bt_prev = new JButton("����");
		bt_next = new JButton("����");
		 
		
		//����
		add(p);//�߾ӿ� �ٹ��г� �ֱ�
		p_south.add(bt_prev);
		p_south.add(bt_next);
		add(p_south,BorderLayout.SOUTH);//���ʿ� �г� �ֱ�
		
		//���� ��ư�� ������ ����
		bt_prev.addActionListener(this);
		//���� ��ư�� ������ ����
		bt_next.addActionListener(this);
		
		setSize(500,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//�̺�Ʈ�� ����Ų �̺�Ʈ �ҽ� �����ϱ�
		
		if(obj == bt_prev) {
			//���� ��ư�̸� n����
			p.n--;
			
		}else if(obj == bt_next) {
			//���� ��ư�̸� n����
			p.n++;
		}
		
		//ȭ�� ���� (���� ALbumPanel�� paint()ȣ�� �Ұ�)
		//�����ϵ��� ��û
		p.repaint();//�ٽ� �׸���
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PhotoAlbum();
	}

}
