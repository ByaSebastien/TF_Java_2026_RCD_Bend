package be.bstorm.tf_java_2026_rcd_bend.seeds;

import be.bstorm.tf_java_2026_rcd_bend.entities.Product;
import be.bstorm.tf_java_2026_rcd_bend.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeed implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        if(productRepository.count()==0){
            List<Product> products = List.of(
                    new Product("Product 1", "...", 42.09),
                    new Product("Product 2", "...", 12.14),
                    new Product("Product 3", "...", 156.89)
            );

            productRepository.saveAll(products);
        }

    }
}
