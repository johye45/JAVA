package day1030.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
//	String ori="D:/workspace/java/SeProject/res/data/memomo.txt;//������ ��ġ
//	String dest="D:/workspace/java/SeProject/res/data/memomo_copy.txt";//����� ����� ��ġ
	String ori="D:/workspace/java/SeProject/res/travel2/aa.jpg";//������ ��ġ
	String dest="D:/workspace/java/SeProject/res/data/aa_copy.jpg";//����� ����� ��ġ
	FileOutputStream fos;//������ ������� �Է� ��Ʈ��
	FileInputStream fis;//������ ��������� ��� ��Ʈ��
	
	public FileCopy() {
		//�Ʒ��� �ڵ�� ������ ������ ����. �� ����� ������ ���� ���
		//������ ���鼭 ���α׷��� ����������� �� �ִ� ����� �ִ�. ���� sun������
		//�̷��� ����� ���� ó���� ����ó���� �����ϰ� �ִ�
		try {
			fis = new FileInputStream(ori);
			System.out.println("��Ʈ�� ���� ����");
			fos = new FileOutputStream(dest);//���� ��� ��Ʈ���� ������ ��η� ����ִ� ������ ��������
			
			//��Ʈ�� ������ ���� �Ǿ����Ƿ�, �����͸� �� ����Ʈ�� �о,�ٸ� ��� �ִ� ���Ͽ� ����غ���
			int data ;
			while(true)
			{
			data = fis.read();//1byte�о���̱�
			System.out.println(data);
			if(data==-1)break;//-1�̸� �ݺ��� ��������
			fos.write((char)data);					
			}	
			
		System.out.println("���簡 �Ϸ�Ǿ����ϴ�");
			
		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();//�����ڰ� ���� �м��� �ϱ� ���� ��³���
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
	public static void main(String[] args) {
		new FileCopy();

	}

}
