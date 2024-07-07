package products.application.controller.contract;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import products.application.dto.request.ProductRequest;
import products.application.dto.response.ProductResponse;

public interface IProductController {

    @GetMapping
    List<ProductResponse> getAll();

    @GetMapping("{id}")
    ProductResponse getById(@PathVariable Long id);

    @PostMapping
    ProductResponse save(@RequestBody @Valid ProductRequest request);

    @PutMapping("{id}")
    ProductResponse update(@PathVariable Long id, @RequestBody @Valid ProductRequest request);

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id);
}
