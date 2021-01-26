package use;
import car.Taxi;//택시
import car.Bus;//버스
import car.Truck;//트럭
//위의방식이 귀찮을 경우
//import car.*; //이 방식은 import에서 다루고자 하는 기술이 무엇인지
				//빨리 해석이 안된다. 따라서 따로따로 해주는것이 좋다


class UseCar{
	public static void main(String[] args){
		//만일택시를 사용하고 싶을 때 Car클래스를 메모리에
		//따로 안해줘도됨. 
		//왜냐 new하면 부모는 자동으로 인스턴스가 생성
		Taxi t = new Taxi();//택시의 인스턴스 생성 
		//택시만 생성될거 같지만 택시보다 앞선 
		//부모인 Car가 존재해야 택시도 존재할 수
		//있기 때문에 Car인스턴스도 생성된다

		t.pass();//택시 메서드 호출되는지
		//그리고, 택시 클래스 코드안에는 없지만, Car클래스가 보유한
		//변수가 메서드 호출해보자
		//만일 호출이 된다면 Car인스턴스가 생성된 것임

		t.move();//이 메서드는 분명 Car에 있다!
		//택시가 부모인 Car를 접근한 것임
		
		

	}
}
