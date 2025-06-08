package loverflower.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequesDto {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100)
    private String name;


    @Email(message = "Invalid email format")
    private String email;

    private String phone;
    private String address;
    private String cart;
}
