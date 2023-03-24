package kr.ac.kopo.day14_1Homework;

public class Random {

	private Random() {
	}

	public void r() {
		
		Random r = new Random();
		int random = r.nextInt(10);

		Random rr = new Random();
		int random2 = rr.nextInt(10);

		Random rrr = new Random();
		int random3 = rrr.nextInt(10);

		int a = (random * 100) + (random2 * 10) + (random3 * 1);
		System.out.println(a);

	}

}
}
