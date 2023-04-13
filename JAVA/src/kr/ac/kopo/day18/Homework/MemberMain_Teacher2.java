package kr.ac.kopo.day18.Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberMain_Teacher2 {
	public static void main(String[] args) {
		
		List<Member_Teacher2> members = new ArrayList<>();
		members.add(new Member_Teacher2("aaa","111"));
		members.add(new Member_Teacher2("bbb","222"));
		members.add(new Member_Teacher2("ccc","333"));
		members.add(new Member_Teacher2("ddd","444"));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("***비밀번호 변경서비스***");
		System.out.print("아이디를 입력 : ");
		String id= sc.nextLine();
		
		
		int idx = members.indexOf(new Member_Teacher2(id)); // 몇번째 위치에 있는지 물어보는 값 indexOf
		if(idx == -1) {
			System.out.println("입력하신 아이디["+id +"]는 존재하지 않습니다.");
			System.out.println("서비스를 종료합니다.");
			System.exit(0);
		}
		Member_Teacher2 mem = members.get(idx);
		
		System.out.println("패스워드를 입력하세요 :");
		String password= sc.nextLine();
		if(!mem.getPassword().equals(password)) {
			System.out.println("패스워드가 올바르지 않습니다.");
			System.out.println("서비스를 종료합니다.");
			System.exit(0);
		}
		System.out.println("변경할 패스워드를 입력하세요");
		password = sc.nextLine();
		mem.setPassword(password);
		System.out.println("패스워드 변경을 완료하였습니다.");
		
		System.out.println("---------------------");
		System.out.println("\t전체회원 정보 출력");
		System.out.println("---------------------");
		System.out.println("아이디\t패스워드");
		System.out.println("---------------------");
		for(Member_Teacher2 m : members) {
			System.out.println(m.getId()+"\t"+m.getPassword());
		}
		System.out.println("---------------------");
	}
	
}
