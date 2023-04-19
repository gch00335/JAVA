package kr.ac.kopo.Membervo;

import java.util.Arrays;

public class LibraryBoardVO {

	private int no;

	private String loginID;
	private String loginPW;
	private String name;
	private String birth ;
	private String mail;
	private String phone;
	private LibraryBoardVO[] users;
	
	public LibraryBoardVO(){
		super();
	}

	public LibraryBoardVO(int no, String loginID, String loginPW, String name, String birth, String mail,
			String phone) {
		super();
		this.no = no;
		this.loginID = loginID;
		this.loginPW = loginPW;
		this.name = name;
		this.birth = birth;
		this.mail = mail;
		this.phone = phone;
	}

	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}


	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getLoginPW() {
		return loginPW;
	}

	public void setLoginPW(String loginPW) {
		this.loginPW = loginPW;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	  public void setUsers(LibraryBoardVO[] users) {
	        this.users = users;
	    }

	  public LibraryBoardVO[] getUsers() {
	        return users;
	    }
	  public void setManager(LibraryBoardVO[] users) {
	        this.users = users;
	    }


	  @Override
	  public String toString() {
	      return "LibraryBoardVO [no=" + no + ",  loginID=" + loginID + ", loginPW=" + loginPW + ", name="
	              + name + ", birth=" + birth + ", mail=" + mail + ", phone=" + phone + "]" + Arrays.toString(users);
	  
}




}








