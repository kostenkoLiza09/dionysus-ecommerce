package ua.com.dionysus.persistence.sql.type.whiskey;

import lombok.Getter;

@Getter
public enum WhiskeyStyleType {

    SINGLE_MALT("Single Malt"), BOURBON("Bourbon"),
    TENNESSEE_WHISKEY("Tennessee Whiskey"), RYE("Rye"), BLENDED_SCOTCH("Blended Scotch"),
    BLENDED_WHISKEY("Blended Whiskey"), FLAVORED_WHISKEY("Flavored Whiskey"), IRISH_WHISKEY("Irish Whiskey"),
    SCOTCH("Scotch");

    private final String whiskeyType;

    WhiskeyStyleType(String whiskeyType) {
        this.whiskeyType = whiskeyType;
    }
}
