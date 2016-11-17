package ru.sptnc.Entity.TypeEnum;

public enum CatalogType {
    OPEN(1),
    LIMITED(2);

    CatalogType(int intValue) {
        this.intValue = intValue;
    }

    public final int intValue;

}
