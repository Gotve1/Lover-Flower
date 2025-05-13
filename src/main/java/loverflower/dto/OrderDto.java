package loverflower.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {


    private Long user_id;
    @Column(nullable = false)
    private Long totalPrice;
    @Column(nullable = false)
    private String deliveryAddress;
    @Column(nullable = false)
    private String paymentMethod;
    @Column(nullable = false)
    private String orderNumber;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Long quantity;
}
