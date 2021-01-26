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
				URL url2 = new URL(url +"/empty.txt");//디렉토리  + 파일명
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
		//키보드로부터 입력받는 데이터를 파일로 저장해본다
		//키보드 스트림은 System으로부터 얻어와야 한다
		InputStream is = System.in;//바이트 기반
		
		InputStreamReader reader = new InputStreamReader(is);//문자기반 스트림으로 업그레이드
		BufferedReader buffr = new BufferedReader(reader);//버퍼기반의 문자 스트림으로 업그레이드
		
		//파일 출력스트림계열은 빈파일을 생성해준다
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

