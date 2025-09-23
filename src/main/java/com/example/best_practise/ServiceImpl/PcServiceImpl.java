package com.example.best_practise.ServiceImpl;

import com.example.best_practise.Mapper.PcMapper;
import com.example.best_practise.Repository.PcRepository;
import com.example.best_practise.Service.PcService;
import com.example.best_practise.dto.PcRequestDto;
import com.example.best_practise.dto.PcResponseDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PcServiceImpl implements PcService {

  private final PcRepository pcRepository;
  private final PcMapper pcMapper;

  public List<PcResponseDto> getPcs() {
    var pcs = pcRepository.findAll();
    List<PcResponseDto> list = new ArrayList<>();

    pcs.forEach(pc -> {
      var dto = pcMapper.toDto(pc);
      list.add(dto);
    });
    return list;
  }

  public PcResponseDto getPc(Long id) {
    var pc = pcRepository.findById(id).orElseThrow();
    var dto = pcMapper.toDto(pc);
    return dto;
  }

  @Override
  public void createPc(PcRequestDto pcRequestDto) {
    var pc = pcMapper.toEntity(pcRequestDto);
    pc.setCreatedAt(LocalDateTime.now());
    pc.setUpdatedAt(LocalDateTime.now());
    pcRepository.save(pc);
  }

  @Override
  public void updatePc(Long id, PcRequestDto pcRequestDto) {
    var pc = pcRepository.findById(id).orElseThrow();
    pc.setName(pcRequestDto.getName());
    pc.setModel(pcRequestDto.getModel());
    pc.setYear(pcRequestDto.getYear());
    pcRepository.save(pc);

  }

  @Override
  public void deletePc(Long id) {
    var pc = pcRepository.findById(id).orElseThrow();
    pc.setDeletedAt(LocalDateTime.now());
    pcRepository.save(pc);

    pcRepository.deleteById(id);
  }
}
