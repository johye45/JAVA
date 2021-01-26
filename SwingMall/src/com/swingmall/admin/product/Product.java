package com.swingmall.admin.product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.swingmall.admin.AdminMain;
import com.swingmall.admin.Page;
import com.swingmall.util.db.DBManager;

public class Product extends Page{
	JPanel p_west;//tree올 영역
	JPanel p_center;
	JTree tree;
	JTable table;
	JScrollPane s1, s2;//tree, table용
	JButton bt_regist;//등록 버튼

	DBManager dbManager;
	ProductModel model;
	RegistForm registForm;
	
	ArrayList<String> topList;//최상위 카테고리 이름을 담게될 리스트 , top,down, accessary, shoes
	ArrayList<ArrayList> subList = new ArrayList<ArrayList>() ; //가디건, 니트 등 종루별로 담은 리스트를 담을 리스트, 하위 카테고리중 최상위 카테고리를의 하위카테고리 top에 등록된 것만,,
	
	
	public Product(AdminMain adminMain) {
		super(adminMain);
		//카테고리 가져오기
		getTopList();//상위카테고리 가져오기, 멤버변수인 topList에 최상위 카테고리가 채워진다!!
		for(String name : topList) {
			getSubList(name);
		}
		
		//노드 만들기
		//상품목록이라는 제목의 최상위 노드 생성하기
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("상품목록");
		for(int i=0; i<topList.size();i++) {
			top.add(getCreatedNode(topList.get(i),subList.get(i)));//top,down,accessary,shoes,//가디건,등
		}
			
		
		//생성
		p_west = new JPanel();
		p_center = new JPanel();
		tree = new JTree(top);//노드를 넣을 예정
		table = new JTable();
		s1 = new JScrollPane(tree);
		s2 = new JScrollPane(table);
		bt_regist = new JButton("상품 등록하기 ");

		//등록폼 생성
		registForm = new RegistForm(this);
		
		
		//스타일
		s1.setPreferredSize(new Dimension(200, AdminMain.HEIGHT-100));
		p_west.setBackground(Color.WHITE);
		s2.setPreferredSize(new Dimension(AdminMain.WIDTH-300, AdminMain.HEIGHT-200));
		
		
		//조립
		setLayout(new BorderLayout());
		
		p_west.add(s1);//서쪽 패널에 트리 스크롤부착
		p_center.add(s2); //센터패널에 테이블 스크롤부착
		p_center.add(bt_regist);//센터패널에 버튼부착
		
		add(p_west, BorderLayout.WEST);
		add(p_center);
		add(registForm);
		
		
		getProductList(null);//최초에는 전부 나오게
		
		//tree는 이벤트가 별도로 지원
		tree.addTreeSelectionListener((e)->{
			System.out.println("나 선택했어?");
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
			
			if(selectedNode.toString().equals("상품목록")) {
				getProductList(selectedNode.toString());//모든 상품 가져오기
			}else {
				getProductList(null);			}
		});
		
		bt_regist.addActionListener((e)->{
			addRemoveContent(p_center, registForm);
		});
	}

	//상위카테고리 가져오기
	public void getTopList() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from topcategory";
		
		try {
			pstmt =getAdminMain().getCon().prepareStatement(sql);//getAdminMain().getCon()이 ==con
			rs = pstmt.executeQuery();
			//배열은 유연하지 못하므로, ArrayList에 담자
			topList = new ArrayList();
			while(rs.next()) {
				topList.add(rs.getString("name"));//top,down,accessary,shoes를 담는다
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getAdminMain().getDbManager().close(pstmt,rs);
		}
	}
	
	//하위카테고리 가져오기
	public void getSubList(String name) {
		//topcategory에서 topcategory_id 를 가져올건데 이름을 추측해서 가져온다
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from subcategory where topcategory_id =(";
		sql+=" select topcategory_id from topcategory where name='"+name+"')";
		
		//System.out.println(sql);
		
		try {
			pstmt = getAdminMain().getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList list = new ArrayList();//상위 카테고리에 등록된 하위 카테ㅗ리
			while(rs.next()) {
				list.add(rs.getString("name"));//일차원 list에 담기
				
			}
			//모두 담겨지면, 2차원 리스트에 추가해 담자
			subList.add(list);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getAdminMain().getDbManager().close(pstmt, rs);
		}
	}
	
	//트리노드 생성하기
	public DefaultMutableTreeNode getCreatedNode(String parentName, ArrayList childName) {
		//상위 노드 생성하기 == 부모 노드 생성하기
		DefaultMutableTreeNode parent = new DefaultMutableTreeNode(parentName);//상위 카테고리 부모 이름 대입
		
		//넘겨받은 매개변수인 ArrayList만큼 반복하여 부모 노드에 자식 노드 부착
		for(int i = 0; i<childName.size();i++) {
			parent.add(new DefaultMutableTreeNode(childName.get(i)));//반복문으로 채워 넣기
		}
		return parent;
		
	}
	
	//상품 가져오기
	public void getProductList(String name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		
		//name값이 넘어오면 조건 쿼리실행 하고
		if(name == null) {//name의 변수가 안넘어 오면 모든 상품 가져오기
			sql = "select * from product";
		}else {
			sql="select * from product where subcategory_id=(select subcategory_id from subcategory where name='"+name+"')";

		}
		try {
			pstmt = getAdminMain().getCon().prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			
			
			//메타정보를 이용하여 ProductModel의 column ArrayList를 채우자
			ResultSetMetaData meta = rs.getMetaData();
			ArrayList<String> columnNames = new ArrayList<String>();
			
			for(int i =1; i<=meta.getColumnCount();i++) {
				String colName= meta.getColumnName(i);
				columnNames.add(colName);
			}
			//rs의 레코드를 ProductModel의 record ArrayList에 채우자
			ArrayList<ProductVO> productList = new ArrayList<ProductVO>();//productVO만 담을예정
			while(rs.next()) {
				ProductVO vo = new ProductVO();//비어있는 VO를 생성해서 rs의 값들을 채워넣기
				vo.setProduct_id(rs.getInt("product_id"));
				vo.setSubcategory_id(rs.getInt("subcategory_id"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setBrand(rs.getString("brand"));
				vo.setPrice(rs.getInt("price"));
				vo.setFilename(rs.getString("filename"));
				vo.setDetail(rs.getString("detail"));
				
				productList.add(vo);//방금생성하고 하나의 레코드가 채워진 vo를 ArrayList에 채우자
			}
			
			model = new ProductModel();
			model.column = columnNames;//컬럼정보 대입			
			model.record=productList;//레코드정보 대입
			table.setModel(model);//테이블에 방금생성한 모델 적용
			table.updateUI();//갱신
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getAdminMain().getDbManager().close(pstmt,rs);
		}
				
	}
	
	//보여질 컨턴트와 가려질 컨텐트를 제어하는 메서드
	public void addRemoveContent(Component removeObj, Component addObj) {
		this.remove(removeObj);//제거될
		this.add(addObj);//붙여질 
		((JPanel)addObj).updateUI();//다시 보여주기
	}
	
}
