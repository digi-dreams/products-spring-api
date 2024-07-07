package products.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import products.application.dto.request.ProductRequest;
import products.application.dto.response.ProductResponse;
import products.domain.enums.ECategory;
import products.domain.model.Product;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "price", source = "product.price")
    @Mapping(target = "quantity", source = "product.quantity")
    @Mapping(target = "description", source = "product.description")
    @Mapping(target = "imageUrl", source = "product.imageUrl")
    @Mapping(target = "categories", source = "product.categories", qualifiedByName = "categoriesToStringSet")
    @Mapping(target = "createdAt", source = "product.createdAt")
    @Mapping(target = "updatedAt", source = "product.updatedAt")
    ProductResponse toProductResponse(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "productRequest.name")
    @Mapping(target = "price", source = "productRequest.price")
    @Mapping(target = "quantity", source = "productRequest.quantity")
    @Mapping(target = "description", source = "productRequest.description")
    @Mapping(target = "imageUrl", source = "productRequest.imageUrl")
    @Mapping(target = "categories", source = "productRequest.categories")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Product toProduct(ProductRequest productRequest);

    @Mapping(target = "id", source = "oldProduct.id")
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "price", source = "request.price")
    @Mapping(target = "quantity", source = "request.quantity")
    @Mapping(target = "description", source = "request.description")
    @Mapping(target = "imageUrl", source = "request.imageUrl")
    @Mapping(target = "categories", source = "request.categories")
    @Mapping(target = "createdAt", source = "oldProduct.createdAt")
    @Mapping(target = "updatedAt", source = "oldProduct.updatedAt")
    Product toNewProduct(Product oldProduct, ProductRequest request);

    @Named("categoriesToStringSet")
    default Set<String> categoriesToStringSet(Set<ECategory> categories) {
        if (categories == null) {
            return new HashSet<>();
        }

        return categories.stream()
                .map(Enum::name)
                .collect(Collectors.toSet());
    }
}
