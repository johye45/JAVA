package event;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

/*������ â�� ������� �߻��� �� �ִ� �̺�Ʈ��
�����ϴ� ������ �����ϱ�*/
public class MyWindowListener implements WindowListener{

	public void windowActivated(WindowEvent e){
		System.out.println("windowActivated...");
		//���� â�� Ȱ��ȭ ��ų�� (��, Ŀ���� ���� â�� �ö�� ������϶�)
	}
	public void windowClosed(WindowEvent e){
		System.out.println("windowClosed...");
		//â�� ������
	}
	public void windowClosing(WindowEvent e){
		System.out.println("windowClosing...");
		//�ݱ� ��ư ������(â�� �������� ����)
	}
	public void windowDeactivated(WindowEvent e){
		System.out.println("windowDeactivated...");
		//������ȭ�� �ݴ� 
	}
	public void windowDeiconified(WindowEvent e){
		System.out.println("windowDeiconified...");
		
	}
	public void windowIconified(WindowEvent e){
		System.out.println("windowIconified...");
		//�ּ�ȭ ��ư�� ���� ������ȭ ��ų��
	}
	public void windowOpened(WindowEvent e){
		System.out.println("windowOpened...");
		//â�� �㶧
	}
}
