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
	    for (Object key : keys) {
            String className = prop.getProperty(key.toString());
            Class<?> clz = Class.forName(className);
            Controller controller = (Controller) clz.getDeclaredConstructor().newInstance();
            mappings.put(key.toString(), controller);
        }

     
        mappings.put("/bbs.do",  new  BbsController());
  
        mappings.put("/view.do",  new ViewController());
       
        
  


        
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
	}
	
	}

