package kr.ac.kopo.day15;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class ExceptionMain06 {
		
		public static void a () {
			System.out.println("a() 시작");
			
			try {
			//컴파일시점 예외처리, checked Exception - > 간접처리랑 연결이됨..
				FileReader fr = new FileReader("a.txt");
			}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		
			}
			
			System.out.println("a() 종료");
		}
		public static void b() throws Exception {
			
			System.out.println("b()시작...");
			String str = null ;
			System.out.println("length : " + str.length());
			System.out.println("b()종료...");
		}
		
		public static void main(String[] args) throws Exception { // 이렇게도 가능함!
			                                                      // 하지만 잘 안쓰는 방법

		//try {
			b();
	//	} catch (Exception e ) {
			a();
		//}
		}
			
}
