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
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<User> user_id;
    @Column(nullable = false)
    private String items;
    @OneToMany
    private List<Product> product_id;
    @Column(nullable = false)
    private String quantity;
    @Column(nullable = false)
    private Long total_price;
}
