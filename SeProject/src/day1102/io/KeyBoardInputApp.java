/*
 * �Է½�Ʈ�� ó���� ���Ͽ� ���ѵ� ����� �ƴϴ�
 * �� �������� ���α׷����� �����Ͱ� �귯���´ٸ�, �� ��� ���� �Է½�Ʈ���̴�
 * ���� �� ���� ������ ������ ������� �����͸� �д� ���� �ƴ϶�, Ű���带 �������
 * �����͸� �о�� ����
 * ����) ���ϰ��� �޸� Ű������ ��Ʈ���� �ڹٿ��� ������ �� �ִ� ���� �ƴ϶�,
 * 		�̹�  OS�������� ��Ʈ���� �����ϹǷ�, �ڹٴ� ���� �̹� �����ϴ� ��Ʈ���� ������ ���̴�
 * */

package day1102.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardInputApp {
	public static void main(String[] args){
		//Ű���� �̹� �ý��������� �����ϹǷ�, �ڹ��� SystemŬ�����κ��� ����
		InputStream is = System.in;//ǥ�� �Է� ��Ʈ��(Ű����, ��Ÿ �Էµ����� ���� ��Ʈ��)
		InputStreamReader reader = new InputStreamReader(is);
	
		int data;
		try {
			while(true) {
				data = reader.read();//�� ����Ʈ �б�, read()�� Ư¡, �Է��� �Ϸ���� ������
				//���� ��� ���·� �ӹ��� ����
				//��, �Է��� �Ǿ�� read()�޼��� ������ ������ ���� �� �� �ִ�.
				System.out.print((char)data);				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println();//ǥ�� ��� ��Ʈ��

	}

}
