package kr.ac.kopo.bbs;
//인스턴스를 담을 수 있는 틀인 빈즈 만들기
public class Bbs {

	private int bbsID;
	private String bbsTitle;
	private String userID;
	private String bbsDate;
	private String bbsContent;
	private int bbsAvailable;
	private int pbbsID;
	
	
	
	
	public int getPbbsID() {
		return pbbsID;
	}
	public void setPbbsID(int pbbsID) {
		this.pbbsID = pbbsID;
	}
	
	public int getBbsID() {
		return bbsID;
	}
	public void setBbsID(int bbsID) {
		this.bbsID = bbsID;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBbsDate() {
		return bbsDate;
	}
	public void setBbsDate(String bbsDate) {
		this.bbsDate = bbsDate;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public int getBbsAvailable() {
		return bbsAvailable;
	}
	public void setBbsAvailable(int bbsAvailable) {
		this. bbsAvailable = bbsAvailable;
	}
	public void setReply(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}