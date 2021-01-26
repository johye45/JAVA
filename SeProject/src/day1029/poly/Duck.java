package day1029.poly;

public class Duck extends Bird{
	String color = "yellow";
	
	//부모의메서드 재정의
	public void fly() {
		System.out.println("오리가 날아요");
	}
	public void quack() {
		System.out.println("꽥꽥");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
