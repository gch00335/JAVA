package kr.ac.kopo.day13.abs02;

public class CastMain01 {

	public static void print(Parent P) { 
		
		if(P instanceof Chil01) {
			Chil01 c01 = (Chil01)P;
				c01.sleep();
				c01.study();
			} else if (P instanceof Chil02) {
				Chil02 c02 = (Chil02)P ;
				c02.game();
				c02.sing();
			}
	P.info();	
	}
		
		
		
		//인스턴스 오브 [instanceof] 를 쓸거임
		// 이유 : Parent 를 불러올때 타입이 총 3개가 있기에 어떤 타입이 불러올지 모르기 때문에
		//  ->>인스턴스 오브는 무조건 ﻿왼쪽과 오른쪽이 무조건 상속관계일때만 사용 가능!
		
		/*
		System.out.println("P instanceof Chil01 : " + (P instanceof Chil01));
		
		System.out.println("P instanceof Chil02 : " + (P instanceof Chil02));
		
		System.out.println("P instanceof Chil02 : " + (P instanceof Parent));
		          
		P.info(); 
		*/
	
	
	public static void main(String[] args) {
		
		//	print(new Chil01());
	print(new Chil02());
	//	print(new Parent());
		
		
		/*Chil01 c01 = new Chil01();
		c01.info();
		
		Chil02 c02 = new Chil02();
		c02.info();
		
		Parent p = new Parent();
		p.info();
		*/
		
		
	/* chil01 c01 = new Chil01 ();
		c01.info();
		c01.sleep();
		c01.study(); */
		
//		Parent p = new Chil01();
//		p.info(); //p로만 연결된 것만 접근 가능
//		p.sleep(); 접근 불가
//		p.study(); 접근 불가
		
		
		

	}

}
