package kr.ac.kopo.day17.Homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;


public class LottoView {

	
private static final int Random = 0;
private HashSet set;
private int n;

public void start() {
	
	System.out.print("게임수를 입력 : ");
	Scanner sc = new Scanner(System.in);
	int gameCnt = sc.nextInt();
	for(int i = 1; i <= gameCnt; i++) {
		System.out.println("게임 " + i + " : " + Arrays.toString(getLotto()));
	}
	
}

 private int[] getLotto() {
//방법1
	Random random = new Random();

	int r1 = 0;
	int r2 = 0;
	int r3 = 0;
	int r4 = 0;
	int r5 = 0;
	int r6 = 0;

	while (r1 == r2 || r2 == r3 || r3 == r4 || r4==r5 ||r5 == r6|| r3==r1 ||r3==r5||r3==r6||
			r4==r1||r4==r2||r4==r6||r5==r1||r5==r2||r6==r1||r6==r2) {
		r1 = random.nextInt(45);
		r2 = random.nextInt(45);
		r3 = random.nextInt(45);
		r4 = random.nextInt(45);
		r5 = random.nextInt(45);
		r6 = random.nextInt(45);

	}
	int Random[] = { r1+1, r2+1, r3+1, r4+1, r5+1, r6+1 };
	
	return Random;
 }
} 
	
	/* 방법2
	 Random random = new Random();

	 int r1 = random.nextInt(45);
	 int r2 = random.nextInt(45);
	 int r3 = random.nextInt(45);
	 int r4 = random.nextInt(45);
	 int r5 = random.nextInt(45);
	 int r6 = random.nextInt(45);

	 int r7 = 1;

	 while (r1 != r7 && r2 != r7 
			 && r3 != r7 && r4 != r7 && r5 != r7 && r6 != r7) {
		 r7 = random.nextInt(46);
	 }


	 int Random[] = { r1+1, r2+1, r3+1, r4+1, r5+1, r6+1 };

	 Set set = new HashSet<>();


	 if (r1 == r2 || r1 == r3 || r1 == r4 || r1 == r5 || r1 == r6) {
		 set.remove(r1);
		 set.add(r7);
	 } else if (r2 == r3 || r2 == r4 || r2 == r5 || r2 == r6) {
		 set.remove(r2);
		 set.add(r7);
	 } else if (r3 == r4 || r3 == r5 || r3 == r6) {
		 set.remove(r3);
		 set.add(r7);
	 } else if (r4 == r5 || r4 == r6) {
		 set.remove(r4);
		 set.add(r7);

	 } else if (r5 == r6) {
		 set.remove(r5);
		 set.add(r7);


	 }

	 return Random;
 }
} 
	 */
/*방법 3
	 
	 LinkedList<Integer> list = new LinkedList<Integer>(); 
	 
	 Random random = new Random();

	 int r1 = random.nextInt(45);
	 int r2 = random.nextInt(45);
	 int r3 = random.nextInt(45);
	 int r4 = random.nextInt(45);
	 int r5 = random.nextInt(45);
	 int r6 = random.nextInt(45);
	 
	 int r7 = 1;

	 while (r1 != r7 && r2 != r7 
			 && r3 != r7 && r4 != r7 && r5 != r7 && r6 != r7) {
		 r7 = random.nextInt(46);
	 }

	 int Random[] = { r1+1, r2+1, r3+1, r4+1, r5+1, r6+1 };
	 
	 for(Integer i : list){
		 System.out.println(i);
		 if (i == r1 ||i == r2 || i == r3 ||i==r4||i==r5 ||i==r6) {
			 list.add(r7); 
		 }
	 }
	return Random;
 }
}
*/
	 /*방법4
	 Random random = new Random();

	 int r1 = 0;
	 int r2 = 0;
	 int r3 = 0;

	 while (r1 == r2 || r2 == r3 || r1 == r3) {
		 r1 = random.nextInt(45);
		 r2 = random.nextInt(45);
		 r3 = random.nextInt(45);
	 }

	 int[] ar = { r1 + 1, r2 + 1, r3 + 1 };

	 for (int j = ar.length - 1; 1 <= j; --j) {
		 int a = ar[j] % 10;
		
		 
		 int[] r = { r1 + 1, r2 + 1, r3 + 1, a +r1, a +r2, a + r3 };
		 return r;
	 }
	 return null;

 }
}
*/

	 /* 방법5
	  * 
	 Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DAY_OF_WEEK)+12;
		
		
	 Random random = new Random();

	 int r1 = 0;
	 int r2 = 0;
	 int r3 = 0;
	 int r4 = 0 ;

	 while (r1 == r2 || r2 == r3 || r2==r4|| r3==r4 || r1 == r3 ||r1==r4 || r1 == month ||
			 r2 == month || r3== month|| r4== month ||r1==date ||r2==date|| r3==date || r4 == date
			  ) {
		 r1 = random.nextInt(45);
		 r2 = random.nextInt(45);
		 r3 = random.nextInt(45);
		 r4 = random.nextInt(45);
	 }

	 int[] ar = { r1 + 1, r2 + 1, r3 + 1 , r4+1, month,  date };
	return ar;

	 
	 }
	
		 
	 }
	 */
 
	 

