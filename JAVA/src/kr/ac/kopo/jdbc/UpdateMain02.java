package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import kr.ac.kopo.util.ConnectionFactory;

public class UpdateMain02 {//이건 다른 두번째 방법 1.7버전의 방법
	                       // 이런 finally close를 적을 필요가 없는 방법임

	public static void main(String[] args) {
		
		//쿼리를 넣기 위해 먼저 꼭 만들어줘야함!
		// try안에다가 적은면 오류가 난다 !!
        //왜냐하면 여기서는 ﻿오토클로즈업이라고 하는 인터페이스를 상속받은 것만 
        //이용해서만 사용할 수 있음!! String은 상속받지 않고 있음 그래서 try밖에다가 적어줘야함

		String sql  = "update t_test ";
	          sql += "   set name = ? ";
	         sql += " where id = ? ";
	try(
		Scanner sc = new Scanner(System.in);
		Connection conn = new ConnectionFactory().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
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
