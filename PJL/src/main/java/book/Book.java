package book;

public class Book {
	
    private String title;
    private String thumbnai;
    private String isbn;
    private String authors;
    private String contents;
	
    public Book() {
        // 기본 생성자 추가
    }
    public String getTitle() {
		return title;
	}
	public Book(String title, String thumbnai, String isbn, String authors, String contents) {
		super();
		this.title = title;
		this.thumbnai = thumbnai;
		this.isbn = isbn;
		this.authors = authors;
		this.contents = contents;
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
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
    
}