package kr.ac.kopo.day18;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * MAP : key, value쌍으로 이루어진 데이터 집합
 *       순서 X, KEY에 대한 중복 X
 * 
 * 구현클래스
 * - HashMap
 * - TreeMap
 * 
 * 
 * 메소드
 * - put(k,v)       : 데이터 입력
 * - get(k)         : Key 쌍에 해당 value 반환
 * - containsKey(k) : 해당 Key 존재여부 판단
 * - remove         : key에 해당되는 value 삭제
 * 
 */

public class MapMain01 {
	/*
	 * 비밀번호 변경서비스 구현
	 *   -  특정 아이디에 대한 패스워드 변경을 목적
	 *   - 중복 아이디가 존재 X
	 *   - 아이디 : key, 패스워드 : value
	 * 
	 */
	public static void main(String[] args) {
		
		
		
		Map <String,String> members  = new HashMap<String ,String>();
		members.put("aaa", "1111");
		members.put("bbb", "2222");
		members.put("ccc", "3333");
		members.put("ddd", "4444");
		
	//	System.out.println("전체 회원수 : " + members.size());

		Scanner sc = new Scanner(System.in);
		
		System.out.println("*** 비밀번호 변경서비스 ***");
		System.out.println("아이디를 입력하세요 : ");
		String id = sc.nextLine(); // 중복된 아이디가 었는지 , 있는지 확인이 필요!
		if(!members.containsKey(id)) { // 왜 계속 에러가 나지 했는데..! 같지 않으면 존재하지 않다고 종료해야해서
			                           //..낫을 붙여줘야함..!
			System.out.println("입력하신 [" + id + "]는 존재하지 않습니다.");
			System.out.println("서비스를 종료합니다.");
			System.exit(0);
		}
		//여기단계로 내려왔을 경우 IF를 만족하지 않고 내려왔다는 뜻이므로
		//else를 굳이 써주지않아도 된다.

		System.out.println("현재 패스워드를 입력하세요 : ");
		String password = sc.nextLine();

		if(!members.get(id).equals(password)) { // 계속 에러가 났던 이유..iF 옆에 '{' 을 안써서...
		System.out.println("입력하신 패스워드가 올바르지 않습니다"); 
		System.out.println("서비스를 종료합니다.");
		System.exit(0);	

	}

	System.out.print("변경할 새로운 패스워드를 입력하세요 : ");
	String newPassword = sc.nextLine();
	members.put(id, newPassword);
	System.out.println("패스워드 변경이 완료되었습니다");

	
	System.out.println("<전체 회원 목록>");
	System.out.println("=====================");
	System.out.println("아이디 \t 패스워드");
	System.out.println("=====================");
	
	
	Set<String>keys =members.keySet();
	for(String key : keys ) {
	System.out.println(key + "\t" + members.get(key));
	}
			
			
	/*Set<Map.Entry<String,String>> entrySet = members.entrySet();
	//map 에 들어있는 엔트리 값을 SET에 반환했다는 뜻
	//map.entry로 안쓰면 import로 map.entry가 써져버림..! 
	
	for(Entry<String, String> e : entrySet) {
		System.out.println(e.getKey()+"\t"+ e.getValue());
	
	}
	*/
	
	System.out.println("=====================");
	
}
	}


