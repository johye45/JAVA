package day1029.poly;
//�������� ���� �ٽ��ѹ� �����غ���

import javax.swing.JButton;
import javax.swing.JComponent;

public class Bird {
	String name = "�� ��";
	String local = "�ѱ�";
	public void fly() {
		System.out.println("���� ���ƿ�");
	}
	
	
	
	public static void main(String[] args) {
		//������ ������� ������ �����ϱ�
		Bird b1 = new Bird();
		Bird b3 = new Sparrow();//���������� 
		Bird b2 = new Duck();//b2�� BirdŬ���� ����, �޼��� ����
		//�������� Ư¡���μ��� �ڽĸ޼��带 ȣ��
		Duck d = new Duck(); //�θ� ����
		
//		b2.fly();//������ ���ƿ�
//		b3.fly();// ������ �ൿ�� �پ��ϴ� -> ������
		
		JComponent bt = new JButton();
		
	}

}
