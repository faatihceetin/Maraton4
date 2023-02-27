package org.fatihcetin.controller;

import lombok.RequiredArgsConstructor;
import org.fatihcetin.dto.request.SoruSaveRequestDto;
import org.fatihcetin.dto.response.SoruResponseDto;
import org.fatihcetin.service.SoruService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.fatihcetin.constants.EndPoints.FINDALL;
import static org.fatihcetin.constants.EndPoints.SAVE;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class SoruController {
    private final SoruService soruService;
    @PostMapping(SAVE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<Boolean> createSoru(@RequestBody SoruSaveRequestDto dto){
        soruService.save(dto);
        return ResponseEntity.ok(true);
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<SoruResponseDto>>  findAll(){
        return ResponseEntity.ok(soruService.findAllDto());
    }

}
