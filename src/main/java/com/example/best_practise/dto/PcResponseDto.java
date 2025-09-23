package com.example.best_practise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcResponseDto {

  private Long id;

  private String name;

  private String model;

  private Integer year;

}
