package oli.productapi.service.impl;

import lombok.AllArgsConstructor;
import oli.productapi.dto.ProductDto;
import oli.productapi.exception.ResourceNotFoundException;
import oli.productapi.mapper.ProductMapper;
import oli.productapi.model.Product;
import oli.productapi.repository.ProductRepository;
import oli.productapi.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.toProductEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(UUID productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        return ProductMapper.toProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::toProductDto).toList();
    }

    @Override
    public ProductDto updateProduct(UUID id, ProductDto updatedProductDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        product.setName(updatedProductDto.name());
        product.setDescription(updatedProductDto.description());
        product.setPrice(updatedProductDto.price());
        product.setStockLevel(updatedProductDto.stockLevel());

        Product updatedProduct = productRepository.save(product);

        return ProductMapper.toProductDto(updatedProduct);
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found with id: " + id));
        productRepository.deleteById(id);
    }

}

