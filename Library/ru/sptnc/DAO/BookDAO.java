package ru.sptnc.DAO;

import ru.sptnc.Entity.Book;

import java.util.List;
import java.util.Map;

public interface BookDAO {

    public Book getBookById(int id);

    public List<Book> getAllBook();

    public Book saveBook(Book book);

    public Book deleteBook(int id);

    public List<Book> getCatalogBook(int catalogId);

    public Boolean chgBookCatalog(int targetClgId, int bookId);
}
