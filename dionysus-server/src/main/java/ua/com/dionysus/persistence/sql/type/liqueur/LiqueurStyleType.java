package ua.com.dionysus.persistence.sql.type.liqueur;

import lombok.Getter;

@Getter
public enum LiqueurStyleType {
    VERMOUTH("Vermouth"),
    CREAM_LIQUEUR("Cream Liqueur"),
    DESSERT_COFFEE("Dessert & Coffee Cocktails"),
    SPICED_FLAVORED_RUM("Spiced & Flavored Rum");

    private final String liqueurStyleType;

    LiqueurStyleType(String liqueurStyleType) {
        this.liqueurStyleType = liqueurStyleType;
    }
}
