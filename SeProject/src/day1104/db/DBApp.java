/*�����ͺ��̽� ���� ���� 
  
 1) ����̹� �ε� (�ڹٿ��� db�� ���������ִ� ���̺귯�� jar)  ex) node.js����  ���� ����� �ֵ�..
 2) ������ �õ�!!!
 3) ������ ���� 
 4) db������ ����� �� 
*/
package day1104.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBApp {
	public static void main(String[] args) {
		
		 
		try {
			//1) ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver"); //�ε��ϰ���� Ŭ���� ��θ� String���� ���
			System.out.println("����̹� �ε� ����");
			
			//2) ���� �õ� 
			String str="jdbc:oracle:thin:@localhost:1521:XE";//���� ���ڿ�..
			
			Connection con=null;
			//������ �����Ǹ�, con�� ��ȯ�ǹǷ�, ���� null�̸� ���ӽ���
			con=DriverManager.getConnection(str , "user1104", "user1104");
			if(con==null) {
				System.out.println("���ӽ��Ф̤�");
			}else {
				System.out.println("���Ӽ���");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("������ ����̹��� ã�� �� �����ϴ�");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}

