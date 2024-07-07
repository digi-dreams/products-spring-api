package products.infra.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import products.domain.model.Product;
import products.domain.repository.IProductRepository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements IProductRepository {

    private final IProductJpaRepository jpaRepository;

    @Override
    public List<Product> getProducts() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return jpaRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        jpaRepository.deleteById(id);
    }
}
