package kr.ac.kopo.day19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

// iotest/FiliIOMain02.java.txt == >  iotest/FiliIOMain02-1.java.txt 
public class FileIOMain06 {

	public static void main(String[] args) {
		
		
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader br = null ;
		BufferedWriter bw = null ;

		try {
			fr = new FileReader("iotest/FileIOMain02.java.txt");
			fw = new FileWriter("iotest/FileIOMain02-1.java.txt");
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			while(true) {
				String data = br.readLine();
				if(data == null) break;
				bw.write(data);
				//엔터를 찍어주는 코드
				bw.newLine();
			}
			bw.flush();
			System.out.println("파일복사완료...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






