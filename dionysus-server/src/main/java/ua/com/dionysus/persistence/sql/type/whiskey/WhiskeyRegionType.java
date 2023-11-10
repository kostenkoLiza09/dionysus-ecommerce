package ua.com.dionysus.persistence.sql.type.whiskey;

import lombok.Getter;

@Getter
public enum WhiskeyRegionType {

    TENNESSEE("Tennessee"), KENTUCKY("Kentucky"), HIGHLANDS("Highlands"),
    ISLANDS("Islands"), TEXAS("Texas"), COLORADO("Colorado"), LOWLANDS("Lowlands"),
    CALIFORNIA("California"), NEW_MEXICO("New Mexico"), SOUTH_CAROLINA("South Carolina");

    private final String whiskeyRegion;

    WhiskeyRegionType(String whiskeyRegion) {
        this.whiskeyRegion = whiskeyRegion;
    }
}
