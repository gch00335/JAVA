package kr.ac.kopo.day16;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*
 * LIST
 *  특징 ㅣ 중복이 가능하다, 순서가 있따
 *  구현 클래스 | 1) ArrayList 2) LinkedList
 * 
 * 메소드
 *  - add    : 데이터 삽입
 *  - get    : 특정위치의 데이터 조회
 *  - remove : 특정위치 또는 특정값을 가진 데이터 삭제 
 *  - clear  : 전체 데이터 삭제
 *  - Size   : 리스트의 전체원소 개수   
 *  - isEmpty  : 리스트가 비어있는지 여부 판단
 *  - contains : 특정데이터가 존재하는지 판단
 *  - addAll   : 다른 리스트의 원소들을 전체 추가
 *  - 
 * 
 */

public class ListMain {

	public static void main(String[] args) {
	
		 //List<String> list = new ArrayList<String>(); // <>안에는 참조자료형만 입력가능하다 . int이런거 불가
		 // 이 코드는 데이터에 입력한 문자를 추출하고 싶다는 뜻
		 List<String> list = new LinkedList<String>(); 
		 //이렇게 바뀌어도..돌아감..!!
		 
		 
		 System.out.println("list :" + list);
		 System.out.println("전체원소의 개수" + list.size());
		//System.out.println(list.toString());
		 
		 list.add("one");
		 list.add("two");
		 list.add("three");
		 list.add("four");
		 list.add("five");
		 
		 System.out.println("add() 후 전체원소의 개수 : " + list.size());
		 System.out.println("list :" + list);

		 System.out.println("0번지 에티어 : " + list.get(0));
		 System.out.println("0번지 삭제데이터 : " + list.remove(0)); 
		 //﻿ ( 삭제되는 경우 뒤에 있는것이 앞으로 이동함 )
		 System.out.println("list :" + list);
		
		 System.out.println("remove 후 0번지 에티어 : " + list.get(0));
	
		 
		 // 중간에 ten을 넣고 싶을 경우
		 // 이렇게 임의의 데이터를 써주지 않으면 맨뒤부터 적혀진다.
		 
		 list.add(2,"Ten");
		 System.out.println("list :" + list);
		 
		 System.out.println("<인덱스를 통한 전체 데이터 출력>");
		 for(int i = 0 ; i< list.size(); i ++) {
			 System.out.println(list.get(i));
		 }
		 
		 System.out.println("<1.5버전의 for문 전체 데이터 출력>");
		 for(String str : list){
			 System.out.println(str);
		 }
		System.out.println("three문자열 존재여부 판단 : "+ list.contains("three"));
		list.remove("three");
		System.out.println("three문자열 존재여부 판단 : "+ list.contains("three"));
		
		List<String> subList = new ArrayList<String>();
		subList.add("하나");		
		subList.add("둘");
		subList.add("셋");
		list.addAll(subList);
		System.out.println("addAll한 후 list : " + list);
		
		// 무조건 add 0번지에서 삽입하고 0 번지에서 삭제하면 ﻿스택(후입선출) 사용가능하다
		// 큐(선입선출)처럼 사용하려면 ... size-1 ..? 이해안갑..
	}

}
