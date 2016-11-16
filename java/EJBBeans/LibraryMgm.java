package EJBBeans;

import DAO.BookDAO;
import DAO.CatalogDAO;
import DAOImpl.BookDAOImpl;
import DAOImpl.CatalogDAOImpl;
import Entity.Book;
import Entity.Catalog;
import Entity.enums.CatalogType;

import javax.ejb.Stateless;
import java.util.Date;
import java.util.Map;

@Stateless
public class LibraryMgm implements LibraryMgmLocal {
    private static final int NOT_FOUND_CONST = -1;

    BookDAO bookDAO = new BookDAOImpl();
    CatalogDAO catalogDAO = new CatalogDAOImpl();

    public Catalog getCatalog(CatalogType catalogType) {
        return this.catalogDAO.getCatalog(catalogType);
    }

    public Map<Integer, Book> getCatalgBooks(CatalogType catalogType) {
        return this.catalogDAO.getBookMap(catalogType);
    }

    public Book createBook(String title, String author, Date publishDate) {
        return this.bookDAO.createBook(title, author, publishDate);
    }

    public Book deleteBook(Catalog catalog, String title, String author, Date publishDate) {
        int bookId = NOT_FOUND_CONST;
        for (Book book : catalog.getMapBooks().values()) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getPublishDate().equals(publishDate)) {
                bookId = book.getId();
                break;
            }
        }
        return catalog.delBook(bookId);
    }

    public Book deleteBook(Catalog catalog, int id) {
        return catalog.delBook(id);
    }

    public Book editBook(Book book, String title, String author, Date publishDate) {
        this.bookDAO.editBook(book, title, author, publishDate);

        return book;
    }

    public Book findBook(CatalogType catalogType, String title, String author, Date publishDate) {
        Catalog catalog = this.catalogDAO.getCatalog(catalogType);
        for (Book book : catalog.getMapBooks().values())
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getPublishDate().equals(publishDate))
                return book;

        return null;
    }

    public Boolean changeBookCatalog(CatalogType fromCatalogType, CatalogType toCatalogType, Book book) {
        Catalog catalogFrom = this.catalogDAO.getCatalog(fromCatalogType);
        Catalog catalogTo = this.catalogDAO.getCatalog(toCatalogType);

        Boolean result = false;
        if (!catalogTo.addBook(book).equals(null))
            if (!catalogFrom.delBook(book.getId()).equals(null))
                result = true;
        return result;
    }
}
