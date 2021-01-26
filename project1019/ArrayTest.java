//자바도 다른언어와 마찬가지로 배열을 지원한다
//단 자바는 인터프리터방식이 아닌 컴파일 기반의 응요프로그램으로서
//배열 선언시 반드시 자료형을 선언해야 한다(js와 다름)
class ArrayTest1{
	public static void mian(String[] args){
		//int형 배열 선언
		//자바 스크립트와는 달리, 자바에서는 배열에 데이텨형을 
		//섞어 넣을 수 없고 반드시 한 종류의 데이터 타입만 담을 수 있다
		int[] arr = new int[2];//반드시 자료형과 크기 명시해야 함
		arr[0] = 7;
		arr[1] = 23;
		arr[2] = 9;

		for(int i = 0; i<arr.length; i++){
			System.out.print(arr[i]);
		}

	}
}