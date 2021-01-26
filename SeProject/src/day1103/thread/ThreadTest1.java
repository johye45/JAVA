/*
 * �������? Thread
 * - �ϳ��� ���μ��� ������ �񵿱������� ������ �� �ִ� ���ϳ��� ���� ���� ������ ���Ѵ�
 * */

package day1103.thread;

public class ThreadTest1 {
	

	public static void main(String[] args) {
		//�ð� ����������ϰ� ���� ���Ѻ���
		TimeThread tt = new TimeThread();
		tt.start();//runnable���·� ����
		
		//0.5�� ���� ���� ����ϴ� �����带 �����ϵ�, ���� Ŭ���������� ��������(�����͸�Ŭ����)
		Thread startThread = new Thread() {
			public void run() {
				while(true) {
					System.out.println("��");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			
			}
		};
		startThread.start();//Runnable���·� ����
		
//		//�����ڰ� ������ �����带 �̿��ؼ� ���ѷ��� ����
//		MyThread t1 = new MyThread();//�н� ����
//		t1.start();//�������� ������ �ý��ۿ� �ðܾ� �Ѵ�
//		//�����尡 ������ run�޼���� jvm�� ���� ȣ��ȴ� 
//		
//		while(true){
//			System.out.println("hi");
//		}
	
	
	}

}
