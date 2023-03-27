package kr.ac.kopo.day15;

public class ExceptionMain05 {

	public static void main(String[] args) {

		
		System.out.println("===start===");
		try {
			String str = "hello";
			//String str = null;
			System.out.println("length :" + str.length());
			
			
			return; // 리턴의 경우 소프트웨어가 종료되기에 그 뒤에는 실행이 되지 않고 끝나야함
			        // 하지만 end 는 안나오지만 [finally]에 있는 코드는 무조건 실행이 됨.
			
			       // 그래서 보통 [finally]는 자원관리에 사용되곤 함
			
		} catch (Exception e) {
			System.out.println("예외발생!");
			e.printStackTrace();

		} finally {
			System.out.println("무조건 실행됩니다."); // 예외가 있던 없던 무시하고 무조건 실행!
		}
		System.out.println("===end===");
	}
}