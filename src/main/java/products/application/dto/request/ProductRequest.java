package products.application.dto.request;

import products.domain.enums.ECategory;

import java.math.BigDecimal;
import java.util.Set;

public record ProductRequest(
        String name,
        BigDecimal price,
        Integer quantity,
        String description,
        String imageUrl,
        Set<ECategory> categories
) {
}
