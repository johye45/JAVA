package com.swingmall.home;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.swingmall.admin.product.ProductVO;
import com.swingmall.product.ProductDetail;

public class ProductItem extends JPanel{
	JPanel p_can;
	JLabel la_brand;
	JLabel la_product_name;
	JLabel la_price;
	Image img;
	ProductVO vo;
	Home home;
	ProductDetail productDetail;
	
	public ProductItem(Home home, ProductVO vo, int width, int height) {
		this.home=home;
		this.vo=vo;
		try {
			URL url = new URL(vo.getFilename());
			img = ImageIO.read(url);//원본크기의 이미지가 오므로, 크기 조절이 필요하다 
			img=img.getScaledInstance(width, height/2, Image.SCALE_SMOOTH);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		p_can = new JPanel() {
			public void paint(Graphics g) {
				//g.setColor(Color.BLUE);
				//g.fillRect(0, 0, width, height/2);
				g.drawImage(img, 0, 0, p_can);
			}
		};
		la_brand = new JLabel(vo.getBrand());
		la_product_name = new JLabel(vo.getProduct_name());
		la_price = new JLabel(Integer.toString(vo.getPrice()));
		
		//스타일적용
		setPreferredSize(new Dimension(width, height));
		p_can.setPreferredSize(new Dimension(width, height/2));
		
		la_brand.setPreferredSize(new Dimension(width, (height/2)/4));
		la_product_name.setPreferredSize(new Dimension(width, (height/2)/4));
		la_price.setPreferredSize(new Dimension(width, (height/2)/4));
		
		add(p_can);
		add(la_brand);
		add(la_product_name);
		add(la_price);
		
		//현재 패널과 리스너와 연결 
//		this.addMouseListener(new MouseAdapter() {
//			public void mouseReleased(MouseEvent e) {
//				//System.out.println("이 상품 맘에 들어?"); 
//				//상세페이지 (패널) 보여주기
//				//Image image = img.getScaledInstance(350, 400, Image.SCALE_SMOOTH);
//				//productDetail = new ProductDetail(vo, image);
//				//home.getShopMain().addRemoveContent(home.p_content, productDetail.p_content);
//			}
//		});
	}
}
