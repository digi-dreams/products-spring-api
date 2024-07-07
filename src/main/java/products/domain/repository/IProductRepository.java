package products.domain.repository;

import products.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {

    List<Product> getProducts();

    Optional<Product> findProductById(Long id);

    Product saveProduct(Product product);

    void deleteProductById(Long id);
}
