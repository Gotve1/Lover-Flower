package loverflower.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private Long order_id;

    private String method;
    private Long amount;
}
