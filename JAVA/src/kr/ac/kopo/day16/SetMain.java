package kr.ac.kopo.day16;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set ;

/*
 * set  : 순서 x, 중복 x
 * 구현클래스 
 *   1) HashSet
 *   2) TreeSet
 * 
 * apthem
 *  - add() : 데이터 삽입
 *  - contains() : 데이터 존재여부 판단
 *  - remove()   : 특정데이터 삭제 
 *  - clear()    : 전체 데이터 삭제
 *  - size()     : ﻿크기 반환
 *  - isEmpty()  : ﻿데이터가 존재하는지 체크
 *  
 *  
 *  Set 전체데이터 접근 방식
 *  1.  1.5버전의 for문을 이용해서 접근
 *  2.  toArray() 메소드 이용
 *  3.  Iterator 객체 이용 // 순환자라고도 함!
 *  
 * 
 */
public class SetMain {

	public static void main(String[] args) {
		
		Set<String> set  = new HashSet<>(); //이렇게 <> 안을 지워도 가넝
		set.add("one"); // 아까 에러가 났던 이유는 타입이 다르기 때문! 문자로 입력해야함! 
		System.out.println("add(two) : " + set.add("two"));  // 1)
		set.add("tree");
		set.add("four");
		set.add("five");
		System.out.println("add(two) : " + set.add("two")); //  2)
		// add로 two 추가하는데 성공하면 true 실패하면 false가 나오도록 확인해보기 하면
		// 첫번째는 추가가 가능하나, 두번째는 실패한 것을 볼 수 있다.
		
		
		set.add("two"); // 중복을 허용하지 않기 때문에 two가 두번 나오지 않는다.
		
		
		
		// Q ." two"가 존재하면 삭제하고, "삭제성공", 존재하지 않으면 "존재하지 않음"출력하게 만들어보는 코드
		
		// 방법 1  
		System.out.println(set.remove("two") ?  "삭제성공" : "존재하지 않음");
		System.out.println(set.remove("two") ?  "삭제성공" : "존재하지 않음");
		
		/*방법2
		 * if(set.contains("two")) {
		set.remove("two");
		System.out.println("\"two\"데이터 삭제성공 ");
		} else {
			System.out.println("\"two\"데이터 존재하지 않음 ");
		} */
		
		
		
		//System.out.println("remove(two) : " + set.remove("two")); // 이것도 위와 같은 이유!
		//System.out.println("remove(two) : " + set.remove("two"));
		
		System.out.println("set :" + set); // 입력한 방식과 순서가 다르게 조회됨! ( 대신 inorder,형식으로 조회)
		
		// two라는 데이터가 있는지 확인하기 위해서는 어떻게 해야할까?
		// -> set은 인덱스가 없어서 접근이 조금 어려울 수 있다.
		
		
		System.out.println("<1.5버전의 for문이용>");
		for(String data : set) {
			System.out.println(data);
		}
		
		System.out.println("<toArray() 메소드를 이용>");
		Object[] dataArr = set.toArray();
		for(int i=0 ; i < dataArr.length ; i++) {
			System.out.println(dataArr[i]+ ",길이(length) : " + ((String)dataArr[i]).length() );
			//data가 Object여서 불가넝!  Object에 접근해져있는 메소드만 접근 가능! // 그렇기에 형변환을 시켜줘야한다! => 명시적형변환!
		}
		/* Iterator 주요 메소드
		 * hasNext() : 다음 데이터 존재여부 판단
		 * Next() : 데이터 이동
		 * 
		 */
		System.out.println("<Iterator 메소드를 이용>");
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
			
		}
		
	}

}
