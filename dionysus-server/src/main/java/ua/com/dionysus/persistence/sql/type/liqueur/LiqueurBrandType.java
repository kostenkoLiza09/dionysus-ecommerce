package ua.com.dionysus.persistence.sql.type.liqueur;

import lombok.Getter;

@Getter
public enum LiqueurBrandType {

    ACCOMPANI("Accompani"), CARPANO("Carpano"),
    CINZANO("Cinzano"), FORO("Foro"),
    MARTINI_ROSSI("Martini Rossi"), BAILEYS("Baileys");

    private final String liqueurBrandType;

    LiqueurBrandType(String liqueurBrandType) {
        this.liqueurBrandType = liqueurBrandType;
    }
}
