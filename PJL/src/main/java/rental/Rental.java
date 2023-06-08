package rental;

public class Rental {

	private String title;
	private String thumbnai;
	private String isbn;
	private String userID;
	
	public Rental() {
        // 기본 생성자 추가
    }
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnai() {
		return thumbnai;
	}
	public void setThumbnai(String thumbnai) {
		this.thumbnai = thumbnai;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getuserID(){
		return userID;
	}
	public void setuserID(String userID) {
		this.userID = userID;
	}
}
