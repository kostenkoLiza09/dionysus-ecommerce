package ua.com.dionysus.persistence.sql.type.whiskey;

import lombok.Getter;

@Getter
public enum WhiskeyBrandType {

    ABERFELDY("Aberfeldy"), ARRAN("Arran"), AUCHENTOSHAN("Auchentoshan"),
    BALCONES("Balcones"), BARENJAGER("Bärenjäger"), BEARFACE("Bearface"), BULLEIT("Bulleit"),
    CASCADE_MOON("Cascade Moon"), CHIVAS_REGAL("Chivas Regal"),
    DEVLIN("Devlin"), DUBLIN_INK("Dublin Ink"), ELVIS_WHISKEY("Elvis Whiskey"),
    GOLDEN_MOON("Golden Moon"), JACK_DANIELS("Jack Daniel's"), JAMESON("Jameson"), KIKORI("Kikori"),
    MASAHIRO("Masahiro"), OLD_POTRERO("Old Potrero"), SANTA_FE_SPIRITS("Santa Fe Spirits"), UNCLE_NEAREST("Uncle Nearest"),
    WOLVES("Wolves"), YAMAZAKI("Yamazaki"), JIM_BEAM("Jim Beam"), JURA("Jura");

    private final String whiskeyBrandType;

    WhiskeyBrandType(String whiskeyBrand) {
        this.whiskeyBrandType = whiskeyBrand;
    }
}
