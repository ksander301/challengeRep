package ru.sptnc.Entity;

import ru.sptnc.Entity.TypeEnum.CatalogType;

public class Catalog {

    private int catalogId;
    private CatalogType catalogType;
    private String desc;

    public Catalog(int catalogId, CatalogType catalogType) {
        this.catalogId = catalogId;
        this.catalogType = catalogType;
    }


    public Catalog(int catalogId, CatalogType catalogType, String desc) {
        this.catalogId = catalogId;
        this.catalogType = catalogType;
        this.desc = desc;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public CatalogType getCatalogType() {
        return catalogType;
    }

    public void setCatalogType(CatalogType catalogType) {
        this.catalogType = catalogType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
