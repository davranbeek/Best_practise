package com.example.best_practise.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

  @NotBlank
  private String userName;

  @NotBlank
  private String email;

  @NotNull
  private Integer phoneNumber;

}
