package ru.sptnc.DAO;

import ru.sptnc.Entity.Catalog;

import java.util.List;

public interface CatalogDAO {
    public List<Catalog> getAllCatalog();
    public Catalog getCatalog(int catalogId);
    public Catalog saveCatalog(Catalog catalog);
    public Catalog deleteCatalog(int catalogId);
}
