package loverflower.controller;

import loverflower.dto.UserDto;
import loverflower.model.Result;
import loverflower.model.User;
import loverflower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN','SUPER_ADMIN')")
    public List<User>   getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return allUsers;
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN','SUPER_ADMIN')")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN','SUPER_ADMIN')")
    public Result addUser(@RequestBody UserDto userDto){
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN','SUPER_ADMIN')")
    public Result updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        return userService.update(id,userDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN','SUPER_ADMIN')")
    public Result deleteUser(@PathVariable Long id){
        return userService.delete(id);
    }



}
