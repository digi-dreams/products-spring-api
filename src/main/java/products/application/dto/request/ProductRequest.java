package products.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import products.domain.enums.ECategory;

import java.math.BigDecimal;
import java.util.Set;

public record ProductRequest(
        @NotBlank
        String name,
        @NotNull
        BigDecimal price,
        @NotNull
        Integer quantity,
        String description,
        String imageUrl,
        @NotNull
        Set<ECategory> categories
) {
}
