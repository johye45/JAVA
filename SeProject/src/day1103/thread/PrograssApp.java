//���� ��Ȳ�� ���������� �� �� �ִ� ���α׷����ٸ� Ȱ���غ���

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
//						Thread.sleep(50);//non-runnalble �����ٰ� 0.5�� �� ����
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			} 
//		};
	
		//��Ÿ��
		la.setPreferredSize(new Dimension(500,150));
		la.setFont(new Font("Verdana",Font.BOLD|Font.ITALIC,90));
		bar1.setPreferredSize(new Dimension(500,70));
		bar2.setPreferredSize(new Dimension(500,70));
		bar3.setPreferredSize(new Dimension(500,70));
		
		setLayout(new FlowLayout());
		
		t1 = new barThread(bar1, 50);		
		t2 = new barThread(bar2, 100);		
		t3 = new barThread(bar3, 150);		
		
		t1.start();//������ ����
		t2.start();//������ ����
		t3.start();//������ ����
		
		add(la);
		add(bar1);
		add(bar2);
		add(bar3);
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	//���� �� ����
//	public void setBarValue() {
//		bar.setValue(n);//20�ۼ�Ʈ
//	}
	
	public static void main(String[] args) {
		new PrograssApp();
	}

}
