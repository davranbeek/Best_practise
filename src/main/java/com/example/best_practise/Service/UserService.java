package com.example.best_practise.Service;

import com.example.best_practise.dto.UserRequestDto;
import com.example.best_practise.dto.UserResponseDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  List<UserResponseDto> getUsers();

  UserResponseDto getUser(Long id);

  void  createUser(UserRequestDto userRequestDto);

  void updateUser(Long id, UserRequestDto userRequestDto);

  void deleteUser(Long id);

}
