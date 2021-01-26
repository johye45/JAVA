package day1029.collection;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCollection extends JFrame implements ActionListener{
	JPanel p_north, p_center;
	JButton bt_create, bt_bg;
	
	
	//�迭�� ũ�⸦ ���ؾ� �ϱ� ������, ũ�⸦ �� �� ���� ���α׷����� ��뿡 ������ �ִ�
//	JButton[] btn = new JButton[];//�迭�� ���� ū Ư¡ , �迭�� ������ �ݵ�� ũ�� ���
	
	ArrayList<JButton> btn = new ArrayList<JButton>();
	
	public ButtonCollection() {
		p_north = new JPanel();
		p_center = new JPanel();
		bt_create = new JButton("��ư����");
		bt_bg = new JButton("����");
				
		p_north.add(bt_create);
		p_north.add(bt_bg);
		
		//�����ӿ� ����
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
		//��ư�� ������ ����
		bt_create.addActionListener(this);
		bt_bg.addActionListener(this);
	
		
				
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//�̺�Ʈ�� ����Ų ������Ʈ ��ȯ -> ��ư �����ϱ� ����
		if(obj == bt_create) {
			create();
		}else if(obj.equals(bt_bg)) {
			setBg();
		}
	}
	
	public void create() {
		//��ư �����Ͽ� p_center�� ����

		JButton bt = new CustonButton();
		p_center.add(bt);
		
		//����Ʈ�� �߰��ϱ� js�� push()
		btn.add(bt);
		System.out.println("������� ������ ����Ʈ�� ����"+btn.size());
		bt.setText("��ư"+Integer.toString(btn.size()));// ��ư�� ���� ���� �����ϱ�
		
		
		//p_center�� ��ư�� �׸��� �ƴ϶�, ��ư�� �߰��� ���̴�
		//���� �̶��� p_center�� �����ϸ� �ȴ� updateUI()�̴�
		p_center.updateUI();
		
	}
	public void setBg() {
		
		//btn�̶�� ����Ʈ�� ����ִ� ��� ��Ҹ� ������� ���� �ٲٱ�
		//ArrayList�� �����ִ� ���� �̹Ƿ� for�� ��� ����
		for(int i=0; i<btn.size();i++) {
			JButton bt = btn.get(i);
			bt.setBackground(Color.yellow);		
		}
	
	}
	

	public static void main(String[] args) {
		new ButtonCollection();
	}


}
