package EJBBeans;

import Entity.Book;
import Entity.Catalog;
import Entity.enums.CatalogType;

import javax.crypto.Mac;
import javax.ejb.Local;
import java.util.Date;
import java.util.Map;

@Local
public interface LibraryMgmLocal {

    public Catalog getCatalog( CatalogType catalogType);

    public Map<Integer,Book>  getCatalgBooks(CatalogType catalogType);

    public Book createBook(String title, String author, Date publishDate);

    public Book deleteBook(Catalog catalog, String title, String author, Date publishDate);

    public Book deleteBook(Catalog catalog, int id);

    public Book editBook(Book book, String title, String author, Date publishDate);

    public Book findBook(CatalogType catalogType, String title, String author, Date publishDate);

    public Boolean changeBookCatalog(CatalogType fromCatalogType, CatalogType toCatalog, Book book);
}
