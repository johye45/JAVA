//지금까지는 sun사의개발자가 제공해준 그대로 컴포넌트들을 보아왔지만
//이예제에서는 우리가 컴포넌트의 그려지는 방식을 간섭하여,
//원하느 그림으로 컴포넌트가 보여지도록 처리해보자(그래픽 처리를 관여)
//우리 주도하에 그려보자

package day1028.graphic;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;

public class PaintTest extends JFrame{
	MyCanvas can ;//도화지를 포현한 컴포넌트
	
	public PaintTest() {
		can = new MyCanvas();
		
		//캔버스에 그림을 그리려면, 캔버스가 스스로 그리는 메서드인.paint()메서드 재정의
		
		add(can);//캔버스를 프레임에 부착
		can.setBackground(Color.CYAN);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//현재 클래스인 PaintTest가 JFrame의 paint. 메서드를 오버라이드하면
	//실행시 자식이 재정의 한 메서드를 우선순위로 호출해준다
	//Button, JFrame, Choice거의 다 방해 금지 그대로 유지해 줘야 함
	//하지만 컴포넌트 중 개발자가 주도해서 그림을 그릴 수 있는 컴포넌트
	//Canvas(AWT), JPanel(비어 있는 컴포넌트)
/*
	public void paint(Graphics g) {
		System.out.println("저 지금 직접 스스로를 그려요");
	}
*/
	public static void main(String[] args) {
		new PaintTest();
		
	}

}
