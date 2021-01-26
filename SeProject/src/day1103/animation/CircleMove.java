

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
	//���� �͸� Ŭ������ Ŭ������? O
	JPanel can;
	JButton bt;
	int x=0;
	int y=0;
	Thread thread;
	
	public CircleMove() {
		can = new JPanel() {//���� �͸� Ŭ������ Ŭ���� �̹Ƿ�, .class�� �����ϵ�
							//��Ī�� �����Ƿ� ���������� $���� ������ ���ϸ��� ���Եȴ�
			//�����͸�Ŭ���� ���� ����? .java�� ���� ������ �ʾƵ� �ȴ�
			//���߽ð��� ����ȴ�
			//�ܺ� Ŭ������ ����� ��ġ �ڱⲯó�� ����� �� �ִ�
			public void paint(Graphics g) {
				g.setColor(Color.yellow);//����Ʈ ������ �����
				g.fillRect(0, 0, 740, 640);//ä���� �簢��
				
				//���׸���
				g.setColor(Color.pink);//����Ʈ ���� �ٲٱ�
//				g.drawOval(100, 100, 50, 50); //������ �׷��� ��
				g.fillOval(x, y, 50, 50);//ä���� ��
			}
		};
		
		bt= new JButton("�����̱�");
		
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
		
		//��ư�� ������ ����
		bt.addActionListener(new ActionListener() { 
			
			public void actionPerformed(ActionEvent e) {
//				move();
//				can.repaint();
				
				thread.start();//�����带 runnable�� ���Խ�Ű��
			
			}
		});
		
		setSize(740,640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	public void move() {
		//���� ��ǥ�� �����Ѵ�
		x+=2;
		y+=2;
		
	}
	public static void main(String[] args) {
		new CircleMove();
	}

}
