/*Stream이란? 현실에서는 흐르는 물줄기를 의미
전산에서는 흐름의 대상이 물이 아닌 데이터 이다
but 전산에서는 흐름의 방향에 따라 다음과 같이 분류(기준은 실행중인 프로그램)

 * 1)입력(Input): 실행중인 프로그램으로 데이터가 흘러들어가는 것
 * 2)출력(Output): 실행중인 프로그램으로 데이터가 흘러나가는것

 * 자바에서는 입출력과 관련된 패키지 명이 java.io이다. 여기에서는 입출력 처리를 위한 수많은api를 지원
 * 

 예외란 ? 프로그램이 정상 실행 되어질 수 없는 예외적인 상황을 의미한다(에러)
 에러가 발생하면? 프로그램이 비정상 종료가 되버린다

 * */

package day1030.io;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;


public class FileReadApp {
	//파일을 대상으로 데이터를 읽어들이는 FileInputStream을 학습해본다
	FileInputStream fis;
	public FileReadApp(){
		File file = new File("D:/workspace/java/SeProject/res/data/memo.txt");
		
		//로컬상의 파일을 대상으로 스트림관을 생성하자
		try{//이 영역은 에러가 발생할 가능성이 있는 코드임을 암시
		fis = new FileInputStream(file);
		System.out.println("스트림 생성 성공입니다");
		//sun사에서 미리, 가능성 있는 에러를 객체화 시켜 놓은 것 중 하나
		//만일 우려했던 에러가 발생하면 jvm에 의해 FileNotFoundException인스턴스가 
		//메모리에 올라오고 catch문으로 인수를 전달하여
		//개발자로 하여금 에러에 대한 정보를 분석할 수 있는 기회를 주는것 
		//예외 처리의 목적은 비정상 종료의 방지에 있다
		
		int data ;
		while(true)
			{
			data=fis.read();//1byte읽어들이기
			if(data==-1)break;//-1이면 반복문 빠져나옴
			System.out.print((char)data);					
			}	
		}catch(FileNotFoundException e){//혹시나 우려했던 에러가 발생한다면, 비정상 종료하지 말고.
			//실행부는 이 catch문 블럭을 수행하라
			System.out.println("지정한 파일을 찾을 수 없습니다.");
			e.printStackTrace();//스택구조로 에러를 출력하라
		
		}catch(IOException e){
			System.out.println("파일을 읽을 수 없다");
			e.printStackTrace();
		
		}finally {
			//이 영역 실행부가 try문을 수행하던 catch문을 수행하던
			//무조건 거쳐서 가야 될 영역임
			//이 영역에 자원을 닫는 코드를 작성해야 한다
			//주로 데이터베이스와 연결끊기, 스트림 연결 끊기
			if(fis != null) {//메모리에 존재할때만
				//db,stream닫을때 반드시 null여부를 따져보는 습관을 갖자
				try {//ctrl + shift + z -> try/catch단축기
					
					fis.close();//스트림 닫음
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
			
	}
	public static void main(String[] args) {
		new FileReadApp();

	}

}
