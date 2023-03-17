package kr.ac.kopo.day08.Homework;

import java.util.Scanner;

public class Homework02 {

	public static void main(String[] args) {
		/*Student 클래스를 생성하여 15일차 숙제의 3번과 같은 
		 * 결과를 보이는 프로그램을 작성해오세요  -- 배열문제
		 *  //학생 하나를 객체로 봐라...??아?
		 *  
	
		 */
		
		
	Scanner sc = new Scanner(System.in);
	
	Student stu1 = new Student();
	Student stu2 = new Student();
	Student stu3 = new Student();
	Student stu4 = new Student();
	Student stu5 = new Student();
	
	Student[]StuArr = {stu1,stu2,stu3,stu4,stu5};
	

	for (int i = 0; i < StuArr.length; i++) { // 성적 입력하는 구간 출력
		System.out.println((i+1));
		StuArr[i].number = (i+1);
		StuArr[i].score = sc.nextInt();
	}
	System.out.println();
	System.out.println("번호 " + "성적 " + "학점 " + "\n"); // 번호 성적 학점 구간 출력!

	int error = 0; 
	int sum = 0; 
	

	for (int i = 0; i < StuArr.length; i++) {
		if (StuArr[i].score <= 0 || StuArr[i].score >= 100) { // 일단 크게 0부터 100까지 잡고..!
		
		} else {
			if (StuArr[i].score >= 90) {
				StuArr[i].grade = 'A';

			} else if (StuArr[i].score >= 80) {
				StuArr[i].grade = 'B';
			} else if (StuArr[i].score >= 70) {
				StuArr[i].grade = 'C';
			} else if (StuArr[i].score >= 60) {
				StuArr[i].grade = 'D';
			} else if (StuArr[i].score >= 0) {
				StuArr[i].grade = 'E';
			} else {
				StuArr[i].grade = 'F';
				 
			}
			System.out.println(StuArr[i].number +"\t"+StuArr[i].Score +"\t"+ StuArr[i].grade);
			sum = sum + StuArr[i].score;
			
		} else {
		System.out.println(StuArr[i].number + "\t E R R O R ! ! ");
			error++;
	}
}
	System.out.println();
	
	System.out.println(StuArr.length + "명 입력 중[" + error + "]회 에러발생");
	System.out.println("총점 :" + sum);
	System.out.println("평균 : " + (double)sum/StuArr.length + "점");
}
}
