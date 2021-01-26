package day1030.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements KeyListener,ActionListener{
					//   is	a           is a	

	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt;
	JButton bt_open;//��ȭ ������ ���� ��ư
	JPanel p_south;
	private ChatB chatB;//����
	private ChatC chatC;
	
	public ChatA() {
		//������ �θ� ���� �¾�� ��super(), JFrame();
		super("��ȭâA");
		
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(10);
		bt = new JButton("send");
		bt_open = new JButton("open");
		p_south = new JPanel();
		
		//�г����� ����Ʈ�� FlowLayout�̱⶧��
		p_south.add(t_input);
		p_south.add(bt);
		p_south.add(bt_open);

		add(scroll);//���Ϳ� ��ũ�� ����
		add(p_south,BorderLayout.SOUTH);//���ʿ� �г� ����
		
		
		//��Ÿ�� ����
		area.setBackground(Color.YELLOW);
		t_input.setBackground(Color.green);
		t_input.setForeground(Color.black);
		bt.setBackground(Color.BLACK);
		bt.setForeground(Color.WHITE);
		
		t_input.setPreferredSize(new Dimension(255,30));//�ؽ�Ʈ �ڽ� ũ��
		
			
		//�����ֱ� ������ �̸� ����(������Ʈ�� ������ ����)
		t_input.addKeyListener(this);//�������� ��������
		
		//send��ư�� ������ ����
		bt.addActionListener(this);
		
		//open��ư�� ������ ����
		bt_open.addActionListener(this);
		
		setBounds(200, 150, 300, 400);//�����ϰ� â�� ���� ����
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
	
	//send open��ư �������� ����
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton btn = (JButton)obj;//���� �ڏ������� ��ȯ
		if(btn == bt) {
			System.out.println("send ��ư ������?");	
			send();
		}else if(btn.equals(bt_open)) {//���� ��ư�� ���� ��ư�� ���� ��ư�̶��
			System.out.println("open ��ư ������?");			
			open();
		}
		
		
	}
	//�޼��� â�� ��ȭ���� �����ϱ�
	public void send() {
		//���� ���� ä�� ó��
		String msg = t_input.getText();//�ؽ�Ʈ �ʵ� ���� ������
		area.append(msg+"\n");//���� �߰�
		t_input.setText("");//�ʱ�ȭ ���ؽ�Ʈ��
		
		//���濡 ���� ä�� ó��
		chatB.area.append(msg+"\n");//���� �߰�
		chatC.area.append(msg+"\n");//���� �߰�
//		chatB.t_input.setText("");//�ʱ�ȭ ���ؽ�Ʈ��
		
	
	}
	//��ȭ�� ���� ������ ����
	public void open() {
		//ChatB,ChatC �¾�� 
		chatB = new ChatB();
		chatC = new ChatC();
	
//		ChatB���� ChatA�� ChatC�� �Ѱ��ְ�
		chatB.setChatA(this);
		chatB.setChatC(chatC);
//		ChatC���� ChatA�� ChatB�� �Ѱ��ְ�
		chatC.setChatA(this);
		chatC.setChatB(chatB);
	}
		
	public static void main(String[] args) {
		new ChatA();

	}





}
