package day1103.thread;

import javax.swing.JProgressBar;

public class barThread extends Thread{
	int n=0;
	JProgressBar bar;
	int interval;
	//이 스레드를 이용하고자 하는 자는 바를 넘겨라
	public barThread(JProgressBar bar, int interval) {
		this.bar = bar;
		this.interval = interval;
	}
		
	public void run() {
		while(true) {
			n++;
			bar.setValue(n);
			try {
				Thread.sleep(interval);//non-runnalble 빠졌다가 0.5초 뒤 복귀
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
