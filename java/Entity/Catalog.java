package Entity;

import Entity.enums.CatalogType;

import java.util.HashMap;
import java.util.Map;

public class Catalog {

    private HashMap<Integer, Book> mapBooks;
    private CatalogType catalogType;

    public Catalog(CatalogType catalogType) {
        this.mapBooks = new HashMap<Integer, Book>();
        this.catalogType = catalogType;
    }


    public Map<Integer, Book> getMapBooks() {
        return mapBooks;
    }

    public CatalogType getCatalogType() {
        return catalogType;
    }

    public Book addBook(Book book) {
        return mapBooks.put(book.getId(), book);
    }

    public Book findBook(int id) {
        return mapBooks.get(id);
    }

    public Book delBook(int id) {
        return mapBooks.remove(id);
    }
}
