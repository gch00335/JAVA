package kr.ac.kopo.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {
//핸들맵핑의 특징 : 어떠어떠한 uri을 줄터니 해당하는 컨트롤러를 실행하시오임
	
	private Map<String , Controller> mappings;

	public HandlerMapping(String propLoc) {
		mappings = new HashMap<>();
		Properties prop = new Properties();
		try {
		InputStream is = new FileInputStream(propLoc);
		prop.load(is);
		
		Set<Object> keys = prop.keySet();
		//name들을 추출해내는 것
		// keyset 타입이 object 이므로  Set<object>keys 해줘야함
		
		for(Object key : keys) {
			System.out.println(key);
			String className = prop.getProperty(key.toString());
			System.out.println(key + " : " + className);
			
			Class<?> clz =Class.forName(className);
			
			//객체를 생성하기위해서 constructor를 만들어주고
			Constructor<?> constructor =  clz.getConstructor();
			
			constructor.newInstance();	
			
			mappings.put(key.toString(), (Controller)constructor.newInstance());
		}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//load는 파일을 읽어온다는 것!!
		
		
	//	mappings.put("/member/mypage.do", MypageController);
		
		
	}
	public Controller getController(String uri) {
		return mappings.get(uri);
	}
	/*
	//리플렉션 - > 프로그래을 실행하고 있던 와중에 객체를 관리하고 싶으면(만들거나, 호출하거나, 정보를 알아오게 하거나) 할때 사용하는 것
	//스프링은 다 리플렉션을 이용함!
	// 리플렉션을 쓰기 위해서는 forname으로 가져온 다음 constructor로 생성자를 만들어야 함 
	﻿
	public static void main(String[] args) throws Exception {
	
	//java.util.Random r = new java.util.Random();
	// System.out.println(r.nextInt());
		
		Class<?> clz = Class.forName("java.util.Random");
 		// ? 란 모든 것을 받아오기 위한 것
		
		//Object obj = clz.newInstance(); 이건 잘 안쓰니까 안씀~~~
		
		
		Constructor<?> constructor = clz.getConstructor();
		// constructor 를 통해 인스턴스 생성자를 만듦 ! 
		
		
		Object obj = constructor.newInstance();
		System.out.println("난수 : " + ((java.util.Random)obj).nextInt());
	}*/
	}

