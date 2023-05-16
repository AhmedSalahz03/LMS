package application;


public class book {
	private String name;
	private String Author;
	private static int no_of_books=0; 
	public book(String nameb,String authorb) {
		no_of_books++;
		this.Author=authorb;
		this.name=nameb;	
	
		
	}
	public book() {
		no_of_books++;
	}
	  public String getAuthor() {
		return Author;
	}
	  public String getName() {
		return name;
	}
	  public void setAuthor(String author) {
		Author = author;
	}
	  public void setName(String name) {
		this.name = name;
	}
	  public static int getNo_of_books() {
		return no_of_books;
	}

}

