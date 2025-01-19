package lldQuestions.libraryManagementSystemDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManagement {
    private Map<String,Book>books;
    private Map<String,Member>members;
    private int MAX_BOOKS_PER_MEMBER=5;
    private int LOAN_DURATION_DAYS=14;

    public LibraryManagement(){
        this.books=new HashMap<>();
        this.members=new HashMap<>();
    }

    public void addBook(Book book){
        books.put(book.getIsbn(),book);
    }

    public Book getBook(String isbn){
        return books.get(isbn);
    }

    public void registerMember(Member member){
        members.put(member.getMemberId(), member);
    }

    public void unregisterMember(String memberId){
        members.remove(memberId);
    }

    public Member getMember(String memberId){
        return members.get(memberId);
    }

    public void borrowBook(String memberId,String isbn){
        Member member=members.get(memberId);
        Book book=books.get(isbn);
        if(member.getBooks().size()<MAX_BOOKS_PER_MEMBER){
            member.getBooks().add(book);
            book.setAvailable(false);
            System.out.println("Book borrowed: " + book.getName() + " by " + member.getName());
        }
        else {
            System.out.println("Member " + member.getName() + " has reached the maximum number of borrowed books.");
        }
    }

    public void returnBook(String memberId,String isbn){
        Member member=members.get(memberId);
        Book book=books.get(isbn);
        book.setAvailable(true);
        member.getBooks().remove(book);
        System.out.println("Book returned: " + book.getName() + " by " + member.getName());
    }

    public List<Book> search(String keyword){
        List<Book> searchResult=new ArrayList<>();
        for(Book book:books.values()){
            if(book.getName().contains(keyword) || book.getAuthor().contains(keyword) || book.getIsbn().contains(keyword)){
                searchResult.add(book);
            }
        }
        return searchResult;
    }
}
