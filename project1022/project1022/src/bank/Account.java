package bank;//bank

//고객의 계좌를 정의한다 : 업무가 신중해짐, 예민한 데이터를 많이 다룸
//패키지 클래스에 넣은 클래스를 public으로 공개하지 않으면 다른 클래스도
//이 클래스를 사용 불가임, 이건 보안이 아니라 의미없는짓
//public으로 공개하되, 그 안의 내용들에 대해 보안처리!

public class Account{
	//계좌에 들어갈 만한 속성들 정의

//아래처럼 멤버변수를 수정하고, 접근제한자를 앞에 붙여주라
//이 클래스의 접근제한자가 어떠한 작용을 하는지 외부의 클래스에서
//데이터에 접근하는 실습
//public은 보안이라 말할수 없음
//protected, default, private만 확인
//private로 선언된 변수는 절대 아무도 외부에서 접근할 수 없으므로
	//변수에 접근하려면, 메서드를 이용해야 한다

	public String bank="기업은행";//은행명
	protected String customer;//고객이름
	String num= "022-388-85465"; //계좌 번호
	private int balance = 100000;// 금액 , 중요한 변수
	

	//아무도 못쓰게 막았으니, 현재 ACcount클래스 스스로만 접근할 수 있다
	//따라서 멤버 메서드를 제공해준다
	//아래의 메서드는 public이므로 모든 객체가 접근 할 수 있다
	//UseAccount에서 잔고를 수정하고, 출력을 해보자
	public void setBalance(int balance){
		this.balance = balance;
	}

	//잔고확인 메서드 정의
	//이와 같이 private으로 선언된 변수 값을 리턴하는 메서드를
	//가리켜 getter이라 한다
	//그리고 위와 같이 setBalance처럼 
	//pricate변수의 값을 변경하는 메서드를 가리켜 setter라 한다
	//getter와 setter는 아주아주 유명한 메서드 정의기법!
	public int getBalance(){
		return balance;
	}
	
}
