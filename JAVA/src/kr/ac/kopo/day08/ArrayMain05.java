package kr.ac.kopo.day08;

import java.util.Arrays;

public class ArrayMain05 {

	public static void main(String[] args) {
		
		int[] arr = {10,20,30,40,50,60}; // 여기서 30 부터 50까지의 숫자를
		int[] dest = {0,0,0,0,0,0}; // dest의 세번째에 옮기고 싶을때는
		int[] dest1 = new int[arr.length];
		
		/* (1)
		for(int i=0; i <arr.length; i++) {
			dest[i] = arr[i];
			
		}*/ //(1)-1  밑 코드랑 서로 같은 말 !
		//System.arraycopy(arr,0, dest,0,arr.length);
		
		// (2)
		//for(int i =3 , j=1 ; i <6 ; j++, i++) {
		//	dest[j] = arr[i];
		
		/* (2)-1
		for(int arrIdx = 3, destIdx = 1 , i=0 ; i<3; i++) { // 여기서 i는 갯수
			dest[destIdx++] = arr[arrIdx++];
		}*/
		
		System.arraycopy(arr,3,dest1,1,3);
		
		
		System.out.println("arr : " + Arrays.toString(arr));
		System.out.println("arr : " + Arrays.toString(dest1));
		}

	}


