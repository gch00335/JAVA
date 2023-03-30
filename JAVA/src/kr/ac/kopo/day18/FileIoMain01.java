package kr.ac.kopo.day18;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileIoMain01 {

	public static void main(String[] args) {
	
		//한글이 읽히도록 하는 코드 짜보기
		//아래와 다른점은 바로 한글도 읽히도록 설정했다는 것 
		
		System.out.println("문자를 입력하세요. ctrl+z 입력시 종료합니다");
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		
		
		while(true) {
			try {
				int c = isr.read();
				if(c== -1) {
					break;
				}
				System.out.print((char)c);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/*
		// 입력용위해 코드 작성하기
		System.out.println("문자를 입력하세요. ctrl+z 입력시 종료합니다");
		InputStream is = System.in;
		while(true) {
						
			try {
				int c = is.read();
				if(c == -1) {
					break;
				}
				System.out.print((char)c); //명시적형변환
			} catch (IOException e) {
				e.printStackTrace(); */
			}
		}
		
	
	

