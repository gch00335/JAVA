package kr.ac.kopo.user;

public class User {
	
	private String ID;
	private String PASSWORD;
	private String Name;
	private String Email;
	private String Birth;
	private String Phone;
	private String Post;
	private String Addr;
	private String DETAILADDRESS ;
	@Override
	public String toString() {
		return "User [ID=" + ID + ", PASSWORD=" + PASSWORD + ", Name=" + Name + ", Email=" + Email + ", Birth=" + Birth
				+ ", Phone=" + Phone + ", Post=" + Post + ", Addr=" + Addr + ", DETAILADDRESS=" + DETAILADDRESS
				+ ", admin=" + admin + ", agree=" + agree + "]";
	}
	private String admin;
	private String agree;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getPost() {
		return Post;
	}
	public void setPost(String post) {
		Post = post;
	}
	public String getAddr() {
		return Addr;
	}
	public void setAddr(String addr) {
		Addr = addr;
	}
	public String getDETAILADDRESS() {
		return DETAILADDRESS;
	}
	public void setDETAILADDRESS(String dETAILADDRESS) {
		DETAILADDRESS = dETAILADDRESS;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
}