package day1102.event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowApp  extends JFrame{

	public WindowApp() {
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) {//â�� ���� ���α׷� ����ɶ�
				System.out.println("windowClosing");
				System.exit(0);//���μ��� ����
			}
		}
				
		);
		
		setSize(300,400);
		setVisible(true);
		setLocationRelativeTo(null);//�����
		
	}
	
	public static void main(String[] args) {
		new WindowApp();
	}


}
