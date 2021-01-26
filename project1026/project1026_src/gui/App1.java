/*
윈도우에 들어갈 수 있는 여러 컴포넌트 알아보기
Ex)버튼, 텍스트필드, 라디오 박스, 체크박스, 초이스, 이미지,textare...
*/
package gui;
import java.awt.Frame;//사용하려는 클래스의 위치 등록
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.Label;
import java.awt.Image;
import java.awt.Toolkit;

class App1{
	public static void main(String[] args){
		/*윈도우 생성*/
		/*난생 처음보는 클래스를 만났을때
		대응,대처0)사용하려는 클래스가 대충 어떤 목적으로 지원되는것인지 용도 파악
		대응,대처1)자바의 모든 객체는 결국 3가지 유형밖에 없다
		대응대처2) 클래스는 쓰라고 만든것, 따라서 메모리에 올리는 법을 알면된다
		1)일반클래스 : new 하면됨(new뒤의 생성자 조사 api문서를 통해)
		2)추상클래스 : new 불가하므로, 자식을 정의해서
		            new하거나 이미 구현한 인스턴스를 이용하면 됨(api문서통해)
		3)인터페이스 : new불가능 ,자식을 정의해서
		            new하거나 이미 구현한 인스턴스를 이용하면 됨(api문서통해)
		*/

		//처음보지만 일반이기 때문에 new다음에 오는 생성자를 조사해서 아용하면됨
		Frame frame = new Frame();//자바 윈도우프로그래밍에서의 윈도우!
		//프레임은 디폴트가 눈에 보이지 않는 상태임, 따라서 보이도록 메서드 호출
		frame.setVisible(true);//Window객체로부터 상속받은 메서드
		//매개변수로는 논리값을 사용 할 수 있다.

		//윈도으의 너비 높이를 지정할 수 있는 메서드
		frame.setSize(300,400);//api찾아보기

		//윈도우가 생성되었으므로, 윈도우 안에 배치할 각종 컴포넌트 올려놓아보자
		//button(일반, 추상,,)
		Button bt = new Button("나 버튼");


		//버튼을 부착하기 전에, 레이아웃 스타일을 지정해야 하는데,
		//레이아웃은 추후 배울거니깐
		//일단 FlowLayout을 사용해보자
		FlowLayout flow = new FlowLayout();
		frame.setLayout(flow);

		//버튼을 윈도우에 부착
		frame.add(bt);//add메서드에 매개변수는 Component형이므로,
		//button도 Component의자식이기 때문에 같은 자료형에 해당하여,
		//add()인수로 올 수 있다


		//html에서의 input type = "text"는 자바에서는 TextField라 한다
		TextField text = new TextField("회원정보", 10);//10자크기 확보
		frame.add(text);
		//Checkbox
		Checkbox ch1 = new Checkbox("독서");
		Checkbox ch2 = new Checkbox("수영");
		Checkbox ch3 = new Checkbox("컴퓨터");
	    frame.add(ch1);
		frame.add(ch2);
		frame.add(ch3);
		//TextArea
		TextArea area = new TextArea(5,20);//5행 20열
		frame.add(area);

		//그냥 텍스트
		Label la = new Label("회원가입 양식입니다");
		frame.add(la);

		//이미지 넣기
		//Image는 추상클래스 이며, 플랫폼이 지정한 방식으로 얻을 수 있다
		//플랙폼에 맞게 가져오려면,Toolkit클래스로부터 자원을 얻는다
		Toolkit kit=Toolkit.getDefaultToolkit();//static메서드, 
		//따라서 클래스명으로 접근할 수 있다.
		//툴킷은 이미지를 로컬상의 경로로 부터 얻어올 수 있다
		//경로 사용시 역슬래시는 윈도우os에서만 사용하는 표기이므로
		//지금 이 자바 소스가 모든os에서 실행되려면, 사실 중립적인 경로로 가야한다
		Image img=kit.getImage("D:/workspace/java/project1026/res/ball2.png");
		System.out.println("이미지 주소값은:"+img);

		//화면에 출력하는 수업은 불가,, 왜냐 지금까지 html에서는
		//이미지를 덧붙여서 확인했으나, 자바와 같은 일반적인 컴파일 기반의
		//프로그래밍 언어에서는 랜더링(직접그리는 작업)을 해야 하기 때문이다

	}
}
