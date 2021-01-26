package day1029.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;

//Collection Framework 전제 조건은 객체만을 대상으로 한다
//자바 언어에서는 객체를 모아서 처리할때 유용한 api를 지원하는데, 이api를 가리켜
//컬렉션 프레임웍이라 한다 그리고 java.util에서 지원한다
//컬렉션 프레임웍에서 지원하는 객체의 수는 상당히 많기는 하지만, 크게 모여진 모습에 따라서
//순서있는 유형 List : 배열과 거의 같다
				//자바의 배열과 차이가 있다면, 
				//배열 : 1.반드시 생성할때 크기를 명시해야 한다, 따라서 동적으로 늘어날 수 없다
				//2.자료형을 섞어 사용할 수 없다	
				// ex) int[] arr = new int[5] //오직 int형만 넣을 수 있다
				//리스트 : 크기가 자유롭다, 객체 자료형을 섞어서 넣을 수 있다
//순서없는 유형 Set
//key-value 의 유형 Map형
public class CollectionApp {

	public void showList() {
		//List형의 최상위 객체인 List는 인터페이스 이며, List로 기본적으로 가져야 할
		//추상 메서드가 명시되어 있다
		//Generic Type으로 선언하면, 컬렉션 프레임웍에 넣을 수 있는 자료형을 제한 할 수 있다
		ArrayList<JButton> list=new ArrayList<JButton>();//리스트 구조들은 배열과 거의 같다
		//js의 배열과 동일) 동작방식
		list.add(new JButton("첫 버튼"));
//		list.add("사과");
//		list.add("복숭아");
//		list.add("멜론");
		list.add(new JButton("마지막 버튼"));
		System.out.println("데이터 수는"+list.size());//배열은 length지만, 
		//컬렉션 프레임 웍은 모두 size()를 이용한다
		
		for(int i=0;i<list.size();i++) {
			JButton bt1 = list.get(i);//섞어서 들어가므로, 반환형은 예측할 수 없기 때문에 Object형이 반환 된다
			System.out.println(bt1.getText());
		}
		
		//리스트는 중복된 데이터를 허용할 까?
		//중복 여부는 따지지 않는다 == 허용함
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("apple");
		list2.add("apple");
		list2.add("apple");
		list2.add("apple");
		System.out.println("list2의 데이터 수는 "+list2.size());
	}
	public void showSet() {
		System.out.println("--------------------");
//		Set ss = new HashSet();
//		HashSet s2 = new HashSet();
		
		//HashSet은 중복을 허용하지 않음
		HashSet<String> set = new HashSet<String>();
		set.add("banana");
		set.add("banana");
		set.add("banana");
		set.add("banana");
		
		System.out.println("HashSet의 크기는"+set.size());
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("바나나");
		set2.add("포도");
		set2.add("블루베리");
		
		//반복문으로 모든 set2의데이터를 출력해보자
		//배열의 순서를 정할 수 있는것
		Iterator<String> it = set2.iterator();
		while(it.hasNext()) {
			String e = it.next();
			System.out.println(e);
			
			//System.out.println(it.next());//next() return해준다 엘리먼트를
			//next반환형이 String인 이유는 <String>으로 했기때문에
			//<String>안하면 Object로 반환
		}
	}
	public void showMap() {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("k1","장미");
		map.put("k2","튤립");
		map.put("k3","안개꽃");
		map.put("k3","할미꽃");
		//System.out.println("map의 길이는"+map.size());//key값을 중복허용 XX 따라서 대체되어 버린다
		//k3값이 할미꽃으로 바뀌게 됨
		
		//모든꽃 출력
		Set<String> keySet = map.keySet();//key만 추출
		//그리고 Set은 Iterator를 지원하므로key를 일렬로 늘어뜨리자
		Iterator keyIter = keySet.iterator();
		
		while(keyIter.hasNext()) {//true인 동안 키 값을 접근
			String key = (String)keyIter.next();
			String value = map.get(key);//맵의 데이터 중 해당 키와 일치하는 데이터 반환
			System.out.println(value);
			
		}
		
//		Iterator<String> keys = map.keySet().iterator();
//		while(keys.hasNext()) {
//			String key = keys.next();
//			System.out.println(String.format("키 :%s 값 :%s",key,map.get(key)));
//		}
		
		
		
	}
	public static void main(String[] args) {
		CollectionApp app = new CollectionApp();
		app.showList();
		app.showSet();
		app.showMap();

	}
}