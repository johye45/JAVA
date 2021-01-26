package day1103.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class KeyBoardFileApp {	
	String dir;
	FileWriter writer;
	public KeyBoardFileApp() {
		URL url = this.getClass().getClassLoader().getResource("res");
		
			try {
				URL url2 = new URL(url +"/empty.txt");//���丮  + ���ϸ�
				URI uri = url2.toURI();
				System.out.println();
				writer = new FileWriter(new File(uri));
			}catch(MalformedInputException e1) {
				e1.printStackTrace();
			}
			catch (URISyntaxException e) {
				e.printStackTrace();
			}catch (IOException e1) {
			e1.printStackTrace();
			}
		
	}

public void saveFile() {
		//Ű����κ��� �Է¹޴� �����͸� ���Ϸ� �����غ���
		//Ű���� ��Ʈ���� System���κ��� ���;� �Ѵ�
		InputStream is = System.in;//����Ʈ ���
		
		InputStreamReader reader = new InputStreamReader(is);//���ڱ�� ��Ʈ������ ���׷��̵�
		BufferedReader buffr = new BufferedReader(reader);//���۱���� ���� ��Ʈ������ ���׷��̵�
		
		//���� ��½�Ʈ���迭�� �������� �������ش�
		//FileWriter writer = new FileWriter() ;
		
		
		String msg=null;
		
		try {
			msg = buffr.readLine();
			writer.write(msg);
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new KeyBoardFileApp().saveFile();
	}
}

