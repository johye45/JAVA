//진행 상황을 직관적으로 알 수 있는 프로그래스바를 활용해보자

package day1103.thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class PrograssApp extends JFrame{
	JLabel la;
	JProgressBar bar1;
	JProgressBar bar2;
	JProgressBar bar3;
	barThread t1,t2,t3;
	Thread laThread;

	public PrograssApp() {
		la = new JLabel("0",SwingConstants.CENTER);
		bar1 = new JProgressBar();
		bar2 = new JProgressBar();
		bar3 = new JProgressBar();
	
		
//		barThread = new Thread() {
//			
//			public void run() {
//				while(true) {
//					n++;
//					setBarValue();
//					try {
//						Thread.sleep(50);//non-runnalble 빠졌다가 0.5초 뒤 복귀
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			} 
//		};
	
		//스타일
		la.setPreferredSize(new Dimension(500,150));
		la.setFont(new Font("Verdana",Font.BOLD|Font.ITALIC,90));
		bar1.setPreferredSize(new Dimension(500,70));
		bar2.setPreferredSize(new Dimension(500,70));
		bar3.setPreferredSize(new Dimension(500,70));
		
		setLayout(new FlowLayout());
		
		t1 = new barThread(bar1, 50);		
		t2 = new barThread(bar2, 100);		
		t3 = new barThread(bar3, 150);		
		
		t1.start();//스레드 동작
		t2.start();//스레드 동작
		t3.start();//스레드 동작
		
		add(la);
		add(bar1);
		add(bar2);
		add(bar3);
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	//바의 값 제어
//	public void setBarValue() {
//		bar.setValue(n);//20퍼센트
//	}
	
	public static void main(String[] args) {
		new PrograssApp();
	}

}
