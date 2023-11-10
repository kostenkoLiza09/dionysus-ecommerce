package ua.com.dionysus.persistence.sql.type.wine;

import lombok.Getter;

@Getter
public enum WineVarietalType {

    CABERNET_SAUVIGNON("Cabernet Sauvignon"),
    CHAMPAGNE("Champagne"),
    CHARDONNAY("Chardonnay"),
    PINOT_GRIGIO_GRIS("Pinot Grigio/Pinot Gris"),
    PROSECCO("Prosecco"),
    PINOT_NOIR("Pinot Noir"),
    RED_BLEND("Red Blend"),
    ROSE("Ros"),
    SAUVIGNON_BLANC("Sauvignon Blanc"),
    SPARKLING_WINE("Sparkling Wine"),
    SYRAH_SHIRAZ("Syrah/Shiraz"),
    VIOGNIER("Viognier"),
    WHITE_BLEND("WHite Blend"),
    XINOMAVRO("Xinomavro");

    private  final String wineVarietalType;

    WineVarietalType(String wineVarietalType) {
        this.wineVarietalType = wineVarietalType;
    }
}
