package Homework0524;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginBean2 {
	private String id;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean dbCheck() throws IOException {
	    String FILE_PATH = "C:/Users/User/eclipse-workspace/example1/src/main/java/ex6/IDPW.txt";
	    BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
	    String line;

	    while ((line = reader.readLine()) != null) {
	        String[] parts = line.split(",");
	        String storedID = parts[0];
	        String storedPassword = parts[1];

	        if (storedID.equals(id) && storedPassword.equals(password)) {
	            reader.close();
	            return true; // 로그인 성공
	        }
	    }

	    reader.close();
	    return false; // 로그인 실패
	}
}
