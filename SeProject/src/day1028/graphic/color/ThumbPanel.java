package day1028.graphic.color;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

//������ �г� �����ϱ�
public class ThumbPanel extends JPanel implements MouseListener{
	JPanel p_center;
	Color color;
	//�ʺ�, ����, ������ ���� �гη� �¾��
	public ThumbPanel(JPanel p_center,Color color) {
		this.p_center = p_center;
		this.color = color;
		this.setPreferredSize(new Dimension(100,100));//�� �г� ũ�� ���ϱ�
		this.setBackground(color);
		this.addMouseListener(this);//���� ������ ����
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("�� ������?");
		//center���� �г��� ������ ���� ���� �������� ��������
		p_center.setBackground(color);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
