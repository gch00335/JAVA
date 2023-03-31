package kr.ac.kopo.day19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import kr.ac.kopo.util.FileClose;

public class FileIOMain03 {
	// Koala.jpg -> Koala3.jpg 복사
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		BufferedInputStream bis = null ;
		FileOutputStream fos = null;
		BufferedOutputStream bos =  null ;
		try {
			//파일의 이름이 대소문자 차이가 없다(구별을 어차피 못함!)
		    fis = new FileInputStream("iotest/Tulips.jpg");
			bis = new BufferedInputStream(fis); // ctrl + 스페이스 누르면 자동완성됨! 기억해두면 좋은 팁!
		
			//[BufferedInputStream]  / [BufferedOutputStream]속도를 빠르게 해주기 위한 코드임
			// 아까는 4초였는데 , 지금은 0.04초로 줄어든것을 볼 수 있다! 
			// 이렇게 빠르게 해주기 때문에 대부분 많이 사용하는 코드임!
			
		 fos = new FileOutputStream("iotest/Tulips3.jpg");
		 bos = new BufferedOutputStream(fos);
			
			long start = System.currentTimeMillis();
			
			
			
			while(true) {
				int c = bis.read();
				if(c== -1) break;
				bos.write(c);
				
			}
			bos.flush();
			
			long end = System.currentTimeMillis();
			System.out.println("Tulips3.jpg 에 복사완료...");
			
			System.out.println("소요시간 : " + (end-start) / 1000. + "초");
			while(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	// Close 방법1
			FileClose.close(bis,fis);
			FileClose.close(bos,fos);
		}
	}
}
			
			
			
	// Close 방법2		
    //FileClose.close(bis);
	//FileClose.close(fis);
	//FileClose.close(bos);
	//FileClose.close(fos);
		
			
			
			
			
			/*Close 방법1
			 * if (bis != null) {
				try {
					bis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();

				}

			}
			if (bos != null) {
				try {
					bos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}*/