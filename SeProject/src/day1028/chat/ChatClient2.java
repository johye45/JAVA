package day1028.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient2 extends JFrame implements KeyListener{
					//   is	a           is a	
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt;
	JPanel p_south;
	ChatClient ch1;
	
	public ChatClient2(ChatClient ch1) {
		this.ch1 = ch1;
		
		
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(15);
		bt = new JButton("����");
		p_south = new JPanel();
		
		//�г����� ����Ʈ�� FlowLayout�̱⶧��
		p_south.add(t_input);
		p_south.add(bt);

		add(scroll);//���Ϳ� ��ũ�� ����
		add(p_south,BorderLayout.SOUTH);//���ʿ� �г� ����
		
		
		//��Ÿ�� ����
		area.setBackground(Color.PINK);
		t_input.setBackground(Color.green);
		t_input.setForeground(Color.black);
		bt.setBackground(Color.BLACK);
		bt.setForeground(Color.WHITE);
		
		t_input.setPreferredSize(new Dimension(285,30));//�ؽ�Ʈ �ڽ� ũ��
		
			
		//�����ֱ� ������ �̸� ����(������Ʈ�� ������ ����)
		t_input.addKeyListener(this);//�������� ��������
		
		setBounds(500, 150, 300, 400);
//		setSize(300,400);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}
	
	//������̼��̴�. java5���� �����Ǵ� ������ �ּ�
	//�Ϲ����� �ּ��� ���α׷��� ������ ������, 
	//������̼��� ���α׷��ֿ��� � ǥ�ø� �ϱ� ���� ����
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//����Ű�� ������ area�� �Է� �����͸� �ݿ�����(���� ��Ű��)
		int key = e.getKeyCode(); //Ű �ڵ尪 ��ȯ
		if(key == 10) {
			send();
		}
		
	}
	
	public void send() {
//		���� ���� ó��
		String msg = t_input.getText();//�ؽ�Ʈ �ʵ� ���� ������
		area.append(msg+"\n");//���� �߰�
		t_input.setText("");//�ʱ�ȭ ���ؽ�Ʈ��
		
		//���� â
		ch1.area.append(msg+"\n");//���� �߰�
		ch1.t_input.setText("");//�ʱ�ȭ ���ؽ�Ʈ��
	}
	
	

}