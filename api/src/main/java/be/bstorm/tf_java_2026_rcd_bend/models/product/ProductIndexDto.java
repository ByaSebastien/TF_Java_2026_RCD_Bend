package be.bstorm.tf_java_2026_rcd_bend.models.product;

import be.bstorm.tf_java_2026_rcd_bend.entities.Product;

import java.util.UUID;

public record ProductIndexDto(
        UUID id,
        String name,
        double price
) {

    public static ProductIndexDto fromProduct(Product product) {
        return new ProductIndexDto(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
