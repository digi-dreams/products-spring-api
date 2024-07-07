package products.domain.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import products.application.dto.request.ProductRequest;
import products.application.dto.response.ProductResponse;
import products.application.mapper.IProductMapper;
import products.domain.model.Product;
import products.domain.repository.IProductRepository;
import products.domain.service.contract.IProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductMapper mapper;
    private final IProductRepository repository;

    @Override
    public List<ProductResponse> getProducts() {
        return repository.getProducts()
                .stream()
                .map(mapper::toProductResponse)
                .toList();
    }

    @Override
    public ProductResponse findProductById(Long id) {
        return mapper.toProductResponse(findById(id));
    }

    @Override
    public ProductResponse saveProduct(ProductRequest request) {
        return mapper.toProductResponse(repository
                .saveProduct(mapper.toProduct(request)));
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        var product = mapper.toProduct(request);
        product.setId(id);

        return mapper.toProductResponse(repository.saveProduct(product));
    }

    @Override
    public void deleteProductById(Long id) {
        findById(id);
        repository.deleteProductById(id);
    }

    private Product findById(Long id) {
        return repository.findProductById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + id));
    }
}
