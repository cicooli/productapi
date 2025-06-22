package oli.productapi.mapper;

import oli.productapi.dto.ProductDto;
import oli.productapi.model.Product;

public class ProductMapper {

    public static ProductDto toProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStockLevel()
        );
    }

    public static Product toProductEntity(ProductDto productDto) {
        return new Product(
                productDto.id(),
                productDto.name(),
                productDto.description(),
                productDto.price(),
                productDto.stockLevel()
        );
    }
}
