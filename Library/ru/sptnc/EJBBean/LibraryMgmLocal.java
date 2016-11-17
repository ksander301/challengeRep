package ru.sptnc.EJBBean;

import ru.sptnc.Entity.Book;
import ru.sptnc.Entity.Catalog;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

@Local
public interface LibraryMgmLocal {

    public Book getBook( int bookId);
    public List<Book> getAllBooks();
    public List<Book> getCatalogBook(int catolgId);
    public Catalog getCatalog (int catolgId);
    public Book createBook(String title, String author, Date publishDate, int catalogId);
    public Book saveBook(Book book);
    public Book deleteBook(int bookId);
    public Book findBook( String title, String author, Date publishDate);
    public Boolean changeBookCatalog(int bookId, int targetCtlgId);

}
