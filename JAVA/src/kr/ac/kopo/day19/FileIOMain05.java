package kr.ac.kopo.day19;

import java.io.FileReader;
import java.io.FileWriter;

// iotest/FiliIOMain02.java.txt == >  iotest/FiliIOMain02-1.java.txt 
public class FileIOMain05 {

	public static void main(String[] args) {
		
		
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("iotest/FileIOMain02.java.txt");
			fw = new FileWriter("iotest/FileIOMain02-1.java.txt");
			
			while(true) {
				int c = fr.read();
				if(c == -1) break;
				fw.write(c);
			}
			fw.flush();
			System.out.println("파일저장완료...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






