package day1027.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

//Action�� ������ �д�
//��ư���� Ŭ��������, �ؽ�Ʈ �ڽ��� ����
//��ư�� Ŭ�� �̺�Ʈ �����غ���
public class MyActionListener implements ActionListener{
	JTextField t_input;//null
	JTextArea area;
	
	public MyActionListener(JTextField t_input,JTextArea area) {
		//���Ӱ� �����ϸ� �ȵ�
		//������ area , t_input ��������
		this.t_input = t_input;
		this.area = area;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("�� ������?");
		String msg = t_input.getText();//�ؽ�Ʈ �ʵ� ���� ������
		area.append(msg+"\n");//���� �߰�
		t_input.setText("");//�ʱ�ȭ ���ؽ�Ʈ��
	}
	
}
