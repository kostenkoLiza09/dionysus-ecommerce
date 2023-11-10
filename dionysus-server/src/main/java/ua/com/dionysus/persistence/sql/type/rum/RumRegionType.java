package ua.com.dionysus.persistence.sql.type.rum;

import lombok.Getter;

@Getter
public enum RumRegionType {

    FLORIDA("Florida"), PUERTO_RICO("Puerto Rico");

    private final String rumRegionType;

    RumRegionType(String rumRegionType) {
        this.rumRegionType = rumRegionType;
    }
}
