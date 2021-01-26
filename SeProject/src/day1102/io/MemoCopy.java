/*
 * �����ֿ��� ��������(����)�� ���̳ʸ� ����(����) ���� �����غ��Ҵ�.
 * ������, ���������� ��� �ѱ��� ���� ������ � ����� �������� �׽�Ʈ�غ���!!
 * 
 * [ ��Ʈ���� ���� ] 
 * ��Ʈ���� �⺻�� 1byte�� ó���ϴ� ����Ʈ ����� ��Ʈ���̴�.
 * ������, ��Ʈ�������� �帣�� �����͸� ���ڷ� �ؼ��� �� �ִ� ��Ʈ���� ���ڱ�� ��Ʈ���̶�
 * �Ѵ�. ���ڱ�� ��Ʈ���� ���̾ ~Reader, ~Writer�� ������..
 * */
package day1102.io;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemoCopy{
	FileInputStream fis;
	FileOutputStream fos;
	
	FileReader reader; //������ ������� ��  ���ڱ���� �Է½�Ʈ�� 
	FileWriter writer; //������ ������� �� ���ڱ���� ��½�Ʈ��
	
	String path="D:/workspace/java/SeProject/res/data/test.txt";
	String path2="D:/workspace/java/SeProject/res/data/test2.txt";
	
	public MemoCopy() {
		try {
			//fis = new FileInputStream(path);
			//fos = new FileOutputStream(path2); //������½�Ʈ���� �������� �����ϴ� Ư¡�� �ִ� 
			reader = new FileReader(path);
			writer = new FileWriter(path2);
			
			//�� ����Ʈ�� �о���̸鼭 ������ �ѱ��� ��� �Ǵ��� �����غ���
			//���: FileInputStream �� ����Ʈ ����� ��Ʈ���̹Ƿ� 1byte�� �� �ؼ��� �� �ִ�.
			//���� �ѱ��� ��� 2byte�� �����Ǿ� �����Ƿ�, ����� �����ϰ�����, ��Ʈ���� ���� �帣�� �����͸�
			//�ѱ۷� ������ �Ҷ��� ������ ���ϼ� �ۿ� ����..
			int data;
			while(true) {
				data = reader.read();
				if(data==-1)break;
				System.out.println((char)data);
				writer.write(data);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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
		new MemoCopy();
	}

}
