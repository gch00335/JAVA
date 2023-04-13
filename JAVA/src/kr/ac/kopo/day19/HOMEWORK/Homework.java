package kr.ac.kopo.day19.HOMEWORK;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Homework {

	private static DateFormat dateTime;
	private static String path;

	public static void main(String[] args) {
	/*문제
	 * ------------------------------------
	  IoTest
		   --------------------------------------
		      새폴더      <DIR>
		      오리        <DIR>
		      a.txt                        6bytes    2023-03-30 14:22:22
		   --------------------------------------
		   [c] 새폴더  [m] 하위디렉토리이동  [U] 상위디렉토리이동 ==> m
		   이동할 디렉토리  : 오리
		   --------------------------------------
		      IoTest\오리
		   --------------------------------------
		      새폴더      <DIR>
		      오리        <DIR>
		      a.txt                        6bytes    2023-03-30 14:22:22
		   --------------------------------------
		   [c] 새폴더  [m] 하위디렉토리이동  [U] 상위디렉토리이동  [R]이름변경==> m
		   */
		   
		 
		Scanner sc = new Scanner(System.in);
        SimpleDateFormat d= new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		
		File dirObj = new File("iotest");
		
		System.out.println("--------------------------------------");
		System.out.println("\t\t"+dirObj.getPath());
		System.out.println("--------------------------------------");
		File[] dataArr = dirObj.listFiles();
		for(File data : dataArr ) {
			System.out.println(data.getName() +"\t" + "<DIR>"+ "\n"+ data.length()+"byte"+
				            	"\t\t"+ d.format(new Date(data.lastModified())));

		}
		System.out.println("-----------------");
		System.out.println("[C]:새폴더  [M]:하위디렉토리이동 [U]상위디렉토리이동  [R] 이름변경 ==> m ");
	    
		
		
		String input = sc.nextLine();
	    switch(input) {
	    case "c" :
	    	System.out.println("[c] : 새폴더 생성을 선택하셨습니다.");
	    	System.out.println("생성할 폴더 이름을 작성하세요");
			String n = sc.nextLine();
			new File(n).mkdir();
			System.out.println("-----------------");
			System.out.println("[C]:새폴더  [M]:하위디렉토리이동 [U]상위디렉토리이동  [R] 이름변경 ==> m ");
			break;
	    case "m" :
	    	System.out.println("[m] : 하위디렉토리이동을 선택하셨습니다.");
	    	break;
	    case "U" :
	    	System.out.println("[U] : 상위디렉토리이동을 선택하셨습니다.");
	    	break;
	    case "R" :
	    	System.out.println("[R] : 상위디렉토리이동을 선택하셨습니다.");
	    	break;
	    default :
	    	System.out.println("시스템이 종료됩니다");
	    	System.exit(0);
	    
	    
	    }
	    
	    File dirObj1 = new File("iotest");
		
		System.out.println("--------------------------------------");
		System.out.println("\t\t"+dirObj1.getPath());
		System.out.println("--------------------------------------");
		File[] dataArr1 = dirObj1.listFiles();
		for(File data : dataArr1 ) {
			System.out.println(data.getName() +"\t" + "<DIR>"+ "\n"+ data.length()+"byte"+
				            	"\t\t"+ d.format(new Date(data.lastModified())));
	    
	}
}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

