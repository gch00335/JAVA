package kr.ac.kopo.day19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import kr.ac.kopo.util.FileClose;

public class FileIOMain02 {


	public static void main(String[] args) {
		// iotest/Koala.jpg 파일을 iotest/Koala2.jpg에 복사
                 // [ I    n  ]         [o  u  t]
		
		 //하드디스크에 파일이 없으면 오류가 날 수 있으니 예외처리를 하라는 오류! 그래서 try를 써주는 것임!
		
		
		// close로 닫아주기 위해서 try밖에다가 변수 선언!
		FileInputStream fis = null;
		FileOutputStream fos = null ;
		
		try {
			fis = new FileInputStream("iotest/Tulips.jpg"); 
			fos = new FileOutputStream("iotest/Tulips2.jpg");
			// 만들어준 Tulips2 0 바이트므로 Tulips크기와( 660 ) 같아질때까지 계속 돌게 된다 
			// 언제까지 돌지, 무한으로 돌지 모르기때문에
			//﻿* [EOF : 파일의 끝이라는 뜻으로 마지막에 '-1'을 넣어줌 . 그럼 다 읽었다는 것을 인식해서 복사하는 것을 멈춤] 라는 규칙이 있음!
			
			
			
			long start = System.currentTimeMillis();
			
			while(true){
			int c = fis.read(); // 오류가 뜨는 이유는 갑작스럽게 읽지 못할때가 발생할 수 도 있으니 이에 대비하라는 것 ! 그래서 두번째 catch를 적어줌
			if(c==-1) break ;
			fos.write(c);
			} // 하지만 완벽하게 복사가 된 것이 아닌 , 옮겨지는 것은 완료 되었으나 저장되기까지 완료가 안되고 멈춰서 완벽하게 복사가 안될 때가 있음
			  // 방금 전 사진처럼..!
			 // 이것을 적어주면 램의속도보다 느려서 복사가 완벽하게 안된 것을 [flush()]을 적어주면 완벽하게 복사가 됨!
			 // [flush()] 는 남은 것을 다 처리해! 라는 뜻 
			
			fos.flush();
			long end = System.currentTimeMillis();
			System.out.println("Koala2.jpg에 복사완료...");
			
			System.out.println("소요시간 : " + (end - start) / 1000. + "초");
			
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException io) {
			io.printStackTrace();
			
		} finally {
	
			FileClose.close(fis);
			FileClose.close(fos);
		}
	}
}

			
			/* Close 방법 1 
			 * 	if (fis != null) {
				try {
				fis.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
				}
				
			if(fos != null) {
				try {
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	}
}*/

