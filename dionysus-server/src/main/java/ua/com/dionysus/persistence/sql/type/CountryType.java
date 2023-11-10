package ua.com.dionysus.persistence.sql.type;

import lombok.Getter;

@Getter
public enum  CountryType {

    BARBADOS("Barbados"),
    UNITED_STATES("United States"),
    PUERTO_RICO("Puerto Rico"),
    SCOTLAND("Scotland"),
    SWITZERLAND("Switzerland"),
    IRELAND("Ireland"),
    JAPAN("Japan"),
    JAMAICA("Jamaica"),
    DOMINICAN_REPUBLIC("Dominican Republic"),
    CANADA("Canada"),
    GERMANY("Germany"),
    FRANCE("France"),
    MEXICO("Mexico"),
    VENEZUELA("Venezuela"),
    ITALY("Italy"),
    TRINIDAD_AND_TOBAGO("Trinidad and tobago"),
    PANAMA("Panama"),
    GUATEMALA("Guatemala"),
    ARGENTINA("Argentina"),
    GREECE("Greece"),
    NEW_ZEALAND("New Zealand"),
    USA("USA");

    private final String countryType;

    CountryType(String countryType) {
        this.countryType = countryType;
    }
}
