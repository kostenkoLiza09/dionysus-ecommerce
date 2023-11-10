package ua.com.dionysus.persistence.sql.type.wine;

import lombok.Getter;

@Getter
public enum WineStyleType {

    ROSE_WINE("Rose Wine"), RED_WINE("Red Wine"), WHITE_WINE("White Wine"),
    CHAMPAGNE_SPARKLING_WINE("Champagne & Sparkling Wine"),
    DESSERT_FORTIFIED_WINE("Dessert Fortified Wine"),
    READY_TO_DRINK("Ready to Drink");

    private final String wineType;

    WineStyleType(String wineType) {
        this.wineType = wineType;
    }
}
