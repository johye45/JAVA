class Car{
	String color = "red";
	int price = 500;
	String name = "Benz";
	Wheel wheel = null;//CarŬ���� �ȿ� WheelŬ����..
	//Ŭ���� �ȿ��� �ڷ����� �� �� �ִµ� �ڹ��� �ڷ����� �� 4���̴�
	//���� �� Ŭ���� �ȿ��� ����, ����, ���� �̿ܿ��� ��ü���� �����ϴ�
	//��ü �ڷ����� �ڷ����̴ϱ�
	
	//Ŭ������� ������ �̸��� �޼��带 ������ �����ڶ� �ϰ�,
	//�����ڴ� �̸������� �˼� �ֵ���, ��ü�� ���� Ÿ�ӿ�, ���� �ʱ�ȭ �۾��� ������,
	//�۾��� �����ϴ� �뵵�� �޼��� �̴�
	public Car(){
		wheel = new Wheel();

	}
	public static void main(String[] args){
	//�ڵ����� �����ϰ�,
	//�ڵ����� �̸� ����ϰ�
	//�ڵ����� ������ �귣�� ���� ������ ���!
	Car c = new Car();
	System.out.println(c.name);
	System.out.println("����:"+c.wheel.brand+","+c.wheel.color+","+c.wheel.price);


	}
	
}
