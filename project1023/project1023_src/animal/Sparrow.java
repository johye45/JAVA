//������ �����Ѵ�
package animal;

public class Sparrow extends Bird{
	String name = "�� ����";
	public void jjack(){
		System.out.println("±±");
	}

	//�ڽ��� �θ�� 100%������ �޼��带 �����ϴ� �����
	//�������̵� �̶� �Ѵ� (overriding)
	//�� �����ϴ°�?
	//�θ��� �޼��带 �ڽĿ���, ����� ����, �߰� �ϴµ���
	//���׷��̵� �ϰ� ������

	/*����)
	�����ε��� �������̵� ������
	�����ε��� ���� Ŭ���� ������, ����� ����� �޼��� ���� ����
	���� ������ ����, �Ű����� ������ �ڷ������� �����ϸ�
	�ߺ� ���Ǹ� �������ش�

	�������̵��� ��Ӱ��迡�� �ڽ��� �θ��� �޼��带 ������
	�ϴ� ���
	*/
	public void fly(){
		System.out.println("������ ���ƿ�");
	}
	public static void main(String[] args){
		Sparrow sp = new Sparrow();
		sp.fly();//������ �޼��� ȣ��
		
		Bird bird = new Bird();
		bird.fly();//���� �޼��� ȣ��

		Bird bird2 = new Sparrow();
		bird2.fly();
	
	}
}
