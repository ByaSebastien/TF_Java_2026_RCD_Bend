package be.bstorm.tf_java_2026_rcd_bend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false) @ToString
public class Product {

    @Getter
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private double price;

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
