package org.fatihcetin.controller;
import lombok.RequiredArgsConstructor;
import org.fatihcetin.dto.request.OyuncuRequestSave;
import org.fatihcetin.dto.response.OyuncuResponseDto;
import org.fatihcetin.repository.entity.Oyuncu;
import org.fatihcetin.service.OyuncuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.fatihcetin.constants.EndPoints.*;
import static org.fatihcetin.constants.EndPoints.VERSION;


@RestController
@RequestMapping(VERSION+API+OYUNCU)
@RequiredArgsConstructor
public class OyuncuController {
    private final OyuncuService oyuncuService;
    @PostMapping(SAVE)
    public ResponseEntity<String>  createOyuncu(@RequestBody OyuncuRequestSave dto){
        oyuncuService.save(dto);
        return ResponseEntity.ok("oyuncu save edildi");
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<OyuncuResponseDto>>  findAll(){
        return ResponseEntity.ok(oyuncuService.findAllDto());

    }
    @PostMapping(UPDATE)
    public ResponseEntity<String> updateOyuncu(@RequestBody OyuncuRequestSave dto){
        oyuncuService.updateDto(dto);
        return ResponseEntity.ok("oyuncu update edildi");
    }


}
