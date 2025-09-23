package com.example.best_practise.Service;

import com.example.best_practise.dto.PcRequestDto;
import com.example.best_practise.dto.PcResponseDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PcService {

  List<PcResponseDto> getPcs();

  PcResponseDto getPc(Long id);

  void createPc(PcRequestDto pcRequestDto);

  void updatePc(Long id, PcRequestDto pcRequestDto);

  void deletePc(Long id);

}
