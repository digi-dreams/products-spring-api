package products.domain.service.contract;

import products.application.dto.request.ProductRequest;
import products.application.dto.response.ProductResponse;

import java.util.List;

public interface IProductService {

    List<ProductResponse> getProducts();

    ProductResponse findProductById(Long id);

    ProductResponse saveProduct(ProductRequest request);

    ProductResponse updateProduct(Long id, ProductRequest request);

    void deleteProductById(Long id);
}
