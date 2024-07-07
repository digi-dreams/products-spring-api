package products.domain.enums;

import lombok.*;

@Getter
@AllArgsConstructor
public enum ECategory {

    ELECTRONICS("Electronics"),
    CLOTHING("Clothing"),
    HOME_APPLIANCES("Home Appliances"),
    BOOKS("Books"),
    BEAUTY_HEALTH("Beauty & Health"),
    SPORTS("Sports"),
    GARDEN("Garden"),
    TOYS("Toys");

    private final String value;
}
