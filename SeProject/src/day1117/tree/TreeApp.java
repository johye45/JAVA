//데이터간 구조화된 포함관계를 표현할때 흔히 사용되는 Tree를 배워보자 

package day1117.tree;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeApp extends JFrame{
	JTree tree1,tree2,tree3;
	JScrollPane scroll1,scroll2,scroll3;
	
	public TreeApp() {
		//트리에 보여질 노드를 구성해보자
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("상품");
	
		
		tree1 = new JTree(root);//여기에 노드를 생성자 인수로 넣어줄 예정임, 최상위 노드를 생성자의 인수로
		scroll1 = new JScrollPane(tree1);
		
		
		
		createNode(root);//반지, 목걸이, 귀걸이, 팔찌를 부착할 예정임 따라서 최상위 노드를 넘겨주겠음 
	
		add(scroll1);
	
		
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	
	}
	
	public void createNode(DefaultMutableTreeNode root) {
		//넘겨받은 탑 노드에 원하는 하위 노드를 생성하여 자식노드로 붙이자
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("악세서리");
		DefaultMutableTreeNode[] node = new DefaultMutableTreeNode[4];
		node[0] = new DefaultMutableTreeNode("반지");
		node[1] = new DefaultMutableTreeNode("목걸이");
		node[2] = new DefaultMutableTreeNode ("귀걸이");
		node[3] = new DefaultMutableTreeNode ("팔찌");
	
		DefaultMutableTreeNode top2 = new DefaultMutableTreeNode("신발");
		DefaultMutableTreeNode[] node2 = new DefaultMutableTreeNode[4];
		node2[0] = new DefaultMutableTreeNode("구두");
		node2[1] = new DefaultMutableTreeNode("운동화");
		node2[2] = new DefaultMutableTreeNode ("슬리퍼");
		node2[3] = new DefaultMutableTreeNode ("샌들");
	
		//생성된 노드를 top노드에 부착
		for(DefaultMutableTreeNode obj: node) {
			top.add(obj);	
			root.add(top);
		}
	
		for(DefaultMutableTreeNode obj2: node2) {
			top2.add(obj2);	
			root.add(top2);
		}
	}
	
	
	public static void main(String[] args) {
		new TreeApp();
	}
}
