package day1117.tree;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProductTree extends JFrame{
	JTree tree;
	JScrollPane scroll;
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:ORCL";
	String user="user1104";
	String password="user1104";
	Connection con;
	
	//배열만 있다면 트리 생성은 메서드가 알아서 해주는 코드
	String[] category = {"상의","하의","액세서리","신발"};// 상위 카테고리 배열
	String[][] product = {
			{"티셔츠","점퍼","니트","가디건"},	
			{"청바지","반바지","면바지","치마"},	
			{"귀걸이","목걸이","반지","팔찌"},	
			{"구두","운동화","스니커즈","샌들"}	
	};
	
	ArrayList<String> topCategory = new ArrayList<String>();//상위 카테고리
	ArrayList<ArrayList> subCategory = new ArrayList<ArrayList>();//하위 카테고리
	
public ProductTree() {

	connect();//연결
		//DB연동하여 배열들의 데이터를 실제DB 데이터로 가져오자
		getTopCategory();
		
		//서브카테고리 메서드를 상위 카테고리 수 만큼 호출하면서 2차원 ArrayList구조를 생성하자
		for(int i = 0; i<topCategory.size();i++) {
			String name = topCategory.get(i);//top,down,accessary,shoes
			ArrayList subList = (ArrayList)getSubCategory(name);			
	
			subCategory.add(subList);
		}
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("상품정보");
//		for(int i = 0; i<category.length;i++) {
//			top.add(getCreatedNode(category[i],product[i]));			
//		}
		for(int i = 0; i<topCategory.size();i++) {
			String name = topCategory.get(i);
			top.add(getCreatedNode(name,subCategory.get(i)));
		}
		
		tree= new JTree(top);
		scroll = new JScrollPane(tree);
		
		
		add(scroll);
		
		
		//연결 끊기
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				disConnect();
				System.exit(0);
			}
		});
		
		setSize(400,500);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	
	}
	
	//메서드를 호출하는 자가 , 배열을 넘기면 배열의 길이 만큼 노드를 구성하여 반환해줄 것임
	public DefaultMutableTreeNode getCreatedNode(String parentName, String[] childName) {//부모가 누군지, 자식은 누군지 넘기자
		DefaultMutableTreeNode parent = new DefaultMutableTreeNode(parentName);//부모 생성
		//자식의 수 만큼 노드 만들어 부모에 부착
		if(childName!=null) {//배열을 넘기지 않은 경우 
			for(int i =0; i<childName.length;i++) {
				parent.add(new DefaultMutableTreeNode(childName[i]));
			}			
		}
		
		return parent;
	}
	//위의 메서드는 배열을 처리하는 용이지만, 이 메서드는 이름은 같지만 List용으로 처리
	public DefaultMutableTreeNode getCreatedNode(String parentName, ArrayList childName) {//부모가 누군지, 자식은 누군지 넘기자
		DefaultMutableTreeNode parent = new DefaultMutableTreeNode(parentName);//부모 생성
		//자식의 수 만큼 노드 만들어 부모에 부착
		if(childName!=null) {//배열을 넘기지 않은 경우 
			for(int i =0; i<childName.size();i++) {
				parent.add(new DefaultMutableTreeNode(childName.get(i)));
			}			
		}
		
		return parent;
	}
	
	//db연동
	public void connect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			if(con==null) {
				JOptionPane.showMessageDialog(this, "접속 실패");
				System.exit(0);//종료
			}else {
				this.setTitle(user+"접속중");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//db연결 끊기
	public void disConnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//상위 카테고리 가져오기
	public void getTopCategory() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from topcategory";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//배열은 크기를 명시해야 한다 차라리 배열보다는 컬렉션 객체중 List계열 추런
			//rs의 커서를 왔다갔다하지 않아두 된다
			while(rs.next()) {
				topCategory.add(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//하위 카테고리 가져오기
	public List getSubCategory(String name) {//top.down,accessary,shoes
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList subList =  new ArrayList();
		String sql = "select * from subcategory where topcategory_id=(select topcategory_id from topcategory where name=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				subList.add(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}return subList;//호출하는 자가 하위 카테고리 목록을 가져갈수 있다
		
	}
	
	public static void main(String[] args) {
		new ProductTree();
	}

}
