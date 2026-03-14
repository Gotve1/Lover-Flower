package loverflower.service;

import loverflower.DTO.UserRequesDto;
import loverflower.DTO.UserResponseDto;
import loverflower.exception.UserNotFoundException;
import loverflower.model.User;
import loverflower.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserResponseDto createUser(UserRequesDto dto) {
        User user = new User();
        user.setName(dto.name());
        user.setPassword(dto.password());
        user.setEmail(dto.email());
        user.setPhone(dto.phone());
        user.setAddress(dto.address());
        user.setCart(Arrays.toString(dto.cart()));
        user = userRepo.save(user);

        return toResponseDto(user);
    }

    public UserResponseDto getUserById(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return toResponseDto(user);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepo.findAll().stream().map(this::toResponseDto).toList();
    }

    public UserResponseDto updateUser(Long id, UserRequesDto dto) {
        User user = getUserEntity(id);
        user.setName(dto.name());
        user.setPassword(dto.password());
        user.setEmail(dto.email());
        user.setPhone(dto.phone());
        user.setAddress(dto.address());
        user.setCart(Arrays.toString(dto.cart()));

        return toResponseDto(userRepo.save(user));
    }

    public UserResponseDto deleteUser(Long id) {
        User user = getUserEntity(id);
        userRepo.delete(user);
        return toResponseDto(user);
    }

    private User getUserEntity(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private UserResponseDto toResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setPassword(dto.getPassword());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setAddress(user.getAddress());
        dto.setCart(user.getCart());
        return dto;
    }
}
