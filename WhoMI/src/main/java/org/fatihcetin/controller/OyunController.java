package org.fatihcetin.controller;
import lombok.RequiredArgsConstructor;
import org.fatihcetin.dto.request.OyunCevapRequestDto;
import org.fatihcetin.service.OyunService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.fatihcetin.constants.EndPoints.*;


@RestController
@RequestMapping(VERSION+API+OYUN)
@RequiredArgsConstructor
public class OyunController {
    private final OyunService oyunService;
    @PostMapping(SAVE)
    public ResponseEntity<String> oyunbaşlangıç(@RequestBody OyunCevapRequestDto dto){
        return ResponseEntity.ok(oyunService.OyunveCevap(dto));
    }
}
