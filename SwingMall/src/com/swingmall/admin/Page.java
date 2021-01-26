//모든 페이지가 공통적으로 가져야할 속성, 메서드 등을 정의하기 위한 
//최상위 페이지 클래스
//따라서 Home, Product, Q&A, MyPage, Login등의 페이지들이
//이 클래스를 상속받는 경우, 코드르 ㄹ충복해서 작성하지 않아도 된다

package com.swingmall.admin;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Page extends JPanel{
	private AdminMain adminMain;
	
	
	//패키지가 달라서 get으로 
	public AdminMain getAdminMain() {
		return adminMain;
	}

	public void setAdminMain(AdminMain adminMain) {
		this.adminMain = adminMain;
	}

	public Page(AdminMain adminMain) {
		this.adminMain = adminMain;
		this.setPreferredSize(new Dimension(AdminMain.WIDTH,AdminMain.HEIGHT-100));
	}

}
