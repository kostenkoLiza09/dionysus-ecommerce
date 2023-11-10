package ua.com.dionysus.persistence.sql.type.tequila;

import lombok.Getter;

@Getter
public enum TequilaStyleType {

    BLANCO("Blanco"), REPOSADO("Reposado"),
    ANEJO("Añejo"), EXTRA_ANEJO("Extra Añejo"), CRISTALINO("Cristalino"),
    ORIGINAL_TEQUILA("Original Tequila");

    private final String tequilaStyleType;

    TequilaStyleType(String tequilaStyleType) {
        this.tequilaStyleType = tequilaStyleType;
    }
}
