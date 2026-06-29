package be.bstorm.tf_java_2026_rcd_bend.services;

import be.bstorm.tf_java_2026_rcd_bend.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<Product> getProducts(Pageable pageable);
}
