package com.example.best_practise.Controller;

import com.example.best_practise.Service.PcService;
import com.example.best_practise.dto.PcRequestDto;
import com.example.best_practise.dto.PcResponseDto;
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
@RequestMapping("/api/pcs")
@RequiredArgsConstructor
public class PcController {

  private final PcService pcService;

  @GetMapping
  ResponseEntity<List<PcResponseDto>> getPcs() {
    return ResponseEntity.ok(pcService.getPcs());
  }

  @GetMapping("{id}")
  ResponseEntity<PcResponseDto> getPc(@PathVariable Long id) {
    return ResponseEntity.ok(pcService.getPc(id));
  }

  @PostMapping
  ResponseEntity<Void> createPc(@RequestBody PcRequestDto requestDto) {
    pcService.createPc(requestDto);
    return ResponseEntity.ok().build();
  }

  @PatchMapping("{id}")
  ResponseEntity<Void> updatePc(@PathVariable Long id,
      @Valid @RequestBody PcRequestDto pcRequestDto) {
    pcService.updatePc(id, pcRequestDto);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("{id}")
  ResponseEntity<Void> deletePc(@PathVariable Long id) {
    pcService.deletePc(id);
    return ResponseEntity.ok().build();
  }

}
