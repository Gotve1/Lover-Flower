package loverflower.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

/*
@Data
public class UserRequesDto {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100)
    private String name;


    @Email(message = "Invalid email format")
    private String email;

    private String password;
    private String phone;
    private String address;
    private String cart;
}
*/


public record UserRequesDto(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 100)
        String name,

        @Email(message = "Invalid email format")
        String email,

        String password,
        String phone,
        String address,
        String[] cart
) {}