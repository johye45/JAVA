/*
 ��Ƽ �ּ� crrl + shift + /(������)
 ��Ƽ �ּ� ���� : crtl + shift +\(��������) 
 �̱� ���� �ּ� : crtl + /������
 �̱� ���� �ּ� ���� : crtl + \��������
AWT�� �÷����� ���� �������� �ٸ��� ǥ���Ǵ� ������ �ֱ⿡ , AWT�� ������ API�� Swing�� ����غ���
Swing�� ���Ӱ� ��� �ʿ� ������, ���� �츮�� ����ؿ��� AWT������Ʈ�� ��κ� J���ξ �ٴ´�
 */
package day1027.gui;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class SwingTest extends JFrame {
	JCheckBox ch ; 
	JButton bt ;
	
	public SwingTest() {
		// TODO Auto-generated constructor stub
		ch = new JCheckBox("��ȭ");
		bt = new JButton("����ư");
		setLayout(new FlowLayout());
		add(ch);
		add(bt);
		setVisible(true);
		setSize(300,400);
		//swing�� �������� �ݱ� ��ư�� ������, ȭ�鿡�� �Ⱥ��̰� �Ǵµ�,
		//�̶�, ���α׷��� ����� ���� �ƴ϶� ���� setVisible()�޼��尡 false�� ��ȯ�� ���̴�
		//���� ������ ���α׷��� �����Ű����, �ܼ� ���� ��ư�� ��������, �Ʒ��� �ڵ带 �ۼ��ϸ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���� ����!!
		//AWT�� ������ ���ʿ��� ��Ű���� �ƴϴ�
		//awt ��Ű���� event�� ��ġ�����ڴ� ������ AWT�� �̿��Ѵ�
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingTest();
	}

}
