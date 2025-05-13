package loverflower.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String image_url;
    @OneToMany
    private List<Category> category_id;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false)
    private String occasion;
    @Column(nullable = false)
    private String type;


}
