
//use��Ű������ Account���� Ŭ���� ����
package use;

import bank.Account;//bank������ ��δ� �̹� ȯ�溯�� classpath�� ��ϵǾ� ����

//���� Ŭ������ public���� ���ص��� = ������ �ʿ䰡 ����
//���� Ŭ������ ����Ϸ��� ���� ������ �� �ʿ䰡 ����
//UseAccount(����Ϸ��� ��ü)���� X --> Account(������ ��ü) ����O
class UseAccount{
	public static void main(String[] args){
		Account acc = new Account();//���� Ŭ���� ����  public�̶� ������
		//���������� ���� �����ϱ�
		
		//bank����� public���� ����Ǿ� �����Ƿ�, ������ ������ �����ϴ�
		System.out.println(acc.bank);
		//public�� ���� ��ü�� ���� 

		//customer�� protected�� ����Ǿ� �����Ƿ� ��Ӱ��迡 �ְų�,
		//���� ��Ű���� ��쿡�� ������ �����ϴ�
		//����UseAccount�� Account�� ��Ӱ��谡 ����
		//���� �ٸ� ��Ű�� �̹Ƿ�, ������ ������ �Ұ����ϴ� -> �����Ͻ� ������
		//System.out.println(acc.customer);
	
		//���¹�ȣ num������ �����ڰ� �ƹ��͵� ������� �ʾҴµ�
		//�̷��� ���������ڸ� default���������ڶ�� �ϰ� 
		//�츮�� default��� Ű���带 ����ؼ��� �ȵȴ�
		//default���������ڴ� ���� ��Ű���� �ִ� Ŭ���� ������ ������ ������ֹǷ�,
		//protected���� �Ѵܰ� �� ��ٷӴ� (��, ��Ӱ��迡 �־, ���� ��Ű���� �ƴ϶�� ���� �Ұ�)
		//System.out.println(acc.num);
		//error : num is not public in Account, cannot be accessed from outside package = �����Ǿ� ���� �����Ƿ� �ܺο��� ������ �Ұ����ϴ�
		//���ݱ��� �ǽ��ߴ� ��� Ŭ������ default����, �츮�� ���� ���丮����
		//�ǽ��� �߱� ������ ������ �ȳ��ͻ���, 
		//��Ű���� ����ϱ⶧���� ���������ڸ� �˾ƾ� ��

		//���� �ܾ� balance�� �׽�Ʈ�� ����
		//balance�� ���� ������ ������������ private�� ����Ǿ� �����Ƿ�,
		//AccountŬ���� �����θ� ������ �����ϴ�
		//���� �츮�� Account�ڽ��� �ƴ϶� ���� ������!! = �������
		//System.out.println(acc.balance);
		//error : balance has privae access in Account
		
		//acc.balance = 10;//�� ����� ���� �����̹Ƿ� �Ұ���
		acc.setBalance(10);//10������ ����, �޼��带 ���� �����ϹǷ� ����
		//�ܰ� ���� �Ϸ�, ������ �ܰ� Ȯ�� �����?..
		//�ܰ� ������ �ƴ϶� �ܰ� �����Ϸ��°� ���� �޼��带 ��������� ��
		//�ܰ�Ȯ�Ρ�
		System.out.println(acc.getBalance());
	
	
	}
}
