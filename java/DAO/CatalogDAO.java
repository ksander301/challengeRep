package DAO;

import Entity.Book;
import Entity.Catalog;
import Entity.enums.CatalogType;

import java.util.HashMap;
import java.util.Map;

public interface CatalogDAO {

    public Catalog getCatalog(CatalogType catalogType);

    public Map<Integer, Book> getBookMap(CatalogType catalogType);

    public Map<Integer, Book> getBookMap(Catalog catalog);

    public Book addBook(CatalogType catalogType, Book book);

    public Book addBook(Catalog catalog, Book book);

    public Book getBook(CatalogType catalogType, int id);

    public Book getBook(Catalog catalog, int id);

    public Book delBook(CatalogType catalogType, int id);

    public Book delBook(Catalog catalog, int id);

}
