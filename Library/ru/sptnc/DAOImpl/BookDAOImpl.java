package ru.sptnc.DAOImpl;

import ru.sptnc.DAO.BookDAO;
import ru.sptnc.Entity.Book;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


@Singleton
public class BookDAOImpl implements BookDAO {
    private AtomicInteger currentId = new AtomicInteger(0);
    private HashMap<Integer, Book> bookhMap = new HashMap<Integer, Book>();

    @Lock(LockType.READ)
    public Book getBookById(int id) {
        return this.bookhMap.get(id);
    }

    @Lock(LockType.READ)
    public List<Book> getAllBook() {
        return new ArrayList<Book>(bookhMap.values());

    }
    @Lock(LockType.WRITE)
    public Book saveBook(Book book) {
        return this.bookhMap.put(book.getId(), book);
    }

    @Lock(LockType.WRITE)
    public Book deleteBook(int bookId) {

        return this.bookhMap.remove(bookId);
    }

    @Lock(LockType.READ)
    public List<Book> getCatalogBook(int catalogId) {
        List<Book> catalogBooks = new ArrayList<Book>();
        for (Book book : this.bookhMap.values())
            if (catalogId == book.getCatlogId())
                catalogBooks.add(book);

        return catalogBooks;
    }

    @Lock(LockType.READ)
    public Boolean chgBookCatalog(int targetClgId, int bookId) {
        Boolean result = false;
        Book book= this.getBookById(bookId);
        if (targetClgId != book.getId()) {
            book.setId(targetClgId);
            //this.saveBook(book);
            result = true;
        }
        return result;
    }
}
