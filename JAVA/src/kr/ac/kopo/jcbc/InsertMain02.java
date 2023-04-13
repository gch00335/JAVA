package kr.ac.kopo.jcbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import kr.ac.kopo.util.JDBCClose;

public class InsertMain02 {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// 1단계
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2단계
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			
			conn = DriverManager.getConnection(url, user, password);
			
			// 3단계
			Scanner sc = new Scanner(System.in);
			
			System.out.print("삽입할 ID를 입력 : ");
			String id = sc.nextLine();
			
			System.out.print("삽입할 이름을 입력 : ");
			String name = sc.nextLine();
			
			String sql  = "insert into t_test(id, name) ";
			       sql += " values(\'" + id + "\',\' " + name +  "\')";
			       
			stmt = conn.createStatement();
			
			// 4단계
			int cnt = stmt.executeUpdate(sql);
			System.out.println("총 " + cnt + "개 행 삽입...");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 5단계
			JDBCClose.close(stmt, conn);
		}
	}
}



//이렇게 에러가 나야하는게 정상 , 왜냐하면 우리가 잘못 입력한게 있기 때문이다. 
//  '   ' 작은따옴표로 인해 계속 에러가 나는것 !
//    sql += " values(\'" + id + "\',\' " + name + ")"; 이렇게 넣어줘서 id부터 홍길동이름까지  ' '
// 작은 따음표가 나오게 해주면 인식이 될거다.