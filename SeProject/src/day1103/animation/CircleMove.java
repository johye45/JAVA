

package day1103.animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleMove extends JFrame{
	//내부 익명 클래스도 클래스다? O
	JPanel can;
	JButton bt;
	int x=0;
	int y=0;
	Thread thread;
	
	public CircleMove() {
		can = new JPanel() {//내부 익명 클래스도 클래스 이므로, .class로 존재하되
							//명칭이 없으므로 내부적으로 $순번 현태의 파일명을 갖게된다
			//내부익명클래스 사용시 장점? .java를 굳이 만들지 않아도 된다
			//개발시간이 단축된다
			//외부 클래스의 멤버를 마치 자기껏처럼 사용할 수 있다
			public void paint(Graphics g) {
				g.setColor(Color.yellow);//페인트 색상을 노란색
				g.fillRect(0, 0, 740, 640);//채워진 사각형
				
				//원그리기
				g.setColor(Color.pink);//페인트 색상 바꾸기
//				g.drawOval(100, 100, 50, 50); //선으로 그려진 원
				g.fillOval(x, y, 50, 50);//채워진 원
			}
		};
		
		bt= new JButton("움직이기");
		
		thread = new Thread() {
			public void run() {
				while(true) {
					move();
					can.repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		can.setPreferredSize(new Dimension(700,600));
		
		
		setLayout(new FlowLayout());
		add(bt);
		add(can);
		
		//버튼과 리스너 연결
		bt.addActionListener(new ActionListener() { 
			
			public void actionPerformed(ActionEvent e) {
//				move();
//				can.repaint();
				
				thread.start();//스레드를 runnable로 진입시키자
			
			}
		});
		
		setSize(740,640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	public void move() {
		//원의 좌표를 변경한다
		x+=2;
		y+=2;
		
	}
	public static void main(String[] args) {
		new CircleMove();
	}

}
