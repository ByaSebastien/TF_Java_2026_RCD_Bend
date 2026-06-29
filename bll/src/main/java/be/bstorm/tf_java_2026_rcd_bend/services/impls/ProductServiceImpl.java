package be.bstorm.tf_java_2026_rcd_bend.services.impls;

import be.bstorm.tf_java_2026_rcd_bend.entities.Product;
import be.bstorm.tf_java_2026_rcd_bend.repositories.ProductRepository;
import be.bstorm.tf_java_2026_rcd_bend.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getProductById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}
