package animal;
public class Duck extends Bird{
	/*Duck is a Bird*/
	/*Duck ���� Bird���̴�*/
	/*������ ����*/
	String name="�� ����";
	public void quack(){
		System.out.println("�в�");
	}

	public static void main(String[] args){
		Duck d1 = new Duck();
		Duck d2 = new Duck();
		Bird b = new Bird();

		byte s ;
		short k;
		k=(byte)s; //demotion

		Duck a= new Duck();
		Bird r = new Bird();
		r=a;//����
		a=(Duck)r; // ���� �ڷ����� ū�ڷ��� ����  down casting
		r=(Bird)a; // ū�ڷ�����  �����ڷ��� ����  up casting

		//��� : ��ü �ڷ����� �ڷ����̹Ƿ�, �⺻�ڷ����� ��Ģ�� �״�� �����
	}
}
