package loverflower.DTO;

import lombok.Data;

@Data
public class UserResponseDto {
    private long Id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
