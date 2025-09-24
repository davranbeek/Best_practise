package com.example.best_practise.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

  @NotBlank(message = "Ism bo'sh bo'lishi mumkin emas")
  private String userName;

  @NotBlank(message = "Email formati noto'g'ri!!")
  private String email;

  @Pattern(regexp = "^\\+998\\d{9}$", message = "Telefon formati noto'g'ri!!")
  private String phoneNumber;
}