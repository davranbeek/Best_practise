package com.example.best_practise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

  private Long id;

  private String userName;

  private String email;

  private Integer phoneNumber;
}
