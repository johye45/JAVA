package day1027.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

//Action은 범위가 넓다
//버튼에는 클릭이지만, 텍스트 박스는 엔터
//버튼에 클릭 이벤트 감지해보다
public class MyActionListener implements ActionListener{
	JTextField t_input;//null
	JTextArea area;
	
	public MyActionListener(JTextField t_input,JTextArea area) {
		//새롭게 생성하면 안됨
		//기존의 area , t_input 가져오기
		this.t_input = t_input;
		this.area = area;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("나 눌렀어?");
		String msg = t_input.getText();//텍스트 필드 값을 구하자
		area.append(msg+"\n");//내용 추가
		t_input.setText("");//초기화 빈텍스트로
	}
	
}
