package products.application.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record ProductResponse(
        Long id,
        String name,
        BigDecimal price,
        Integer quantity,
        String description,
        String imageUrl,
        Set<String> categories,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
