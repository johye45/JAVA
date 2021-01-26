//트럭정의
package car;
public class Truck extends Car{// 우리는 Car를 상속받겠다,
						//지금부터 Car의 자원들에 대해 접근이 가능
	//트럭만이 갖는 특징 
	public void dump(){
		System.out.println("물건을 대량으로 옮긴다");
	}
	
}
