package kr.ac.kopo.day20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

import kr.ac.kopo.util.FileClose;

public class FilmIoMain08 {
	public static void write() {
	//계속 실행이 안되었던 이유는
		//kr.ac.kopo.util에 있던 것을 수정안해서 그럼 ..! 수정완료해서 실행이됨
		// 저장되고 텍스트안에 우리가 적은 정보대로 뜬것을 확인할 수 있음
		
		
	UserInfo user = new UserInfo("홍길동",20,"010-1111-2222");
	//유저의 정보를 파일에 저장한 후에 읽어오게 하려고 함
	//여기서 유저의 정보가 홍길동일지 고길동일지 , 멤버변수가 몇개인지에 따라 달라질 수 있는데
	// 우리는 정보가 3개(홍길동, 20, 번호)가 있는 정보를 읽어오게 하고 싶다.
	// 그러면 문자stream에 저장을 해야한다.
	
	FileWriter fw = null;
	PrintWriter pw = null;
	try {
		fw = new FileWriter("iotest/userInfo.txt");
		pw = new PrintWriter(fw);
		
		pw.printf("%s#%d#%s\n",
				user.getName(), user.getAge(), user.getPhone());
		pw.flush();
		
		System.out.println("userInfo.txt에 저장완료...");
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		FileClose.close(pw, fw);
	}
	
}

public static void read() {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("iotest/userInfo.txt");
			br = new BufferedReader(fr);
			
			//굳이 저렇게 일일이 다 적지 않고, 간편하게 적어보는 방법을 해보자
			//저기서 '#'을 기준으로 잘라내면 되는 규칙을 발견할 수 있음
			
			String data = br.readLine();
			String[]dataArr = data.split("#");  // split : 잘라내기 기능!
			System.out.println(Arrays.toString(dataArr));
			
			String name = dataArr[0];
			int age = Integer.parseInt(dataArr[1]);
			String phone = dataArr[2];
			
			UserInfo user = new UserInfo(name, age , phone);
			
			System.out.println(user);
			
			//문자20을 정수20으로 변경시켜줘야한다! 
			//그럼 어떻게 변경을 시켜줄 수 있을까  
			/* int a = integer.valueof("23");
			 * int b = integer.parseint("23");
			 실제리턴값이 참조자료형에 들어있는 자료를 뽑아서 리턴시켜준 것 */
			
			//그런데 여기서 난 단순하게 저장하고 불러오고싶을 뿐인데.
		    //(객체를 단순히 불러오고 싶을 뿐인데) 너무 불편함. 그래서 간단한 방법이 없나 찾아보니
			//  ObjectInoutSTrem , ObjectOutStream.이 있음!
			/*  ObjectInoutSTrem -> readObject
			 *  ObjectOutStream-  > WirteObject
			 */
			
			// 이걸 이제활용해서 한번 만들어보겠음 .
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(br, fr);
		}
	}
	
	public static void main(String[] args) {
		
		read();
		//write();
		
	}
}


