package lldQuestions.libraryManagementSystemDesign;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private int publishYear;
    private boolean available;

    public Book(String isbn,String name,String author,int publishYear){
        this.isbn=isbn;
        this.name=name;
        this.author=author;
        this.publishYear=publishYear;
        this.available=true;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public int getPublishYear(){
        return publishYear;
    }

    public boolean getAvailable(){
        return available;
    }

    public void setAvailable(boolean available){
        this.available=available;
    }

}
