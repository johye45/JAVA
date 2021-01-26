//지금까지는 콘솔에서만 자바를 실행 시켰지만
//자바도 그래픽 인터페이스(API)를 지원한다
//자바의 윈도우와 버튼을 해보자
package gui;
import java.awt.Frame;//프레임 위치 지정
import java.awt.Button;//버튼 위치 지정
class AppTest{
	public static void main(String[] args){
		//자바에서는 윈도우의 역할을 해주는 클래스로 Frame을 지원한다
		Frame frame;//sun에서 제작한 클래스라서, 원본도 없다
					//따라서 sun에서 제공하는 공식문서를 보고 위치를 
					//알아내자
		frame = new Frame();//윈도우 생성
		frame.setSize(300,400);//생성된 윈도우에 너비, 높이 주기
		frame.setVisible(true);//프게임의 속성을 보이게
	
		//버튼 생성하여, 프레임에 붙이기
		Button bt = new Button("나 버튼");
		frame.add(bt);
	}
}
