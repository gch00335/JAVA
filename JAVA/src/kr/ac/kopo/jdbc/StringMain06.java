package kr.ac.kopo.jdbc;

public class StringMain06 {

public static void main(String[] args) {
		
		String data = "";
		long start = System.currentTimeMillis();
		for(int i = 0; i < 300000; i++) {
			data += i;		// data.concat(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("소요시간 : " + (end-start) / 1000. + "초");
		
		StringBuilder sb = new StringBuilder();
		start = System.currentTimeMillis();
		for(int i = 0; i < 300000; i++) {
			sb.append(i); // 오른쪽 시간을 보면 이게 좀더 빠른 방법이라는 것을 알 수 있다.
		}
		end = System.currentTimeMillis();
		System.out.println("소요시간 : " + (end-start) / 1000. + "초");
	}
}

