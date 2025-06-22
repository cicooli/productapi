package oli.productapi.service;

import oli.productapi.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(UUID productId);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(UUID id, ProductDto updatedProductDto);

    void deleteProduct(UUID id);
}
