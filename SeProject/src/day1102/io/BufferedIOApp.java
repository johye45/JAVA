/*
 * �������� ���α׷����� �����͸� �аų� ����, �� ����Ʈ, �� ���ھ� ������� �����ϸ�,
 * �����ͷ��� ������ �ʹ� ���� ������� �����ϰ� �ȴ� �ӵ�����
 * ��ġ Cmdâ�� ���� ó��ó�� �޸𸮻��� ���ۿ� �����͸� ���Ƴ���, ������ ������ ��������
 * �Է� �� ����� ó���ϸ� ���α׷� ������ ȿ������ �ش�ȭ��
 * ��Ʈ�� �� ���۸� �����ϴ� ��Ʈ���� �����ξ�� Buffered~~�� �ٴ´�\
 * 
 * �ǽ� ) Ű����� �Էµ� �����͸� �� �� �� �����ͼ� ȭ�鿡 ����غ���
 * */

package day1102.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedIOApp {

	public static void main(String[] args) {
		//keyboard�� ���� �� ��Ʈ���� �����ڰ� ���ϴ� Ÿ�ӿ� new�� �� �ִ�.
		//�ֳ� OS�� �̹� ���� ���Ƽ�, ���� �ڹٿ����� �ý������� ���� ���� �� �մ�
		
		//�Է½�Ʈ������ �ֻ���� �߻� Ŭ���� �̴�(Ű����, ��ĳ�� ����� �� ��Ʈ������ ���� �� �ִ�)
		InputStream is = System.in;
		
		//�ѱ��� ������ �ʵ��� ���ڱ������ ���׷��̵�
		InputStreamReader reader = new InputStreamReader(is);//����Ʈ����� ���ڱ�� ��Ʈ������ ����
		BufferedReader buffr = new BufferedReader(reader);//���� ó���� ���ڱ���� �Է½�Ʈ��
		
//		int data;
		String str= null;
		try {
			while(true) {//Ű����� ���� �����Ƿ� if(data==-1)break;���ص���
//				data = reader.read();
				str = buffr.readLine();
//				System.out.print((char)data);
				System.out.print(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}
}
