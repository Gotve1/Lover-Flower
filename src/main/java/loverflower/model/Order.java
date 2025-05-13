package loverflower.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import loverflower.model.Entity.DeliveryStatus;
import loverflower.model.Entity.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<User> user_id;

    @Column(nullable = false)
    private Long totalPrice; // Umumiy narx Long sifatida

    @Enumerated(EnumType.STRING)
    private Status status; // Buyurtma holati (masalan, "pending", "shipped")

    @Column(nullable = false)
    private LocalDateTime createdAt; // Buyurtma yaratilgan vaqt

    @Column(nullable = false)
    private String deliveryAddress; // Yetkazib berish manzili

    @Column(nullable = false)
    private LocalDate deliveryDate;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private String orderNumber;

    @OneToMany
    private List<Product> productId;

    @Column(nullable = false)
    private Long quantity;
}
