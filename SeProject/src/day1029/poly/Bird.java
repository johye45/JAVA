package day1029.poly;
//다형성에 대해 다시한번 공부해보자

import javax.swing.JButton;
import javax.swing.JComponent;

public class Bird {
	String name = "난 새";
	String local = "한국";
	public void fly() {
		System.out.println("새가 날아요");
	}
	
	
	
	public static void main(String[] args) {
		//새들을 대상으로 다형성 공부하기
		Bird b1 = new Bird();
		Bird b3 = new Sparrow();//유연해진다 
		Bird b2 = new Duck();//b2는 Bird클래스 변수, 메서드 접근
		//다형성의 특징으로서는 자식메서드를 호출
		Duck d = new Duck(); //부모께 내거
		
//		b2.fly();//오리가 날아요
//		b3.fly();// 새지만 행동이 다양하다 -> 다형성
		
		JComponent bt = new JButton();
		
	}

}
