//�ʸ� ����� ������

package day1103.thread;

import java.util.Calendar;

public class TimeThread extends Thread{
	public void run() {
		while(true) {
			
			
			//����ð��� ���ؼ� 1�ʸ��� �����ؼ� ���
			Calendar cal=Calendar.getInstance();//�߻� Ŭ���� �̹Ƿ� ��ü �޼���� �ν��Ͻ� ����
			System.out.println(cal.get(Calendar.YEAR)+"��"
			+cal.get((Calendar.MONTH)+1)+"��"
			+cal.get(Calendar.DATE)+"��"
			+cal.get(Calendar.HOUR)+"��"
			+cal.get(Calendar.MINUTE)+"��"
			+cal.get(Calendar.SECOND)+"��");			
			try {
				Thread.sleep(1000);//1/1000���� ǥ�� ������
								   //1�� ���� non-runnable�� ���·� �ִٰ� �ٽ� �����϶�� ���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}
}
