package day1029.wrapper;
// int x = "5" 를 정수 5로 바꾸려면 

//자바에서는 모든 자료형이 

public class WrapperApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "6";
		int y = 4;
		System.out.println(x+y);
		int z = Integer.parseInt(x);//static메서드 이므로Integer.찍고 접근한다
		System.out.println(z+y);
		
		Integer i=5;//자바의 클래스 원칙으로 본다면 저런식은 불가능
		//하지만 Integer클래스는 기본 자료형과 관련된 객체이므로 , 마치 기본 자료형 처럼
		//데이터를 대입할 수 있다
		//사실사아 내부적으로 5라는 기본자료형이 객체화 된 것이다(Boxing: 기본 데이터를 박스로 감쌌다)
		//Wrapper클ㄹ래스는 box로 감싸다에서 접근한 말
	
		int k = i; //원칙상 객체자료형을 기본자료형에 넣으려고 했으니, 불가능한 일이지만
		//위와 마찬가지로 래퍼클래스는
		//기본 자료형과 관련된 객체이므로, 내부적으로 inBoxing에 의해 기본자료형으로
		//변환된 것이다
		
		//결론 : 기본자료형을 객체화 (Boxing)
		//객체 자료형을 기본자료형으로 (unBoxing)
		//Box로 감싸고 다시 꺼내는 객체를 가리켜 Wrapper 클래스라 부른다
	}

}
