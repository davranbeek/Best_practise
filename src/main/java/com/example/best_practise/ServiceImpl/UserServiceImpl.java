package com.example.best_practise.ServiceImpl;

import com.example.best_practise.Entity.UserEntity;
import com.example.best_practise.Repository.UserRepository;
import com.example.best_practise.Service.UserService;
import com.example.best_practise.dto.UserRequestDto;
import com.example.best_practise.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  private UserResponseDto mapToResponse(UserEntity user) {
    return new UserResponseDto(
        user.getId(),
        user.getUserName(),
        user.getEmail(),
        user.getPhoneNumber()
    );
  }

  private UserEntity mapToEntity(UserRequestDto dto) {
    UserEntity user = new UserEntity();
    user.setUserName(dto.getUserName());
    user.setEmail(dto.getEmail());
    user.setPhoneNumber(dto.getPhoneNumber());
    return user;
  }

  @Override
  public List<UserResponseDto> getUsers() {
    return userRepository.findAll()
        .stream()
        .map(this::mapToResponse)
        .collect(Collectors.toList());
  }

  @Override
  public UserResponseDto getUser(Long id) {
    return userRepository.findById(id)
        .map(this::mapToResponse)
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));
  }

  @Override
  public void createUser(UserRequestDto userRequestDto) {
    UserEntity user = mapToEntity(userRequestDto);
    userRepository.save(user);
  }

  @Override
  public void updateUser(Long id, UserRequestDto userRequestDto) {
    UserEntity existingUser = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found with id " + id));

    existingUser.setUserName(userRequestDto.getUserName());
    existingUser.setEmail(userRequestDto.getEmail());
    existingUser.setPhoneNumber(userRequestDto.getPhoneNumber());

    userRepository.save(existingUser);
  }

  @Override
  public void deleteUser(Long id) {
    if (!userRepository.existsById(id)) {
      throw new RuntimeException("User not found with id " + id);
    }
    userRepository.deleteById(id);
  }
}
