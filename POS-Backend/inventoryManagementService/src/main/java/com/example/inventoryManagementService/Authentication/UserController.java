package com.example.inventoryManagementService.Authentication;


import com.example.inventoryManagementService.customExceptions.InvalidUsernameOrPasswordException;
import com.example.inventoryManagementService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public boolean getUser(@RequestParam String name,@RequestParam String password){
        try {
            return userService.authenticateUser(name,password);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User user){
        try {
            return userService.postUser(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
    @GetMapping("/auth/id/{id}")
    public User addUser(@PathVariable int id){
        try {
            return userService.getUser(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

}
