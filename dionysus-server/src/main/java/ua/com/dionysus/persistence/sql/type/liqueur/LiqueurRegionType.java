package ua.com.dionysus.persistence.sql.type.liqueur;

import lombok.Getter;

@Getter
public enum LiqueurRegionType {

    KENTUCKY("Kentucky");

    private final String liqueurRegionType;

    LiqueurRegionType(String liqueurRegionType) {
        this.liqueurRegionType = liqueurRegionType;
    }
}
