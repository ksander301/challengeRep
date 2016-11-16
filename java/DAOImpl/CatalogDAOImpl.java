package DAOImpl;

import DAO.CatalogDAO;
import Entity.Book;
import Entity.Catalog;
import Entity.enums.CatalogType;

import javax.ejb.*;
import java.util.HashMap;
import java.util.Map;

@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Singleton
public class CatalogDAOImpl implements CatalogDAO {

    private  Catalog openCatalog = new Catalog(CatalogType.OPEN);
    private  Catalog limitCatalog =new Catalog(CatalogType.LIMITED);

    /*private CatalogDAOImpl() {

    }*/

    @Lock(LockType.READ)
    public Catalog getCatalog(CatalogType catalogType) {
        return catalogType.equals(CatalogType.OPEN) ? openCatalog : limitCatalog;
    }

    @Lock(LockType.READ)
    public Map<Integer, Book> getBookMap(CatalogType catalogType) {
        return catalogType.equals(CatalogType.OPEN) ? openCatalog.getMapBooks() : limitCatalog.getMapBooks();
    }

    @Lock(LockType.READ)
    public Map<Integer, Book> getBookMap(Catalog catalog) {
        return catalog.getMapBooks();
    }

    @Lock(LockType.WRITE)
    public Book addBook(CatalogType catalogType, Book book) {
        return catalogType.equals(CatalogType.OPEN) ? openCatalog.addBook(book) : limitCatalog.addBook(book);
    }

    @Lock(LockType.WRITE)
    public Book addBook(Catalog catalog, Book book) {
        return catalog.addBook(book);
    }

    @Lock(LockType.READ)
    public Book getBook(CatalogType catalogType, int id) {
        return catalogType.equals(CatalogType.OPEN) ? openCatalog.findBook(id) : limitCatalog.findBook(id);
    }

    @Lock(LockType.READ)
    public Book getBook(Catalog catalog, int id) {
        return catalog.findBook(id);
    }

    @Lock(LockType.WRITE)
    public Book delBook(CatalogType catalogType, int id) {
        return catalogType.equals(CatalogType.OPEN) ? openCatalog.delBook(id) : limitCatalog.delBook(id);
    }

    @Lock(LockType.WRITE)
    public Book delBook(Catalog catalog, int id) {
        return catalog.delBook(id);
    }
}
