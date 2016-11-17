package ru.sptnc.EJBBean;


import ru.sptnc.DAO.BookDAO;
import ru.sptnc.DAO.CatalogDAO;
import ru.sptnc.DAOImpl.BookDAOImpl;
import ru.sptnc.DAOImpl.CatalogDAOImpl;
import ru.sptnc.Entity.Book;
import ru.sptnc.Entity.Catalog;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LibraryMgm implements LibraryMgmLocal {
    private AtomicInteger currentID = new AtomicInteger(0);
    private BookDAO bookDAO = new BookDAOImpl();
    private CatalogDAO catalogDAO = new CatalogDAOImpl();


    public Book getBook(int bookId) {
        return this.bookDAO.getBookById(bookId);
    }

    public List<Book> getAllBooks() {
        return this.bookDAO.getAllBook();
    }

    public List<Book> getCatalogBook(int catolgId) {
        return this.bookDAO.getCatalogBook(catolgId);
    }

    public Catalog getCatalog(int catolgId) {
        return catalogDAO.getCatalog(catolgId);
    }

    public Book createBook(String title, String author, Date publishDate, int catalogId) {
        return new Book(currentID.incrementAndGet(), catalogId, title, author, publishDate);
    }

    public Book saveBook(Book book) {
        return bookDAO.saveBook(book);
    }

    public Book deleteBook(int bookId) {
        return bookDAO.deleteBook(bookId);
    }

    public Book findBook(String title, String author, Date publishDate) {
        for (Book book : bookDAO.getAllBook()) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getPublishDate().equals(publishDate))
                return book;
        }

        return null;
    }

    public Boolean changeBookCatalog(int targetCtlgId, int bookId) {
        return bookDAO.chgBookCatalog(targetCtlgId, bookId);
    }
}
