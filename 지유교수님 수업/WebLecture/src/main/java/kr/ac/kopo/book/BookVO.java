package kr.ac.kopo.book;

/*
 	자바빈즈클래스
 	1. 패키지를 포함
 	2. 클래스의 접근제한자는 public
 	3. 디폴트생성자 포함
 	4. 모든 멤버변수의 접근제한자는 private
 	5. getter/setter 메소드 포함
 */

public class BookVO {
	
	private String isbn;
	private String title;
	private String writer;
	
	public BookVO() {
	}

	public BookVO(String isbn, String title, String writer) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}









