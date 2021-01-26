/*
���� ������Ʈ�� �÷����� ����, � ������� �÷� �������� �����ϴ� ����
��ġ�� �Ѵ�
AWT���� �����ϴ� ��ġ�� ������ ���� 5���� ������ �ִ�
1)FlowLayout : ��������� �þ�¹�ġ���, ���� ������ �����ϸ�
			   ���� ������ ��������. �����̳��� ũ�⿡ ���� �帣��
			   ��ġ�� �ǹǷ� flow��� ���� �ο� �Ǿ���
2) BorderLayout : ��,��,��,��,�߾� �̶�� ������ ���� ��ġ���
3) GridLayout : ���� �� �ٵ��� ����� ��ġ ���
4) CardLayout : ī��ó�� �ϳ��� ī�尡 ���϶��� �ٸ� ī�尡 �Ⱥ��̴�
                ����� ��ġ���
5) GirdBagLayout : GridLayout�� �ȼ������� ���ϰ� 
                   ������ �� �ִ� ��ġ���
��ǻ� 1,2,3�������ε� ����� ������ �����ϴ�

*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.BorderLayout;

class BorderTest{
	public static void main(String[] args){
		//Frame�����
		Frame frame = new Frame();

		//BorderLayout�н�
		Button bt_north=new Button("North");
		Button bt_south=new Button("South");
		Button bt_west=new Button("West");
		Button bt_east=new Button("East");
		Button bt_center=new Button("Center");

		//��ġ ����� ��������
		//1. BorderLayout����
		frame.setLayout(new BorderLayout());
	
		//��ư �����ӿ� ���̱�
		frame.add(bt_north,BorderLayout.NORTH);//NORTH(����)�� ����̹Ƿ� �빮��, ���ʿ� ��ư ����
		frame.add(bt_south,BorderLayout.SOUTH);
		frame.add(bt_west,BorderLayout.WEST);
		frame.add(bt_east,BorderLayout.EAST);

		//���ʹ� ������� �ʾƵ� ����Ʈ�̱� ������ �����ص� ����ȴ�
		frame.add(bt_center,BorderLayout.CENTER);

		//������ ����
		frame.setSize(250,200);
		frame.setVisible(true);
	
	}
}
