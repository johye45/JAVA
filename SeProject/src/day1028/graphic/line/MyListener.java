package day1028.graphic.line;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener{
	XCanvas can;//null
	
	//캔버스의 주소값을 넘겨받을 메서드필요 하다 , 이
	public MyListener(XCanvas can) {
		this.can =can;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		//LineMaker 캔버스에 선을 그리되,
		//LineMaker 클래스의 JTextField의 값을 이용하여 그려라
		
		//XCanvas의 paint(); 불가능
		//paint()메서드는 개발자가 직접 호출할수도 업속, 호출해서도 안된다
		//paint()메서드는 그림이 그려질 준비가 되었을때 시스템, 즉 JVM에 의해 호출된다
		//따라서 개발자가 원하는 타임에 그림을 갱신하게 하려면, paint()메서드를 직접 호출해서는
		//아니되고 갱신할 것을 시스템에 요청 해야 한다  repaint() 다시 그려~~-> update()화면을 지우는
		//-> paint()
		
		//캔버스가 보유한 repaint()호출
		can.repaint();
	}
}
