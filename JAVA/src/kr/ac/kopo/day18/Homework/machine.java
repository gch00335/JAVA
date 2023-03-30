package kr.ac.kopo.day18.Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class machine {


		public static void main(String[] args) {
			
			List<Member> members = new ArrayList<>();
			Member m1 = new Member("aaa", "111");
			Member m2 = new Member("bbb", "222");
			Member m3 = new Member("ccc", "333");
			Member m4 = new Member("ddd", "444");

			System.out.println("===비밀번호 변경 서비스===");
			System.out.println("아이디를 입력하세요");
			
			Scanner sc = new Scanner(System.in);
			String id = sc.nextLine();
			
			// 아이디가 다른지 안다른지 확인해봐야함
			// 오늘 배운 hash를 써볼래..저
		
		   
			

			if(m1.getID().equals(id)) {
				System.out.println("현재 패스워드를 입력하세요 : ");
				String pw = sc.nextLine();
				if(!m1.getP().equals(pw)) {
					System.out.println("입력하신 패스워드가 올바르지 않습니다"); 
					System.out.println("서비스를 종료합니다.");
					System.exit(0);	
				} else  {
					System.out.print("변경할 새로운 패스워드를 입력하세요 : ");
					String newPassword = sc.nextLine();
					m1.Setp(newPassword);
					System.out.println("패스워드 변경이 완료되었습니다");
				
				}
			
				
			} else if(m2.getID().equals(id)) {
				System.out.println("현재 패스워드를 입력하세요 : ");
				String pw = sc.nextLine();
				if(!m2.getP().equals(pw)) {
					System.out.println("입력하신 패스워드가 올바르지 않습니다"); 
					System.out.println("서비스를 종료합니다.");
					System.exit(0);	
				} else  {
					System.out.print("변경할 새로운 패스워드를 입력하세요 : ");
					String newPassword = sc.nextLine();
					m2.Setp(newPassword);
					System.out.println("패스워드 변경이 완료되었습니다");
				
				}
			
			} else	if(m3.getID().equals(id)) {
				System.out.println("현재 패스워드를 입력하세요 : ");
				String pw = sc.nextLine();
				if(!m3.getP().equals(pw)) {
					System.out.println("입력하신 패스워드가 올바르지 않습니다"); 
					System.out.println("서비스를 종료합니다.");
					System.exit(0);	
				} else  {
					System.out.print("변경할 새로운 패스워드를 입력하세요 : ");
					String newPassword = sc.nextLine();
					m3.Setp(newPassword);
					System.out.println("패스워드 변경이 완료되었습니다");
				
				}
			
			} else if(m4.getID().equals(id)) {
				System.out.println("현재 패스워드를 입력하세요 : ");
				String pw = sc.nextLine();
				if(!m4.getP().equals(pw)) {
					System.out.println("입력하신 패스워드가 올바르지 않습니다"); 
					System.out.println("서비스를 종료합니다.");
					System.exit(0);	
				} else  {
					System.out.print("변경할 새로운 패스워드를 입력하세요 : ");
					String newPassword = sc.nextLine();
					m4.Setp(newPassword);
					System.out.println("패스워드 변경이 완료되었습니다");
				
				}
			
				System.out.println("입력하신 아이디는 존재하지 않습니다.");
				System.out.println("서비스를 종료합니다.");
				
			}
			System.out.println();
			System.out.println("<전체 회원 목록>");
			System.out.println("=====================");
			System.out.println("아이디 \t 패스워드");
			System.out.println("=====================");
			System.out.println(m1.getID() + "\t" + m1.getP());
			System.out.println(m2.getID() + "\t" + m2.getP());
			System.out.println(m3.getID() + "\t" + m3.getP());
			System.out.println(m4.getID() + "\t" + m4.getP());



			
		}

}


