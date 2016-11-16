package DAOImpl;

import DAO.BookDAO;
import Entity.Book;

import javax.ejb.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Singleton
public class BookDAOImpl implements BookDAO {
    private AtomicInteger currentID = new AtomicInteger(0);

    /*private BookDAOImpl() {

    }*/

    @Lock(LockType.WRITE)
    public Book createBook(String title, String author, Date publishDate) {
        return new Book(this.currentID.incrementAndGet(), title, author, publishDate);
    }


    @Lock(LockType.READ)
    public int getBookId(Book book) {
        return book.getId();
    }

    @Lock(LockType.READ)
    public String getBookAuthor(Book book) {
        return book.getAuthor();
    }

    @Lock(LockType.READ)
    public String getBookTitle(Book book) {
        return book.getTitle();
    }

    @Lock(LockType.READ)
    public Date getBookDate(Book book) {
        return book.getPublishDate();
    }

    @Lock(LockType.WRITE)
    public void setBookAuthor(Book book, String author) {
        book.setAuthor(author);
    }

    @Lock(LockType.WRITE)
    public void setBookTitle(Book book, String title) {
        book.setTitle(title);
    }

    @Lock(LockType.WRITE)
    public void setBookDate(Book book, Date date) {
        book.setPublishDate(date);
    }

    @Lock(LockType.WRITE)
    public void editBook(Book book, String title, String author, Date date) {
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishDate(date);
    }

}
