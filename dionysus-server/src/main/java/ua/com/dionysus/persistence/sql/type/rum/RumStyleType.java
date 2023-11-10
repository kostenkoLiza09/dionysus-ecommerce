package ua.com.dionysus.persistence.sql.type.rum;

import lombok.Getter;

@Getter
public enum RumStyleType {

    AGED_RUM("Aged Rum"),
    DARK_RUM("Dark Rum"),
    SPICED_FLAVORED("Spiced & Flavored Rum"),
    WHITE_RUM("White Rum"),
    ORIGINAL_RUM("Original Rum");

    private final String rumStyleType;

    RumStyleType(String rumStyleType) {
        this.rumStyleType = rumStyleType;
    }
}
