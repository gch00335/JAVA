package kr.ac.kopo.day20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import kr.ac.kopo.util.FileClose;

public class FilIoMain09 {

/*인풋 : 나(렘, 자바)에 파일을 읽어와라 - 리드
아웃풋 : 외부저장장치(하드장치)에 파일을 저장해라 - 라이트
*/
	// 객체가 갖고 있는 정보를 바이트 스트림으로 쭉 줄 세워야하는데 이걸 [객체직렬화]라고 함
	// 이걸쓸 수 있는 방법은 [ implements Serializable  ]의 상속을 받으면 됨
	// 읽을때는 objectrear만 필요함!
	
		public static void write() {
			UserInfo user = new UserInfo("홍길동", 20, "010-1111-2222");
			
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			
			try {
				
				fos = new FileOutputStream("iotest/userInfo.dat");
				oos = new ObjectOutputStream(fos);
				
				oos.writeObject(user);
				oos.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				FileClose.close(oos,fos);
			}
		}
		public static void read() {
			
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			
			try {
				fis = new FileInputStream("iotest/userInfo.dat");
				ois = new ObjectInputStream(fis);
				
				UserInfo user = (UserInfo)ois.readObject();
					//아까랑 같이 객체를 그대로 들고오는 것. 이 뜻은 뭐냐!
					//이 타입이 정확히 뭔지 모르니까 무조건 다 싸잡아서 object로 묵시적형변환을 한것
					//날아가는 것은 유저info형이지만 ..! 명시적형변환을 한번 해줘야한다는 것..!
					
				System.out.println(user);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				FileClose.close(ois,fis);
			}
		}
		
		public static void main(String[] args) {
			
			read();
		//	write();
			
		}
	}
