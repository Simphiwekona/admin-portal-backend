package com.example.backend.controller;

import com.example.backend.dto.ProductDto;
import com.example.backend.dto.UserDto;
import com.example.backend.entity.User;
import com.example.backend.service.ProductService;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:3000")
public class AuthController {


    @Autowired
    private UserService userService;

    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUSers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<UserDto> createdUser(@RequestBody UserDto userDto){
        UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @PostMapping("/product")
    public ResponseEntity<ProductDto> product(@RequestBody ProductDto productDto){
        ProductDto product = productService.product(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UserDto userDto){
        UserDto updateUser = userService.updateUser(userId, userDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
