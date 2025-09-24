package com.example.best_practise.Controller;

import com.example.best_practise.Service.UserService;
import com.example.best_practise.dto.UserRequestDto;
import com.example.best_practise.dto.UserResponseDto;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping
  ResponseEntity<List<UserResponseDto>> getUsers() {
    return ResponseEntity.ok(userService.getUsers());
  }

  @GetMapping("{id}")
  ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
    return ResponseEntity.ok(userService.getUser(id));
  }

  @PostMapping
  ResponseEntity<Void> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
    userService.createUser(userRequestDto);
    return ResponseEntity.ok().build();
  }

  @PatchMapping("{id}")
  ResponseEntity<Void> updateUser(@PathVariable Long id,
      @Valid @RequestBody UserRequestDto userRequestDto) {
    userService.updateUser(id, userRequestDto);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("{id}")
  ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.ok().build();
  }
}