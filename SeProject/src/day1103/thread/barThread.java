package day1103.thread;

import javax.swing.JProgressBar;

public class barThread extends Thread{
	int n=0;
	JProgressBar bar;
	int interval;
	//�� �����带 �̿��ϰ��� �ϴ� �ڴ� �ٸ� �Ѱܶ�
	public barThread(JProgressBar bar, int interval) {
		this.bar = bar;
		this.interval = interval;
	}
		
	public void run() {
		while(true) {
			n++;
			bar.setValue(n);
			try {
				Thread.sleep(interval);//non-runnalble �����ٰ� 0.5�� �� ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
