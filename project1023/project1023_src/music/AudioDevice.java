//32명의 개발자가 아직 개발코드를 작성하지도 않은 시점이기 때문에
//현재클래스에는 반드시 구현해야 할 기능을 명시한다
package music;
abstract public class AudioDevice{
	//볼륨 조절 기능
	//static과 함께 수정자로 불리는 한가지 abstract 
	//abstract: 추상적인, 메서드에 붙일 경우 
	//			브레이스 없는 불완전한 메서드를 의미
	//불완전한 메서드를 단 1개라도 보유하고 있다면, 
	//그 클래스는 불완전한클래스 이며, 
	//이러한 클래스를 추상 클래스라 한다
	abstract public void setVolume();//{}없는 메서드가 불안 메서드 이고 이게 추상메서드	
	
	//mp3실행 기능
	abstract public void playMP3();//추상메서드를 정의, 자식들을 구현강제하려고


}
