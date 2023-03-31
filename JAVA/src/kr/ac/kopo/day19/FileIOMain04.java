package kr.ac.kopo.day19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import kr.ac.kopo.util.FileClose;

public class FileIOMain04 {

	public static void write() {
		
		// dataIO.txt에 데이터 저장
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("iotest/dataIO.txt");
			dos = new DataOutputStream(fos);
			
			int a = 59;
			char b = 'M';
			int c = 109;
			double d = 12.34; 
			// 아스킥 코드와 유니코드의 차이 때문에 실수는 이렇게 이상한글자로 찍힘!
			//여기서 중요! 우리는 어떻게 문자가 보이냐가 중요하지 않은 , 저장하고 입력하는것이 중요함
			// 이건 그냥 코드가 어떻게 실행되는지에 대해 해보는 것
			
			dos.writeInt(a);
			dos.writeChar(b);
			dos.writeInt(c);
			dos.writeDouble(d);
			dos.flush();		
			
			System.out.println("저장완료...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(dos, fos);
		}
	}
	public static void read() {
		FileInputStream fis = null;
		DataInputStream dis = null ;
		
		try {
			
			fis = new FileInputStream("iotest/dataIO.txt");
			dis = new DataInputStream(fis);
			
			// 어떻게 저장했는지 형태를 알고있고 입력을 해야한다. 안그러면 이렇게 입력한 정보가 바뀜.
			int a = dis.readInt();
			char b = dis.readChar();
			int c = dis.readInt();
			double d = dis.readDouble();
			
			System.out.println("<읽어온 결과>");
			System.out.println("a : " + a);
			System.out.println("b : " + b);
			System.out.println("c : " + c);
			System.out.println("d : " + d);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(dis,fis);
		}
		
	}
	
	public static void main(String[] args) {
		
		read();
		//write();
		
	}
}