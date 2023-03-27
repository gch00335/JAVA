package kr.ac.kopo.day15;

import java.util.Random;

public class ExceptionMain02 {

	public static void main(String[] args) {
		System.out.println("===start===");
		
		Random r = new Random();
		int random = r.nextInt(3);
		
		try {
		System.out.println("random : " + random);
		System.out.println(10/random);
		
		String str = "hello";
		System.out.println(str.charAt(5)); // 여기서도 에러가 발생하게 될 경우 
		                                   // 아까처럼 end 까지 실행이 안되고 바로 에러처리가 됨 . 왜그럴까? 
		 
		                                   // catch에서 예외처리했던 것은 랜덤숫자에 관한 걸로 예외를 잡았을 뿐이지
		                                   // 글자에 대한 예외처리를 따로 잡아두지 않았기 때문에 에러가 나는 것!
		
		
		                                   // 그런데 왜 [printStackTrace()] 를 입력했을때처럼 자세하게 설명이 뜨는 걸까?
		                                   // 그 이유는 jvm에서 자동으로 원인을 찾아내어 보여주고 있기 때문!
		
		                                   // 43~45 줄 이렇게 적어주게 되면 ! 예외처리가 가능하게 된다/
		
		// 방법2
		
		} catch(ArithmeticException | StringIndexOutOfBoundsException e) { //   이렇게  [ || ]  or를 통해서도 한번에 만들 수 있다.!
			e.printStackTrace();
		}
		
		
		/* 방법1
		} catch (ArithmeticException ae) { // 발생되는 문제가 생기면 [ae]변수를 통해 해결해라
			System.out.println("예외발생!!");
			System.out.println(ae.getMessage()); // 문제의 원인에 대해 알려주는 코드! [ getMessage() ]
			ae.printStackTrace();                // 정확하게 에러가 난 부분을 찝어주는 코드 ! [printStackTrace()]
			
		} catch(StringIndexOutOfBoundsException se) {
			System.out.println("StringIndexOutOfBounds 예외발생");
			se.printStackTrace();
		} */
		
		System.out.println("===end==="); //에러가 발생되도 끝까지 실행이 됨! 
		                                 //이러한 것이 바로 에러의 안전장치!
		                                
	}

}
