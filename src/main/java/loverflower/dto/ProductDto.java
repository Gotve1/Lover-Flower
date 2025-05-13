package loverflower.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String image_url;
    @Column(nullable = false)
    private Long category_id;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false)
    private String occasion;
    @Column(nullable = false)
    private String type;
}
