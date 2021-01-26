package music;
import riding.Wing;
class UseDevice{
	public static void main(String[] args){
		/*추상클래스는 불완전한 클래스 이므로, 인스턴스
		생성이 불가능하다
		즉, 불완전하기 때문에 미완성이라서 
		따라서 자식객체가 완성하면 가능하다
		결국 자식에 의해 인스턴스화 될 수 있다*/
		//AudioDevice ad = new Speaker();
		Wing wing = new Speaker();//riding.Wing으로 해도됨 import안쓰고
		wing.fly();//Speaker의 fly를 호출하게됨

		//extends건 implements건 둘다 is a다
		//따라서 서로간 같은 종류의 자료형으로 간주되며, 형변환도 지원
		//자식이 오버라이딩을 하면, 자식의 메서드를 최우선 호출
	}
}
