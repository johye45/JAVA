package event;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Choice;

class MyWin extends Frame{
			//MyWin is a Frame
	Button bt;//MyWin has a bt
	TextField t;
	Choice ch; //html������ select�ڽ��� ����

	public MyWin(){
		//�ʱ�ȭ
		bt = new Button("�� ������");
		t = new TextField(15);
		ch = new Choice();
	
		this.setLayout(new FlowLayout());//��ư�� �ʹ� Ŀ�� �ٲ�

		//��ư�� �����쿡 ����
		this.add(bt);//�������� ����Ʈ�� BorderLayout�̹Ƿ�,���Ϳ����� ũ�� ��������
		this.add(t);
		this.add(ch);

		//ch�� itemä���
		ch.add("JAVA");
		ch.add("JSP");
		ch.add("Android");
		ch.add("Spring");
		ch.add("Mybatis");
		

		bt.addActionListener(new MyListener());//��ư�� ������ ����
		t.addKeyListener(new MyKey1());//�ؽ�Ʈ�ڽ��� ������ ����
		this.addMouseListener(new MyMouse());//�����Ӱ� ������ ����
		ch.addItemListener(new MyItem());//ch�� ����
		this.addWindowListener(new MyWindowListener());

	
		this.setSize(300,400);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new MyWin();
	}
}
