package animal;
public class Duck extends Bird{
	/*Duck is a Bird*/
	/*Duck 형은 Bird형이다*/
	/*오리는 새다*/
	String name="난 오리";
	public void quack(){
		System.out.println("꽥꽥");
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
		r=a;//가능
		a=(Duck)r; // 작은 자료형에 큰자료형 대입  down casting
		r=(Bird)a; // 큰자료형에  작은자료형 대입  up casting

		//결론 : 객체 자료형도 자료형이므로, 기본자료형의 원칙이 그대로 적용됨
	}
}
