/*Stream�̶�? ���ǿ����� �帣�� ���ٱ⸦ �ǹ�
���꿡���� �帧�� ����� ���� �ƴ� ������ �̴�
but ���꿡���� �帧�� ���⿡ ���� ������ ���� �з�(������ �������� ���α׷�)

 * 1)�Է�(Input): �������� ���α׷����� �����Ͱ� �귯���� ��
 * 2)���(Output): �������� ���α׷����� �����Ͱ� �귯�����°�

 * �ڹٿ����� ����°� ���õ� ��Ű�� ���� java.io�̴�. ���⿡���� ����� ó���� ���� ������api�� ����
 * 

 ���ܶ� ? ���α׷��� ���� ���� �Ǿ��� �� ���� �������� ��Ȳ�� �ǹ��Ѵ�(����)
 ������ �߻��ϸ�? ���α׷��� ������ ���ᰡ �ǹ�����

 * */

package day1030.io;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;


public class FileReadApp {
	//������ ������� �����͸� �о���̴� FileInputStream�� �н��غ���
	FileInputStream fis;
	public FileReadApp(){
		File file = new File("D:/workspace/java/SeProject/res/data/memo.txt");
		
		//���û��� ������ ������� ��Ʈ������ ��������
		try{//�� ������ ������ �߻��� ���ɼ��� �ִ� �ڵ����� �Ͻ�
		fis = new FileInputStream(file);
		System.out.println("��Ʈ�� ���� �����Դϴ�");
		//sun�翡�� �̸�, ���ɼ� �ִ� ������ ��üȭ ���� ���� �� �� �ϳ�
		//���� ����ߴ� ������ �߻��ϸ� jvm�� ���� FileNotFoundException�ν��Ͻ��� 
		//�޸𸮿� �ö���� catch������ �μ��� �����Ͽ�
		//�����ڷ� �Ͽ��� ������ ���� ������ �м��� �� �ִ� ��ȸ�� �ִ°� 
		//���� ó���� ������ ������ ������ ������ �ִ�
		
		int data ;
		while(true)
			{
			data=fis.read();//1byte�о���̱�
			if(data==-1)break;//-1�̸� �ݺ��� ��������
			System.out.print((char)data);					
			}	
		}catch(FileNotFoundException e){//Ȥ�ó� ����ߴ� ������ �߻��Ѵٸ�, ������ �������� ����.
			//����δ� �� catch�� ���� �����϶�
			System.out.println("������ ������ ã�� �� �����ϴ�.");
			e.printStackTrace();//���ñ����� ������ ����϶�
		
		}catch(IOException e){
			System.out.println("������ ���� �� ����");
			e.printStackTrace();
		
		}finally {
			//�� ���� ����ΰ� try���� �����ϴ� catch���� �����ϴ�
			//������ ���ļ� ���� �� ������
			//�� ������ �ڿ��� �ݴ� �ڵ带 �ۼ��ؾ� �Ѵ�
			//�ַ� �����ͺ��̽��� �������, ��Ʈ�� ���� ����
			if(fis != null) {//�޸𸮿� �����Ҷ���
				//db,stream������ �ݵ�� null���θ� �������� ������ ����
				try {//ctrl + shift + z -> try/catch�����
					
					fis.close();//��Ʈ�� ����
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
