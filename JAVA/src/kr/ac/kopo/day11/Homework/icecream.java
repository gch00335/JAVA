package kr.ac.kopo.day11.Homework;

public class icecream {
	String name;
	int price;
	int num ;

	icecream () {

	}
	icecream(String name, int price, int num){
		this.name = name;
		this.price = price;
		this.num = num;
	} 

	public void payer() {
		int k =1;
		for(int i = 1 ; i<=num ; i++) {
			k = i;
	}
		System.out.print( k + name + price);
} 
}