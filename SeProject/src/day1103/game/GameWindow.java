package day1103.game;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GameWindow extends JFrame{
	
	GamePanel gamePanel;//���� ������ �׷��� �г�
	JMenuBar bar;
	JMenu control;
	JMenuItem item_start, item_pause,item_exit;
	
	
	public GameWindow() {
	
		gamePanel = new GamePanel();
		bar = new JMenuBar();
		control = new JMenu("���� ����");
		item_start = new JMenuItem("���� ����");		
		item_pause = new JMenuItem("��� ����");		
		item_exit = new JMenuItem("���� ����");		
		
		control.add(item_start);
		control.add(item_pause);
		control.add(item_exit);
		bar.add(control);
		setJMenuBar(bar);
		
		setLayout(new FlowLayout());
		add(gamePanel);
		
		pack();//������ �ȿ� �ִ� ���빰 ���� �پ��
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//������� ������ ����
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println("������?");
				gamePanel.movekey(e.getKeyCode());
			}
			public void keyReleased(KeyEvent e) {
				System.out.println("������?");
				gamePanel.stopkey(e.getKeyCode());
			}
		});
		
		
		//�޴��� ������ ����
		item_start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gamePanel.flag = true;
			}
		});
		item_pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gamePanel.flag=false;
			}
		});
		item_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(JOptionPane.showConfirmDialog(GameWindow.this, "������ �����ðڽ��ϱ�?")==JOptionPane.OK_OPTION) {
					gamePanel.flag=false;
					System.exit(0);//���μ��� ����					
				}
			}
		});
		
		
		
	}
	

	public static void main(String[] args) {
		new GameWindow();
	}


}
