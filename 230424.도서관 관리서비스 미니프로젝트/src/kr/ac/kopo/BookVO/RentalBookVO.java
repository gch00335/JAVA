package kr.ac.kopo.BookVO;

public class RentalBookVO {
	
	private String LoginID ;
	private int no ; // 도서번호 
	private String bookname ; // 도서이름 
	private String writer; // 작가
	private String publisher; // 출판사
	
	public RentalBookVO() {
		super();
	}
	public String getLoginID() {
		return LoginID;
	}
	public void setLoginID(String LoginID) {
	    this.LoginID = LoginID;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public RentalBookVO(String LoginID, int no, String bookname, String writer, String publisher) {
		super();
		this.LoginID = LoginID;
		this.no = no;
		this.bookname = bookname;
		this.writer = writer;
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "BookVO [LoginID = " + LoginID + ", no=" + no + ", bookname=" + bookname + ", writer=" + writer + ", publisher=" + publisher + "]";
		


	 
	}
	
	}

	
	
	

