
package use;
//use앞의 bin까지를 환경변수로 등록하면됨
import animal.Dog;
//사용하고자 하는 클래스의 위치 명시
//Dog라는 클래스의 package선언부를 그대로 적으면됨

class UseDog{
	public static void main(String[] args){
//현재 클래스와는 다른 경로에 있는 클래스를 사용해야 하는데,
//컴파일러가 어떻게 Dog.class를 찾을 수있느지 알아야 한다
//현재로서는 컴파일러가 UseDog과 같은 디렉터리만 찾아 헤맨다
//따라서 아래의 코드는 cant find sysbol에러 날것임
//이 문제를 해결하려면 우리의 클래스 경로를 알려줘야한다
//일반적으로 경로를 등록할때는 환경변수를 이용한다
//경로가 일반 파일일 경우는 path환경변수 이지만
//경로가 클래스 파일일 경우는 classpath환경변수를 이용하면 됨
//이때,classpath환경변수에 어느경로를 등록해야 할지 고민해보자
//현재 UseDog클래스와 Dog클래스에서 우리가 생략한 경로는..?
		Dog d= new Dog();
		d.run();//메서드 추가, 재컴파일
	}
}