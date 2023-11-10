package ua.com.dionysus.persistence.sql.type.tequila;

import lombok.Getter;

@Getter
public enum TequilaBrandType {

    ALDEZ("Aldez"), ASTRAL("Astral"), CASA_MEXICO("Casa Mexico"),
    CENOTE("Cenote"), HERRADURA("Herradura"), JOSE_CUERVO("Jose Cuervo"),
    TEQUILA_CORRIDO("Tequila_corrido"), TRES_COMAS("Tres Comas"), CORRALEJO_TEQUILA("Corralejo Tequila");

    private final  String tequilaBrandType;

    TequilaBrandType(String tequilaBrandType) {
        this.tequilaBrandType = tequilaBrandType;
    }
}
