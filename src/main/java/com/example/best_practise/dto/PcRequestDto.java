package com.example.best_practise.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcRequestDto {

  @NotBlank
  private String name;

  @NotBlank
  private String model;

  @NotNull
  private Integer year;

}
