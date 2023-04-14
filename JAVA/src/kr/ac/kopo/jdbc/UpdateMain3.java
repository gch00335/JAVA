package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import kr.ac.kopo.util.ConnectionFactory;

public class UpdateMain3 {//이건 다른 세번째방법

	public static void main(String[] args) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("update t_test ");
		sql.append("   set name = ? ");
		sql.append(" where id = ? ");
		try(
			Scanner sc = new Scanner(System.in);
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
				 //이렇게 오류가 나는 이유는 스트링형이여야 하는데 지금 쓰는것은 스트링 빌더형이기에 
				 // 오류가 나는것임
				 // 이럴때 [toString]을 쓰면 해결이 됨! = 문자로 바꾸어주는 것! 
		) {
			System.out.print("아이디를 입력 : ");
			String id = sc.nextLine();
			System.out.print("변경할 이름을 입력 : ");
			String name = sc.nextLine();
			
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			
			int cnt = pstmt.executeUpdate();
			if(cnt == 0) {
				System.out.println("해당 아이디가 존재하지 않습니다");
			} else {
				System.out.println("이름변경이 완료되었습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}