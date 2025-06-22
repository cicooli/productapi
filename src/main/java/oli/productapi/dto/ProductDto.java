package oli.productapi.dto;
import java.math.BigDecimal;
import java.util.UUID;

public record ProductDto(
         UUID id,
         String name,
         String description,
         BigDecimal price,
         Integer stockLevel
) {}
