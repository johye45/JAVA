/*�����ʴ� �������̽��̱⶧����, �����ʸ� �����ϴ��ڴ� �ݵ��
 * �߻�޼��带 �������ؾ� �Ѵ�
 * ������ �����ʰ� ������ �߻�޼����� ���� �ʹ� ���� ���
 * ��������� �ʴ� ����ִ� �޼��带 �츮�� ������ Ŭ�������� �δ°���
 * ȿ�������� ���ϴ�
 * ���� sun������ �������� �޼��尡 3���̻��� ���,
 *  ������ �����ʸ� ������ ����Ͷ�� ��ü�� �������ش�
 *  ex)	WindowListener�� ������ Ŭ���� WindowAdapter
 *  	MouseListener�� ������ Ŭ���� MouseAdapter
 *  	KeyListener�� ������ Ŭ���� KeyAdapter
 *  */

package day1102.event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWinAdapter extends WindowAdapter{
	public void windowClosing(WindowEvent e) {//â�� ���� ���α׷� ����ɶ�
		System.out.println("windowClosing");
		System.exit(0);//���μ��� ����
	}
}
