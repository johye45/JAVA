package day1029.collection;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CustonButton extends JButton implements ActionListener {
	public CustonButton() {
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setBackground(Color.LIGHT_GRAY);
	}
}
