package loverflower.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponseDto {
    private long Id;
    private String name;
    private List<String> roles = new ArrayList<>();
    private String password;
    private String email;
    private String phone;
    private String address;
    private String cart;
}
