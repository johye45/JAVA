package day1029.graphic.image;


import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class ImagePickerApp extends JFrame{
	
	JPanel p_north ;
	DetailPanel p_center;
	String dir = "D:/workspace/java/SeProject/res/travel2/";
	String[] path = {
			"aa.jpg",
			"ab.jpg",
			"ax.jpg",
			"bm.jpg",
			"et.jpg",
			"kg.jpg",
			"mx.jpg"
	};
	ThumbCanvas[] thumb = new ThumbCanvas[path.length];
	
	public ImagePickerApp() {
		p_north = new JPanel();
		p_center = new DetailPanel();
		
		//캔버스 생성 및 조립
		for(int i = 0; i<path.length;i++) {
			thumb[i] = new ThumbCanvas(p_center,(dir+path[i]));
			p_north.add(thumb[i]);
		}
		
		//패널을 프레임에 부착조립
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
		setSize(770,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new ImagePickerApp();
		
	}

}
