package study;
import pet.Cat;//앞의 경로는 클래스 패스에 이미 등록됨
class UseCat{
	public static void main(String[] args){
		Cat c = new Cat();
		//classpath상에서의 고양이의 위치를 명시해야 함
		//classpath에 bin까지 등록되어 있으니 그 이하 경로를 import로
		c.eat();//재컴파일, 재실행
	}
}

