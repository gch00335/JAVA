package kr.ac.kopo.day10;

public class Member {
	/** 이름 */
	String name ;              
	/** 나이 */
	int age;                  
	/** 혈액형 */
	String bloodType;        
	
	Member(){
		this("알수없음");
	}
	/*
	 * Member(){ // 디폴트로 항상 기본변수를 만들어놓아야함
	 
	
		this("알수없음", -1, "알수없음"); // 새로운 new 객체를 만들기엔 이미 위에 new 공간이 만들어져있어서 다시 만들 수가 없음
		                              //그래서 이렇게 [this]를 써야 함 
		                              // 즉, 

		                              * 
		                              * ?? 교수님께 여쭤보기 this 생성자 
		                              * this("알수없음", -1, "알수없음") 이거랑 다른의미로 이해했는데 맞는건지
		                              * *this.name = name;
		                                 this.age = -1;
		                                 this.bloodType = "알수없음";
		                              * 
		                              */
		
		
		/*this.name =  "알수없음";
		this.age = -1;
		this.bloodType = "알수없음"; 
	
	}
	Member(String name){
		this("알수없음", -1, "알수없음");
		
		/*this.name = name;
		this.age = -1;
		this.bloodType = "알수없음";
		*/ 
	
	Member(String name){
		this(name,-1);
	
}
	Member(String name , int age){
		this("알수없음", -1, "알수없음");
		
		/*this.name = name;
		this.age = age;
		this.bloodType = "알수없음";   */
		
	}

	Member(String name, int age, String bloodType){
		this.name = name; //지역변수로 구분된 것이 아닌 클래스내에 변수로 인식되기에 따로 구분될 수 있도록 'this'란 기호를 반드시 붙여줘야 함
		this.age = age;
		this.bloodType = bloodType;
	}
	
		void info() {
		System.out.println("이름 :" + name + ", 나이 :" + age + ", 혈액형 :"+bloodType);
	}
	

}
