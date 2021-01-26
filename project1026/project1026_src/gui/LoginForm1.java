package gui;
import java.awt.*;//선호하지 않지만 편한 방법

class LoginForm1 extends Frame{//LoginForm은 윈도우다
	//has a관계는 멤버변수가 객체형일때를 의미한다
	Label la_id ;
	Label la_pass ;
	TextField t_id;
	TextField t_pass;
	Button bt_login;
	Button bt_regist;
	Panel p_center;//센터에 그리드를 적용할 패널
	Panel p_south;//남쪽에 붙이 패널 (여기에 버튼 두개)

	public LoginForm1(){//생성자 LoginForm 활용
		
		//메모리 초기화
		//특히 부품은 이 객체가 태어날때 함께 태어나야 하므로,
		//생성자의 타이밍을 놓치지 말자
		la_id = new Label("ID");
		la_pass = new Label("Password");
		t_id = new TextField(15);
		t_pass = new TextField(15);
		bt_login = new Button("Login");
		bt_regist = new Button("Regist");
		p_center = new Panel();
		p_south = new Panel();

		//생성만 한 상태이고, 아직 조립이나 스타일은 부여하지 않음
		//조립
		/*Frame은 개발자가 레이아웃을 지정하지 않으면 디폴트가 BorderLayout이다
		this.setLayout(new BorderLayout());//==frame.setLayout 이지만 자신이 frame이므로 XX, 
		그리고 디폴트가 BorderLayout이므로 new해줄 필요가 없다*/
		
		p_center.setBackground(new Color(153,255,0));//Color형 c를 대입 
		//센터 패널을 윈도우의 BorderLayout센터에 넣자
		this.add(p_center,BorderLayout.CENTER);//BorderLayout.CENTER 생략 가능

		//상수는 직관성을 부여한 데이터이다. final로 더이상 변경할 수 없으며,
		//static으로 인스턴스간 공유가 가능하며, public으로 선언하여, 
		//모든객체가 접근할 수 있도록 접근을 풀었다
		p_south.setBackground(Color.YELLOW);//rgb색을 인간이 알기 쉬운 색으로 사용해보자
		this.add(p_south, BorderLayout.SOUTH);

		//p_center그리드 적용
		p_center.setLayout(new GridLayout(2,2));//2행 2열
		p_center.add(la_id);//라벨부착
		p_center.add(t_id);//id텍스트박스 부착
		p_center.add(la_pass);//라벨 부착
		p_center.add(t_pass);//pass텍스트박스 부착

		//panel은 아무런 배치관리자를 적용하지 않으면 디폴트가 FlowLayout이다
		p_south.add(bt_login);
		p_south.add(bt_regist);


		//this의 정확한 의미 : 래퍼런스 변수
		//단 나 자신의 주소값을 가진
		//해당 인스턴스가 자기 자기 자신을 가리킬때
		setSize(400,150);//윈도우.setSize = frame.setSeize = this.setSize = setSize
		setVisible(true);
	}
	
	public static void main(String[] args){
		new LoginForm1();
	}
}
