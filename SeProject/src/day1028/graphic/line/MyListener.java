package day1028.graphic.line;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener{
	XCanvas can;//null
	
	//ĵ������ �ּҰ��� �Ѱܹ��� �޼����ʿ� �ϴ� , ��
	public MyListener(XCanvas can) {
		this.can =can;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		//LineMaker ĵ������ ���� �׸���,
		//LineMaker Ŭ������ JTextField�� ���� �̿��Ͽ� �׷���
		
		//XCanvas�� paint(); �Ұ���
		//paint()�޼���� �����ڰ� ���� ȣ���Ҽ��� ����, ȣ���ؼ��� �ȵȴ�
		//paint()�޼���� �׸��� �׷��� �غ� �Ǿ����� �ý���, �� JVM�� ���� ȣ��ȴ�
		//���� �����ڰ� ���ϴ� Ÿ�ӿ� �׸��� �����ϰ� �Ϸ���, paint()�޼��带 ���� ȣ���ؼ���
		//�ƴϵǰ� ������ ���� �ý��ۿ� ��û �ؾ� �Ѵ�  repaint() �ٽ� �׷�~~-> update()ȭ���� �����
		//-> paint()
		
		//ĵ������ ������ repaint()ȣ��
		can.repaint();
	}
}
