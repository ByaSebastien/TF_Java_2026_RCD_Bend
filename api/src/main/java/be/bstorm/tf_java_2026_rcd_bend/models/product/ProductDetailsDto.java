package be.bstorm.tf_java_2026_rcd_bend.models.product;

import be.bstorm.tf_java_2026_rcd_bend.entities.Product;

import java.util.UUID;

public record ProductDetailsDto(
        UUID id,
        String name,
        String description,
        double price
) {

    public static ProductDetailsDto fromProduct(Product product) {
        return new ProductDetailsDto(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
