package kr.ac.kopo.member;

public class MemberVO {
	private String id;
	private String password;
	private String name;
 //alt + shift + s + r
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}//alt + shift + s + o
	public MemberVO(String id, String password, String name, String type) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String type;
	//alt + shift + s + c 
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
