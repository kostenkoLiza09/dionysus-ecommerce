package ua.com.dionysus.persistence.sql.type.tequila;

import lombok.Getter;

@Getter
public enum TequilaRegionType {
    JALISCO("Jalisco"), GUANAJUATO("Guanajuato");

    private final String tequilaRegionType;

    TequilaRegionType(String tequilaRegionType) {
        this.tequilaRegionType = tequilaRegionType;
    }
}
