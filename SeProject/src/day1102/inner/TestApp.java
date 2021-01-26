package day1102.inner;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TestApp extends JFrame{
	Canvas can;
	JButton bt;
	JTextField t;
	
	public TestApp() {
		//�˹����� ���� Ŭ���������� ����ϰ�, ���� ���뼺�� �������
		//���� ��Ǫ��(.java)���� ������ ������ ������???
		//�̷���, �� ��ȸ���� ��ü ����� ��� �����͸� Ŭ������ ����� �� �ִ�..
		//Inner Anonymous Class �����͸�Ŭ������ �Ѵ�!!!
		//������ ���� new�� ����� Ŭ������ ������ Ŭ������ �����ϸ�ȴ�
		//�ַ� �̺�Ʈ�� ������ Ŭ������ �ش� ���ø����̼ǿ����� ���ǹǷ�, ���밡�ɼ���
		//����.���� �����͸�Ŭ������ ���� ���ȴ�..
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawLine(0, 0, 100, 100);
			}
		};
		setLayout(new FlowLayout());
		add(bt = new JButton() {
			public void paint(Graphics g) {
				g.setColor(Color.RED);
				g.fillRect(0, 0, 100, 40);
			}
		});
		
		add(can);
		add(t=new JTextField(20));
		
		//�����͸�Ŭ������ �ڽ��� �����ϰ� �ִ� �ٱ��� Ŭ������ ��������� 
		//������ �� �ִ�..
		t.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				System.out.println("Ű������?");
			}
		});
		
		//�����͸�Ŭ������ ���������� final�� �Ȱ͸� ������ ����.. 
		final int x=0;
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(x+"�� ������?");
			}
		});
		
		//������ �̺�Ʈ ���� 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		can.setPreferredSize(new Dimension(300, 300));
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new TestApp();

	}

}
