//모든 페이지가 공통적으로 가져야할 속성, 메서드 등을 정의하기 위한 
//최상위 페이지 클래스
//따라서 Home, Product, Q&A, MyPage, Login등의 페이지들이
//이 클래스를 상속받는 경우, 코드르 ㄹ충복해서 작성하지 않아도 된다

package com.swingmall.main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Page extends JPanel{
	ShopMain shopMain;
	

	public ShopMain getShopMain() {
		return shopMain;
	}

	public void setShopMain(ShopMain shopMain) {
		this.shopMain = shopMain;
	}

	public Page(ShopMain shopMain) {
		this.shopMain = shopMain;
		this.setPreferredSize(new Dimension(ShopMain.WIDTH,ShopMain.HEIGHT-100));
	}

}
