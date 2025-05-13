package loverflower.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private Long user_id;
    private String items;
    private Long product_id;
    private String quantity;
    private Long total_price;
}
