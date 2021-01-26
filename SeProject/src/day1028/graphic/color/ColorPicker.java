
package day1028.graphic.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorPicker extends JFrame implements ActionListener{
	
	//È¥ÀÚ ÇØº¸±â
	JPanel c_north ;
	JPanel c_red;
	JPanel c_orange;
	JPanel c_yellow;
	JPanel c_green;
	JPanel c_blue;
	JPanel c_navy;
	JPanel c_purple;
	JPanel p;
	
	public ColorPicker() {
		c_north=new JPanel();
		c_red=new JPanel();
		c_orange=new JPanel();
		c_yellow=new JPanel();
		c_green=new JPanel();
		c_blue=new JPanel();
		c_navy=new JPanel();
		c_purple=new JPanel();
		p=new JPanel();
		
		
		c_red.setBackground(Color.RED);
		c_orange.setBackground(Color.orange);
		c_yellow.setBackground(Color.yellow);
		c_green.setBackground(Color.green);
		c_blue.setBackground(Color.blue);
		c_navy.setBackground(Color.getColor("#000099"));
		c_purple.setBackground(Color.PINK);
		
		p.setBackground(Color.yellow);
		
		c_red.setPreferredSize(new Dimension(100,100));
		c_yellow.setPreferredSize(new Dimension(100,100));
		c_orange.setPreferredSize(new Dimension(100,100));
		c_green.setPreferredSize(new Dimension(100,100));
		c_blue.setPreferredSize(new Dimension(100,100));
		c_navy.setPreferredSize(new Dimension(100,100));
		c_purple.setPreferredSize(new Dimension(100,100));
		
		
		add(p);
		add(c_north,BorderLayout.NORTH);
		c_north.add(c_red);
		c_north.add(c_orange);
		c_north.add(c_yellow);
		c_north.add(c_green);
		c_north.add(c_blue);
		c_north.add(c_navy);
		c_north.add(c_purple);
		
		
		
		
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == c_red) {
			
		}else if(obj == c_orange) {
			p.setBackground(Color.red);
		}else if(obj == c_yellow) {
			
		}else if(obj == c_green) {
			
		}else if(obj == c_blue) {
			
		}else if(obj == c_navy) {
			
		}else if(obj == c_purple) {
			
		}
		
	}

	public static void main(String[] args) {
		new ColorPicker();
	}


}
