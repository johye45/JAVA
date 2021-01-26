package string;
class StringTest{
	public static void main(String[] args){
		/*
		String은 클래스다
		하지만 우리 인간은 스트링을 너무 압도적으로 많이 사용하기때문에,
		new연산자에 의해 String을 생성하는 것은 너무 불편하다 
		따라서 String 한해서는 마치 일반 데이터 타입처럼 new를 쓰지 않는 표기현식을
		지원해준다. 이러한 String의 생성 방법을 암시적, 묵시적(implicit)생성법이라 한다
		묵시적 생성법에 의한 String은 상수풀에 의해 관리되어 지는데, 
		*/
		/*아래 코드의 수행결과 예측 해보기*/
		String s1 = "apple";//s1 레퍼런스 변수 
		String s2 = "apple";
		System.out.println(s1==s2);

		//String은 시작문자인 'S'가 대문자로 보아 분명 객체이다
		//우리의 개발환경에서 String.class가 어딘가에 있어야 하는데, 보이지 않는다
		//java se 의 모든 api가 보여 있는 압축된 파일
		//C:\Program Files\Java\jdk1.8.0_261\jre\lib
		
		//아래와 같이 new연산자에 의한 스트링 생성법을 명시적(explicit)생성법 이며,
		//명시적 생성법은 상수풀에 생성되지 않으므로 
		//new할때마다 중복 여부를 따지지 안하고 새롭게 생성된다
		String s3 = new String("korea");
		String s4 = new String("korea");
		System.out.println(s3==s4);
		System.out.println("-----------------");

		//주소 비교가 아닌, 객체 동일성을 비교하는 법
		String k1 = "orange";
		String k2 = "orange";
		System.out.println(k1==k2);//주소
		System.out.println(k1.equals(k2));//내용비교

	}
}
