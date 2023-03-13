package kr.ac.kopo.day05;

public class LoopMain03 {

	public static void main(String[] args) {
		
		int cnt = 1;
		do{ // 조건문과 반복문의 위치를 바꾸는 것 
			// 무조건 한번은 실행할 때 'do-while'을 사용한단다. : 대표적인 예로는 '오류체크'
			// 'while'은 실행이 안될 때고 있음!
			System.out.println("hello");
			++cnt;
		} while(cnt <=5);
// 이렇게 while 중간에 오게 된다면 while옆에 ';' 세미클론을 붙여주면
// 윗블록과 한세트로 연결됬다는 걸로 알 수 있다.
		{
			
		}
	}
	
}
