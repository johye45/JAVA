/*
�����쿡 �� �� �ִ� ���� ������Ʈ �˾ƺ���
Ex)��ư, �ؽ�Ʈ�ʵ�, ���� �ڽ�, üũ�ڽ�, ���̽�, �̹���,textare...
*/
package gui;
import java.awt.Frame;//����Ϸ��� Ŭ������ ��ġ ���
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.Label;
import java.awt.Image;
import java.awt.Toolkit;

class App1{
	public static void main(String[] args){
		/*������ ����*/
		/*���� ó������ Ŭ������ ��������
		����,��ó0)����Ϸ��� Ŭ������ ���� � �������� �����Ǵ°����� �뵵 �ľ�
		����,��ó1)�ڹ��� ��� ��ü�� �ᱹ 3���� �����ۿ� ����
		������ó2) Ŭ������ ����� �����, ���� �޸𸮿� �ø��� ���� �˸�ȴ�
		1)�Ϲ�Ŭ���� : new �ϸ��(new���� ������ ���� api������ ����)
		2)�߻�Ŭ���� : new �Ұ��ϹǷ�, �ڽ��� �����ؼ�
		            new�ϰų� �̹� ������ �ν��Ͻ��� �̿��ϸ� ��(api��������)
		3)�������̽� : new�Ұ��� ,�ڽ��� �����ؼ�
		            new�ϰų� �̹� ������ �ν��Ͻ��� �̿��ϸ� ��(api��������)
		*/

		//ó�������� �Ϲ��̱� ������ new������ ���� �����ڸ� �����ؼ� �ƿ��ϸ��
		Frame frame = new Frame();//�ڹ� ���������α׷��ֿ����� ������!
		//�������� ����Ʈ�� ���� ������ �ʴ� ������, ���� ���̵��� �޼��� ȣ��
		frame.setVisible(true);//Window��ü�κ��� ��ӹ��� �޼���
		//�Ű������δ� ������ ��� �� �� �ִ�.

		//�������� �ʺ� ���̸� ������ �� �ִ� �޼���
		frame.setSize(300,400);//apiã�ƺ���

		//�����찡 �����Ǿ����Ƿ�, ������ �ȿ� ��ġ�� ���� ������Ʈ �÷����ƺ���
		//button(�Ϲ�, �߻�,,)
		Button bt = new Button("�� ��ư");


		//��ư�� �����ϱ� ����, ���̾ƿ� ��Ÿ���� �����ؾ� �ϴµ�,
		//���̾ƿ��� ���� ���Ŵϱ�
		//�ϴ� FlowLayout�� ����غ���
		FlowLayout flow = new FlowLayout();
		frame.setLayout(flow);

		//��ư�� �����쿡 ����
		frame.add(bt);//add�޼��忡 �Ű������� Component���̹Ƿ�,
		//button�� Component���ڽ��̱� ������ ���� �ڷ����� �ش��Ͽ�,
		//add()�μ��� �� �� �ִ�


		//html������ input type = "text"�� �ڹٿ����� TextField�� �Ѵ�
		TextField text = new TextField("ȸ������", 10);//10��ũ�� Ȯ��
		frame.add(text);
		//Checkbox
		Checkbox ch1 = new Checkbox("����");
		Checkbox ch2 = new Checkbox("����");
		Checkbox ch3 = new Checkbox("��ǻ��");
	    frame.add(ch1);
		frame.add(ch2);
		frame.add(ch3);
		//TextArea
		TextArea area = new TextArea(5,20);//5�� 20��
		frame.add(area);

		//�׳� �ؽ�Ʈ
		Label la = new Label("ȸ������ ����Դϴ�");
		frame.add(la);

		//�̹��� �ֱ�
		//Image�� �߻�Ŭ���� �̸�, �÷����� ������ ������� ���� �� �ִ�
		//�÷����� �°� ����������,ToolkitŬ�����κ��� �ڿ��� ��´�
		Toolkit kit=Toolkit.getDefaultToolkit();//static�޼���, 
		//���� Ŭ���������� ������ �� �ִ�.
		//��Ŷ�� �̹����� ���û��� ��η� ���� ���� �� �ִ�
		//��� ���� �������ô� ������os������ ����ϴ� ǥ���̹Ƿ�
		//���� �� �ڹ� �ҽ��� ���os���� ����Ƿ���, ��� �߸����� ��η� �����Ѵ�
		Image img=kit.getImage("D:/workspace/java/project1026/res/ball2.png");
		System.out.println("�̹��� �ּҰ���:"+img);

		//ȭ�鿡 ����ϴ� ������ �Ұ�,, �ֳ� ���ݱ��� html������
		//�̹����� ���ٿ��� Ȯ��������, �ڹٿ� ���� �Ϲ����� ������ �����
		//���α׷��� ������ ������(�����׸��� �۾�)�� �ؾ� �ϱ� �����̴�

	}
}
