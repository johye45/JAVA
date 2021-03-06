/*
JVM이 윈도우로부터, 이벤트 정보를 받으면, 해당 정보의 유형에 따라
알맞는 이벤트 객체의 인스턴스를 메모리에 올리고, 이 올려진 인스턴스 정보는
리스너라 불리는, 이벤트 전담 객체에게 전달되어 진다
이때 리스너는 몸체가 불완전한 인터페이스로 지원되는데, 그 이유는
클릭등을 눌렀을때 무얼 어떻게 처리할지의 몫은 개발자가 결정해야 하기때문
예) 클릭이벤트일 경우 자바에서는 액션 이벤트라 하고 해당 객체는
ActionEvent이다
이 ActionEvent의 인스턴스는 사용자가 클릭을 할때마다 
리스너에게 전달되어지고, 개발자는 이 리스너의 추상메서드를 재정의함으로써,
하고싶은 로직을 완성 지으면 된다
*/
package event;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyListener implements ActionListener{//MyListener is a ActionListener
	public void actionPerformed(ActionEvent e){
		System.out.println("나 눌렀어?");
	}

}
