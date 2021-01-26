
//use패키지에서 Account계좌 클래스 접근
package use;

import bank.Account;//bank이전의 경로는 이미 환경변수 classpath에 등록되어 있음

//현재 클래스는 public으로 안해도됨 = 공개할 필요가 없다
//현재 클래스는 사용하려는 쪽은 공개가 될 필요가 없다
//UseAccount(사용하려는 객체)공개 X --> Account(사용당할 객체) 공개O
class UseAccount{
	public static void main(String[] args){
		Account acc = new Account();//계좌 클래스 생성  public이라 가능함
		//접근제한자 별로 접근하기
		
		//bank은행명 public으로 선언되어 있으므로, 무조건 접근이 가능하다
		System.out.println(acc.bank);
		//public은 보안 자체가 없음 

		//customer는 protected로 선언되어 있으므로 상속관계에 있거나,
		//같은 패키지인 경우에만 접근이 가능하다
		//현재UseAccount는 Account와 상속관계가 없고
		//서로 다른 패키지 이므로, 데이터 접근이 불가능하다 -> 컴파일시 에러남
		//System.out.println(acc.customer);
	
		//계좌번호 num변수는 개발자가 아무것도 명시하지 않았는데
		//이러한 접근제한자를 default접근제한자라고 하고 
		//우리가 default라고 키워드를 명시해서는 안된다
		//default접근제한자는 같은 패키지에 있는 클래스 끼리만 접근을 허용해주므로,
		//protected보다 한단계 더 까다롭다 (즉, 상속관계에 있어도, 같은 패키지가 아니라면 접근 불가)
		//System.out.println(acc.num);
		//error : num is not public in Account, cannot be accessed from outside package = 공개되어 있지 않으므로 외부에서 접근이 불가능하다
		//지금까지 실습했던 모든 클래스가 default였고, 우리는 같은 디렉토리에서
		//실습을 했기 때문에 에러가 안난것뿐임, 
		//패키지를 사용하기때문에 접근제한자를 알아야 함

		//계좌 잔액 balance를 테스트해 보자
		//balance는 가장 강력한 접근제한자인 private가 적용되어 있으므로,
		//Account클래스 스스로만 접근이 가능하다
		//따라서 우리는 Account자신이 아니라서 절대 사용못함!! = 폐쇄적임
		//System.out.println(acc.balance);
		//error : balance has privae access in Account
		
		//acc.balance = 10;//이 방법은 직접 접근이므로 불가능
		acc.setBalance(10);//10원으로 수정, 메서드를 통해 접근하므로 가능
		//잔고 수정 완료, 수정된 잔고 확인 방법은?..
		//잔고 수정이 아니라 잔고에 접근하려는것 또한 메서드를 제공해줘야 함
		//잔고확인↓
		System.out.println(acc.getBalance());
	
	
	}
}
