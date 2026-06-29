package be.bstorm.tf_java_2026_rcd_bend.controllers;

import be.bstorm.tf_java_2026_rcd_bend.entities.Product;
import be.bstorm.tf_java_2026_rcd_bend.models.product.ProductIndexDto;
import be.bstorm.tf_java_2026_rcd_bend.models.shared.CustomPage;
import be.bstorm.tf_java_2026_rcd_bend.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<CustomPage<ProductIndexDto>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Product> productPage = productService.getProducts(PageRequest.of(page, size));

        List<ProductIndexDto> productIndexDtoList = productPage.getContent().stream()
                .map(ProductIndexDto::fromProduct)
                .toList();

        CustomPage<ProductIndexDto> customPage = new CustomPage<ProductIndexDto>(
                productIndexDtoList,
                productPage.getTotalElements(),
                productPage.getTotalPages(),
                productPage.getNumber(),
                productPage.getSize()
        );

        return ResponseEntity.ok(customPage);
    }
}
