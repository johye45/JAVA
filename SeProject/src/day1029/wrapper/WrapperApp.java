package day1029.wrapper;
// int x = "5" �� ���� 5�� �ٲٷ��� 

//�ڹٿ����� ��� �ڷ����� 

public class WrapperApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "6";
		int y = 4;
		System.out.println(x+y);
		int z = Integer.parseInt(x);//static�޼��� �̹Ƿ�Integer.��� �����Ѵ�
		System.out.println(z+y);
		
		Integer i=5;//�ڹ��� Ŭ���� ��Ģ���� ���ٸ� �������� �Ұ���
		//������ IntegerŬ������ �⺻ �ڷ����� ���õ� ��ü�̹Ƿ� , ��ġ �⺻ �ڷ��� ó��
		//�����͸� ������ �� �ִ�
		//��ǻ�� ���������� 5��� �⺻�ڷ����� ��üȭ �� ���̴�(Boxing: �⺻ �����͸� �ڽ��� ���մ�)
		//WrapperŬ�������� box�� ���δٿ��� ������ ��
	
		int k = i; //��Ģ�� ��ü�ڷ����� �⺻�ڷ����� �������� ������, �Ұ����� ��������
		//���� ���������� ����Ŭ������
		//�⺻ �ڷ����� ���õ� ��ü�̹Ƿ�, ���������� inBoxing�� ���� �⺻�ڷ�������
		//��ȯ�� ���̴�
		
		//��� : �⺻�ڷ����� ��üȭ (Boxing)
		//��ü �ڷ����� �⺻�ڷ������� (unBoxing)
		//Box�� ���ΰ� �ٽ� ������ ��ü�� ������ Wrapper Ŭ������ �θ���
	}

}
