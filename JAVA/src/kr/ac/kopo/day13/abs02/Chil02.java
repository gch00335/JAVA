package kr.ac.kopo.day13.abs02;

import java.util.Arrays;

public class Chil02 extends Parent{
	private String name = "자식02" ;
	private String[] hobby =  {"게임" , "노래부르기"};
	
	@Override
	public void info() {
		System.out.println("나는"+ name + "입니다");
		System.out.println("내 취미는"+ Arrays.toString(hobby)+ "입니다");
		
	}
	public void game() {
		System.out.println("나는 게임을 합니다");
	}
	public void sing() {
		System.out.println("나는 노래를 부릅니다");
	}
}
