package ua.com.dionysus.persistence.sql.type.wine;

import lombok.Getter;

@Getter
public enum WineBrandType {

    ACCADEMIA("Accademia"), ADOBE_ROAD_WINERY("Adobe Road"),
    BRANCOTT_ESTATE("Brancott Estate"), CAMBRIA("Cambria"),
    CELANGE("Celange"), CHAMPAGNE_LASNSON("Champagne Lasnson"),
    CHANDON("Chandon"), COOL_CAT("Cool Cat"), COTE_DES_ROSES("Cote des Roses"),
    DOM_PERIGNON("Dom Perignon"), DR_FISCHER("Dr.Fischer"),
    MOET_CHANDON("Moёt & Chandon");

    private final String wineBrandType;

    WineBrandType(String wineBrandType) {
        this.wineBrandType = wineBrandType;
    }
}
