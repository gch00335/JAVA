package kr.ac.kopo.day09;

public class methodMain02 {
	
	public static void main(String[] args) {
	Method m = new Method(); //실제화! 
	m.call();
	m.call(10);
	m.call("aaa", 12);
	m.call('a'); //묵시적현상으로 정수로 포함된 (작은것은 큰값에 포함)
	m.call(12.34);
}
}
