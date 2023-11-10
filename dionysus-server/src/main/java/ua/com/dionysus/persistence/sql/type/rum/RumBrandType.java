package ua.com.dionysus.persistence.sql.type.rum;

import lombok.Getter;

@Getter
public enum RumBrandType {

    APPLETON_ESTATE("Appleton Estate"),
    BACARDI("BACARDÍ"),
    COLINA_COLADA("Colina Colada"),
    DON_PANCHO("Don Pancho"),
    MATUSALEM("Matusalem"),
    PYRAT_XO_RESERVE("Pyrat XO Reserve"),
    SANTA_TERESA("Santa Teresa"),
    STOLEN("Stolen"),
    ZACAPA("Zacapa"), PLANTATION("Plantation");

    private final String rumBrandType;

    RumBrandType(String rumBrandType) {
        this.rumBrandType = rumBrandType;
    }
}
