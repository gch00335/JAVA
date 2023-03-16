package kr.ac.kopo.day06.Homework;

public class Homework05 {

	public static void main(String[] args) {
		/*8) 구구단을 한 라인에 3단씩 출력하시오
		 *  2*1=2 3*1=3  4*1=4
				 *  2*2=4 3*2=6  4*2=8
				 *  ...
				 *  5*1=5 6*1=6 7*1=7
				 *  ...
				 *  9단까지
				 *  
				 */  
		
	  System.out.println("[구구단 3단씩 나열하기]");
	 for(int i =2 ; i<=9 ; i=i+3) {
		 for(int j=1 ; j<=9 ; j++) {
			 for(int k=i ; k<i+3 ; k++) {
				if(k != 10) {
					System.out.print(k + "*" + j + "=" + k*j + "\t");	
				}
			
			 } 
			 System.out.println();

		 }
	 }
	}	
}
	
//교수님께서 알려주신 방법
/* [방법1]
* Scanner sc = new Scanner(System.in);	
*  for(int i =2 ; i<=9 ; i+=3{
*    for(int j=1 ; j<=9 ; j++) {
*      System.out.printf("%d * %d =%d\t" , i,j, i*j);
*      System.out.printf("%d * %d =%d\t" , i+1,j, (1+i)*j);
*      if(i+2 <= 9){
*      System.out.printf("%d * %d =%d\t" , i+2,j, (2+i)*j);
*      }
*      System.out.println();
*    }
*  System.out.println();
*  
*  
*  [방법2]
*   System.out.println("[구구단 3단씩 나열하기]");
	 for(int i =2 ; i<=9 ; i=i+3) {
		 for(int j=1 ; j<=9 ; j++) {
			 for(int k=i ; k< 9 && k ; k++) { //  &&로 10안나오게 하기 ..!
					System.out.print(k + "*" + j + "=" + k*j + "\t");	
				}
			
			 } 
			 System.out.println();

		 }
	 }
	}	
}


*[방법3] - 첫 시작에 ***단 ***도 같이 나오게 하기
*
*   System.out.println("[구구단 3단씩 나열하기]");
	 for(int i =2 ; i<=9 ; i=i+3) {
		 for(int j=0 ; j<=9 ; j++) {
		  if( j==0 ){
		    System.out.println("***"+"dan +"단"+ "***");
			 for(int k=i ; k< 9 && k ; k++) { //  &&로 10안나오게 하기 ..!
					System.out.print(k + "*" + j + "=" + k*j + "\t");	
				}
			
			 } 
			 System.out.println();

		 }
	 }
	}	
}  
*  */
