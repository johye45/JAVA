/*
 * 글씨 크기 조절 ctrl + (+키)
 * 단축기 모두 보기 ctrl + shift + L
 * 자동 임포트 : 해당 클래스에 커서 올려 놓고 ctrl + shift + O
 * 자동 정렬 : ctrl shift + F
 * 해당 객체의 api문서 바로가기 : 해당 클래스 커서 올린 후 shift + F2(기능키) 인터넷 연결디 전제됨
 * 출력 sout이라는 단축 단어 입력과 동시에 ctrl + space 
 * 블럭 지정 후 Alt 누르고 방향키 위, 아래  코드 이동
 * 블럭 지정 후 crtl + Alt 방향키 아래 복사 
 
 */
package day1027.gui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;

public class RadioTest extends Frame {
	// 자바에서는 체크박스를 라디오로 사용함
	CheckboxGroup group = new CheckboxGroup();
	int x;

	public RadioTest() {
		group = new CheckboxGroup();
		setLayout(new FlowLayout());
		this.add(new Checkbox("운동", group, false));
		this.add(new Checkbox("독서", group, false));
		this.add(new Checkbox("컴퓨터", group, false));
		this.add(new Checkbox("영화", group, false));
		this.add(new Checkbox("요리", group, false));
		this.add(new Checkbox("애견돌보기", group, true));

		setSize(300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("겁나 빠름");
		new RadioTest();

	}

}
