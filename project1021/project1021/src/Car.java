class Car{
	String color = "red";
	int price = 500;
	String name = "Benz";
	Wheel wheel = null;//Car클래스 안에 Wheel클래스..
	//클래스 안에는 자료형을 둘 수 있는데 자바의 자료형은 총 4개이다
	//따라서 이 클래스 안에는 문자, 숫자, 논리값 이외에도 객체형도 가능하다
	//객체 자료형도 자료형이니까
	
	//클래스명과 동일한 이름의 메서드를 가리켜 생성자라 하고,
	//생성자는 이름에서도 알수 있듯이, 객체의 생성 타임에, 무언가 초기화 작업이 있을때,
	//작업을 수행하는 용도의 메서드 이다
	public Car(){
		wheel = new Wheel();

	}
	public static void main(String[] args){
	//자동차를 생성하고,
	//자동차의 이름 출력하고
	//자동차의 바퀴의 브랜드 색상 가격을 출력!
	Car c = new Car();
	System.out.println(c.name);
	System.out.println("바퀴:"+c.wheel.brand+","+c.wheel.color+","+c.wheel.price);


	}
	
}
