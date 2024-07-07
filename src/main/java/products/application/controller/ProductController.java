package products.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import products.application.controller.contract.IProductController;
import products.application.dto.request.ProductRequest;
import products.application.dto.response.ProductResponse;
import products.domain.service.contract.IProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController implements IProductController {

    private final IProductService productService;

    @Override
    public List<ProductResponse> getAll() {
        return productService.getProducts();
    }

    @Override
    public ProductResponse getById(Long id) {
        return productService.findProductById(id);
    }

    @Override
    public ProductResponse save(ProductRequest request) {
        return productService.saveProduct(request);
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        return productService.updateProduct(id, request);
    }

    @Override
    public void delete(Long id) {
        productService.deleteProductById(id);
    }
}
