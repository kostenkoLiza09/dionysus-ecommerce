package ua.com.dionysus.persistence.sql.type.wine;

import lombok.Getter;

@Getter
public enum WineRegionType {

    CALIFORNIA("California"), CHAMPAGNE("Champagne"), MONTEREY_COUNTRY("Monterey"),
    NAPA_VALLEY("Napa Valley"), SANTA_BARBARA("Santa Barbara"), SONOMA_COUNTRY("Sonoma Country"),
    BURGUNDY("Burgundy"), CENTRAL_COAST("Central Coast"), VENETO("Veneto");


    private final String wineRegionType;

    WineRegionType(String wineRegionType) {
        this.wineRegionType = wineRegionType;
    }
}
