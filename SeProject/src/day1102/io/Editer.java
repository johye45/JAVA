/*
 * ���� ������ ����, ������ ������ �ؽ�Ʈ ������ �����
 * �ѱ��� ���Ե� ���������� ������� �ϹǷ�, �翬�� ���ڱ�� ��Ʈ����
 * ����ϸ� ����
 * */
package day1102.io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;


public class Editer extends JFrame implements ActionListener{
	JMenuBar bar;
	JMenu menu;
	JMenuItem item_new, item_open,item_save,item_saveas;
	JTextArea area;
	JFileChooser chooser;
	FileReader reader;
	FileWriter writer;
	File selectedFile;//���� ���� ���� �ִ� ����
	
	BufferedReader buffr;
	BufferedWriter buffw;
	
	public Editer() {
		super("�ڹ� �޸���");
		
		bar = new JMenuBar();
		menu = new JMenu("����");
		item_new = new JMenuItem("������");
		item_open = new JMenuItem("����");
		item_save = new JMenuItem("����");
		item_saveas = new JMenuItem("�ٸ��̸����� ����");
		area = new JTextArea();
		chooser = new JFileChooser("D:/workspace/java/SeProject/res/data");
		
		//����
		setJMenuBar(bar);
		bar.add(menu);
		menu.add(item_new);
		menu.add(item_open);
		menu.add(item_save);
		menu.add(item_saveas);
		add(area);//���Ϳ� ����
		
		//�����۰� ������ ����
		item_new.addActionListener(this);
		item_open.addActionListener(this);
		item_save.addActionListener(this);
		item_saveas.addActionListener(this);
		
		
		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);//ȭ�� �����
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == item_new) {
			
		}else if(obj==item_open) {
//			JOptionPane.showMessageDialog(this,"������?");
			open();
		}else if(obj== item_save) {
			save();
		}else if(obj==item_saveas) {
			
		}
	}
	
	//���Ͽ���
	public void open() {
		//����Ž���� ����
		int result = chooser.showOpenDialog(this);
		System.out.println(result);//0�� ����, 1�� ���
		if(result == JFileChooser.APPROVE_OPTION){//����, ���� ��ư 
			//������ ���Ͽ� ��Ʈ���� �ɾƼ� �б� �۾� �õ�
			selectedFile = chooser.getSelectedFile();//������ �����κ��� ������ ���������� 
														//FileŬ������ ��ȯ �޴´�
		
			//�����쿡 �������� ���� �̸��� ���
			this.setTitle(selectedFile.getAbsolutePath());//��� ���
			
			try {
				reader = new FileReader(selectedFile);//������ ���Ͽ� ���� ��Ʈ�� ����
				//������ ��Ʈ������ ���� �����͸� �о�ͼ�, area�� �������
				buffr = new BufferedReader(reader);
				int data;
				String str = null;
				int count = 0;
				while(true) {
					str = buffr.readLine();
					count ++;
					System.out.println(count);
					if(str==null)break;//String�� ��ü�̹Ƿ�, �����Ͱ� �������� null�� ��ȯ
					//�⺻ �ڷ��� --> ��ü �ڷ��� ,Wrapper
//					area.append(Character.toString((char)data));	
					area.append(str+"\n");
				}
						 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(reader!=null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}	
	
	//�������� ���α׷����� �����͸� ���Ͽ� ����ؾ� ��(��½�Ʈ���� �ʿ���)
	public void save() {
		try {
			writer = new FileWriter(selectedFile);
//			buffw = new BufferedWriter(writer);//����ó���� ��Ʈ������ ���׷��̵�
			
			writer.write(area.getText());//textarea�� String�� ���Ͽ� ���
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer !=null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new Editer();
	}



}
