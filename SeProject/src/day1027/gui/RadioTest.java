/*
 * �۾� ũ�� ���� ctrl + (+Ű)
 * ����� ��� ���� ctrl + shift + L
 * �ڵ� ����Ʈ : �ش� Ŭ������ Ŀ�� �÷� ���� ctrl + shift + O
 * �ڵ� ���� : ctrl shift + F
 * �ش� ��ü�� api���� �ٷΰ��� : �ش� Ŭ���� Ŀ�� �ø� �� shift + F2(���Ű) ���ͳ� ����� ������
 * ��� sout�̶�� ���� �ܾ� �Է°� ���ÿ� ctrl + space 
 * �� ���� �� Alt ������ ����Ű ��, �Ʒ�  �ڵ� �̵�
 * �� ���� �� crtl + Alt ����Ű �Ʒ� ���� 
 
 */
package day1027.gui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;

public class RadioTest extends Frame {
	// �ڹٿ����� üũ�ڽ��� ������ �����
	CheckboxGroup group = new CheckboxGroup();
	int x;

	public RadioTest() {
		group = new CheckboxGroup();
		setLayout(new FlowLayout());
		this.add(new Checkbox("�", group, false));
		this.add(new Checkbox("����", group, false));
		this.add(new Checkbox("��ǻ��", group, false));
		this.add(new Checkbox("��ȭ", group, false));
		this.add(new Checkbox("�丮", group, false));
		this.add(new Checkbox("�ְߵ�����", group, true));

		setSize(300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("�̳� ����");
		new RadioTest();

	}

}
