package kr.ac.kopo.day10.Homework;

public class Calculator {
	int num1 ,num2 ;
	private boolean sosuCheck;

	Calculator () {
	}
	Calculator (int num1, int num2){
		this. num1 = num1;
		this. num2 = num2;
	}
	public void sum() {
		System.out.println(num1 + "+" + num2 + "=" + (num1+num2));
	}
	public void imsub( ) {
		System.out.println(num1 + "-" + num2 + "=" + (num1-num2));
	}
	public void product( ) {
		System.out.println(num1 + "*" + num2 + "=" + (num1*num2));
	}
	public void mod( ) {
		System.out.println(num1 + "/" + num2 + "=" + ((double)(num1/num2)));
	}
	public void sosu() {
		int [] num1num2 = {num1, num2};
		for(int num1 : num1num2){
			boolean sosuCheck = true ;
		} if(num1 != 1) {
			for(int i = 2 ; i <= num1/2 ; ++i){
				if(num1%i ==0 && num1%i !=2) {
					 sosuCheck = false ;
				}
			}
		}	else { 
			 sosuCheck = false ;

		}
		System.out.println(num1 + "소수체크 :" + sosuCheck);
		System.out.println(num2 + "소수체크 :" + sosuCheck);
	}
}	
	 






