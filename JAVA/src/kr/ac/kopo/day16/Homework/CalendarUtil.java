
new 

package kr.ac.kopo.day16.Homework;

import java.util.Calendar;

public class CalendarUtil { // 달력의 기능 클래스를 만들어 볼 것!
	// 내가 알아야 할 정보 2가지  1) 1일이 몇요일에 시작하는지 2) 한달이 며칠까지 있는지(31.30.29 등)
	private Calendar c;
	
	public CalendarUtil() {
		c = Calendar.getInstance(); // 원래 있던 날짜의 기능을 끌고 온것..이걸 외워야할듯
	}
	
	 public void showByYear(int year) {
			for(int month = 1; month <= 12; month++) {
				showByMonth(year, month);
			}
		}
		
		public void showByMonth(int year, int month) {
			
			System.out.println("*** " + year + "년 " + month + "월 ***");
			// year / month / 날짜정보 수정 ( 설정에는 set을 쓴다)
			c.set(year, month-1,1);
		
			// 요일 추출(에는 get 을 쓴다)
			int week = c.get(Calendar.DAY_OF_WEEK);
			
			// 해당월의 마지막날 ( c.getActualMaximum) 최대큰것을 뽑는 코드..!
			int lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			System.out.println("week : " + week+", lastday" + lastday);
			
			showByDay(week,lastday);  // 실제출력은 여기서 하려는 것
			
		}
		private void showByDay(int week, int lastday) {
			
			System.out.println("=================================================");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			System.out.println("=================================================");
			int cnt = 0 ;
			for(int i= 1 ; i<week ; i++) {
				System.out.print("\t");
				cnt++;
			}
			for(int day = 1 ; day <= lastday ; day++) {
				System.out.print(day + "\t");
				if(++cnt %7 ==0) {
					System.out.println();
				}
			}
			if(++cnt %7 !=0){ // 마지막에는 엔터가 들어가지 않도록 실행하는 것... 우와...
			System.out.println();}
			System.out.println("=================================================");
		}
		
		
	}
