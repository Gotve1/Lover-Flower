package loverflower.service;

import loverflower.dto.UserDto;
import loverflower.model.Result;
import loverflower.model.User;
import loverflower.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public Result create(UserDto userDto){
        User user = new User();
        user.setName(userDto.getFull_name());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        userRepo.save(user);
        return new Result(true,"User created successfully");
    }

    public Result update(Long id,UserDto userDto){
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setName(userDto.getFull_name());
            user.setEmail(userDto.getEmail());
            user.setPhone(userDto.getPhone());
            userRepo.save(user);
            return new Result(true,"User updated successfully");
        }
        return new Result(false,"User not found");
    }

    public Result delete(Long id){
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()){
            userRepo.deleteById(id);
            return new Result(true,"User deleted successfully");
        }
        return new Result(false,"User not found");
    }

}
