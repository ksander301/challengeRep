package DAO;

import Entity.Book;
import java.util.Date;

public interface BookDAO {

    public Book createBook(String title, String author,Date publishDate);
    public int getBookId( Book book);
    public String getBookAuthor(Book book);
    public String getBookTitle(Book book);
    public void setBookAuthor(Book book,String author);
    public void setBookTitle(Book book,String title);
    public void setBookDate(Book book, Date date) ;
    public Date getBookDate(Book book);
    public void editBook(Book book, String title, String author, Date date);

    }
