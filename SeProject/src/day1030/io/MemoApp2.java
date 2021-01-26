package day1030.io;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//GUI �� �������� ��ü���� ���� �Ϲ� Ŭ����
public class MemoApp2 extends JFrame implements ActionListener{
	JMenuBar bar ;//�޴��� �÷����� ����
	JMenu m_file,m_edit,m_style,m_view,m_help;
	//��ü �ڷ����� �ڷ��� �̹Ƿ� �迭�� ����
	JMenuItem[] items;//m_file�� ���� �޴��� �� 8�� ������ �߰�
	String[] item_title = {"���θ����","�� â","����","���� ","�ٸ��̸����� ����","������ ����","�μ�","������"};
	JTextArea area;
	JScrollPane scroll;//area�� �ٿ��� ��ũ��
		
	public MemoApp2() {
		bar = new JMenuBar();//�� ����
		
		
		//�޴��� ����
		m_file = new JMenu("����");
		m_edit = new JMenu("����");
		m_style = new JMenu("����");
		m_view = new JMenu("����");
		m_help = new JMenu("����");
	
		//������ ����
		//�����ۿ� ������ ���� �ƴ� �������� �� �ڸ� Ȯ��
		//js�ʹ� �޸�, �ڹٿ����� �迭�� �ڷ����� �����Ǹ�, �ش� �ڷ����� ���� �� �ִ�
		items = new JMenuItem[item_title.length];
		for(int i= 0; i<items.length;i++) {
			items[i]= new JMenuItem(item_title[i]);//������ ����
			if(i==2) {
				items[i].addActionListener(this);
			}
			
			//5��° �����ϸ� ���м� �߰�
			if(i==5 || i==7){
				m_file.addSeparator();//���м� �߱�
			}
			
			
			//���� �޴��� ������ ����
			m_file.add(items[i]);
		}

	
		
		
		
		area = new JTextArea();
		scroll = new JScrollPane(area);//��ũ�� ��� ���� ������Ʈ�� ������ �Ű������� �ִ´�
		
		//�ٿ� �޴� ����
		bar.add(m_file);
		bar.add(m_edit);
		bar.add(m_style);
		bar.add(m_view);
		bar.add(m_help);
	
		//�ٴ� ���� Ư������ �ֱ� ������ ��ġ�����ڿ� ��� ���� ������ �������� ��� ������ �ٿ���
		this.setJMenuBar(bar);
		
		//�����ӿ� scroll ����(���� ���⿣ area�� �����ؾ� �� ��ó�� ��������, scroll�� area�� �����ϰ� �����Ƿ�
		//scroll �ٿ��� �Ѵ�
		add(scroll);
		
		//bar ��Ÿ�� ����
		bar.setBackground(Color.ORANGE);
		m_file.setForeground(Color.white);
		m_edit.setForeground(Color.white);
		m_style.setForeground(Color.white);
		m_view.setForeground(Color.white);
		m_help.setForeground(Color.white);
		
		//�޴��� ũ�� ����
		m_file.setPreferredSize(new Dimension(120,45));
		m_edit.setPreferredSize(new Dimension(120,45));
		m_style.setPreferredSize(new Dimension(120,45));
		m_view.setPreferredSize(new Dimension(120,45));
		m_help.setPreferredSize(new Dimension(120,45));
		
		//��Ÿ�� ����
		area.setBackground(Color.PINK);//area���� ����
		area.setFont(new Font("����",Font.BOLD|Font.ITALIC,20));
		area.setForeground(Color.gray);
		
		setSize(700,600);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	}
	public void file() {
		JFileChooser chooser = new JFileChooser();//���� ã����
		chooser.showOpenDialog(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		file();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MemoApp2();
	}

}
