package ru.sptnc.DAOImpl;

import ru.sptnc.DAO.CatalogDAO;
import ru.sptnc.Entity.Catalog;

import javax.ejb.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Singleton
public class CatalogDAOImpl implements CatalogDAO {

    private HashMap<Integer, Catalog> catalogMap = new HashMap<Integer, Catalog>();

    @Lock(LockType.READ)
    public List<Catalog> getAllCatalog() {
        return  new ArrayList<Catalog>(this.catalogMap.values());
    }
    @Lock(LockType.READ)
    public Catalog getCatalog(int catalogId) {
        return this.catalogMap.get(catalogId);
    }

    @Lock(LockType.WRITE)
    public Catalog saveCatalog(Catalog catalog) {
        return this.catalogMap.put(catalog.getCatalogId(),catalog);
    }

    @Lock(LockType.WRITE)
    public Catalog deleteCatalog(int catalogId) {
        return this.catalogMap.get(catalogId);
    }

}
