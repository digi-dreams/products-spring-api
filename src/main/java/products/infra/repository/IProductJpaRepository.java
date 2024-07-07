package products.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import products.domain.model.Product;

public interface IProductJpaRepository extends JpaRepository<Product, Long> {

}
