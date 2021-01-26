package day1029.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;

//Collection Framework ���� ������ ��ü���� ������� �Ѵ�
//�ڹ� ������ ��ü�� ��Ƽ� ó���Ҷ� ������ api�� �����ϴµ�, ��api�� ������
//�÷��� �����ӿ��̶� �Ѵ� �׸��� java.util���� �����Ѵ�
//�÷��� �����ӿ����� �����ϴ� ��ü�� ���� ����� ����� ������, ũ�� ���� ����� ����
//�����ִ� ���� List : �迭�� ���� ����
				//�ڹ��� �迭�� ���̰� �ִٸ�, 
				//�迭 : 1.�ݵ�� �����Ҷ� ũ�⸦ ����ؾ� �Ѵ�, ���� �������� �þ �� ����
				//2.�ڷ����� ���� ����� �� ����	
				// ex) int[] arr = new int[5] //���� int���� ���� �� �ִ�
				//����Ʈ : ũ�Ⱑ �����Ӵ�, ��ü �ڷ����� ��� ���� �� �ִ�
//�������� ���� Set
//key-value �� ���� Map��
public class CollectionApp {

	public void showList() {
		//List���� �ֻ��� ��ü�� List�� �������̽� �̸�, List�� �⺻������ ������ ��
		//�߻� �޼��尡 ��õǾ� �ִ�
		//Generic Type���� �����ϸ�, �÷��� �����ӿ��� ���� �� �ִ� �ڷ����� ���� �� �� �ִ�
		ArrayList<JButton> list=new ArrayList<JButton>();//����Ʈ �������� �迭�� ���� ����
		//js�� �迭�� ����) ���۹��
		list.add(new JButton("ù ��ư"));
//		list.add("���");
//		list.add("������");
//		list.add("���");
		list.add(new JButton("������ ��ư"));
		System.out.println("������ ����"+list.size());//�迭�� length����, 
		//�÷��� ������ ���� ��� size()�� �̿��Ѵ�
		
		for(int i=0;i<list.size();i++) {
			JButton bt1 = list.get(i);//��� ���Ƿ�, ��ȯ���� ������ �� ���� ������ Object���� ��ȯ �ȴ�
			System.out.println(bt1.getText());
		}
		
		//����Ʈ�� �ߺ��� �����͸� ����� ��?
		//�ߺ� ���δ� ������ �ʴ´� == �����
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("apple");
		list2.add("apple");
		list2.add("apple");
		list2.add("apple");
		System.out.println("list2�� ������ ���� "+list2.size());
	}
	public void showSet() {
		System.out.println("--------------------");
//		Set ss = new HashSet();
//		HashSet s2 = new HashSet();
		
		//HashSet�� �ߺ��� ������� ����
		HashSet<String> set = new HashSet<String>();
		set.add("banana");
		set.add("banana");
		set.add("banana");
		set.add("banana");
		
		System.out.println("HashSet�� ũ���"+set.size());
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("�ٳ���");
		set2.add("����");
		set2.add("��纣��");
		
		//�ݺ������� ��� set2�ǵ����͸� ����غ���
		//�迭�� ������ ���� �� �ִ°�
		Iterator<String> it = set2.iterator();
		while(it.hasNext()) {
			String e = it.next();
			System.out.println(e);
			
			//System.out.println(it.next());//next() return���ش� ������Ʈ��
			//next��ȯ���� String�� ������ <String>���� �߱⶧����
			//<String>���ϸ� Object�� ��ȯ
		}
	}
	public void showMap() {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("k1","���");
		map.put("k2","ƫ��");
		map.put("k3","�Ȱ���");
		map.put("k3","�ҹ̲�");
		//System.out.println("map�� ���̴�"+map.size());//key���� �ߺ���� XX ���� ��ü�Ǿ� ������
		//k3���� �ҹ̲����� �ٲ�� ��
		
		//���� ���
		Set<String> keySet = map.keySet();//key�� ����
		//�׸��� Set�� Iterator�� �����ϹǷ�key�� �Ϸķ� �þ�߸���
		Iterator keyIter = keySet.iterator();
		
		while(keyIter.hasNext()) {//true�� ���� Ű ���� ����
			String key = (String)keyIter.next();
			String value = map.get(key);//���� ������ �� �ش� Ű�� ��ġ�ϴ� ������ ��ȯ
			System.out.println(value);
			
		}
		
//		Iterator<String> keys = map.keySet().iterator();
//		while(keys.hasNext()) {
//			String key = keys.next();
//			System.out.println(String.format("Ű :%s �� :%s",key,map.get(key)));
//		}
		
		
		
	}
	public static void main(String[] args) {
		CollectionApp app = new CollectionApp();
		app.showList();
		app.showSet();
		app.showMap();

	}
}