package kr.ac.kopo.day16;
import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 기본자료형              참조자료형 (대문자로 쓰임)
 * boolean               Boolean
 * char                  Character  
 * byte                  Byte
 * short                 Short
 * long                  Long
 * int                   Integer
 * float                 Float
 * double                Double
 * 
 * 
 * 
 */
public class WrapperMain {

	public static void main(String[] args) {
	
		int i =12;
		System.out.println("i : " + i);
		
		Integer i2 = new Integer(12);
		
		System.out.println("i2 :"  + i2);

	
		
		             // Q. 기본자료형과 참조자료형은 같이 가지게 할 수가 없어야 하지만, 
		            // 지금보면 에러가 나지 않고 있다. 왜그럴까?
	
		int i3 =i2;  // <= 이것은 auto unboxing 이라고 함 (말하지 않아도 자동으로 이루어지는 것)
		
		Integer i4 = i;
                    // A.  Integer가 내부적으로 박스를 하나 만들어서 private타입을 넣어주는 것 
		            // 그래서 이러한 상황을 (auto boxing) 오토박싱이라고 함
		
		List<Integer>list = new ArrayList<Integer>();
		
		list.add(new Integer(100));
		list.add(20); // 위에처럼 생성자의 내용없이 바로 이렇게 적어도 가능하다.
		
		
	}

}
