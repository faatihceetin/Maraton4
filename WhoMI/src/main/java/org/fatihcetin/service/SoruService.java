package org.fatihcetin.service;


import org.fatihcetin.dto.request.SoruSaveRequestDto;
import org.fatihcetin.dto.response.SoruResponseDto;
import org.fatihcetin.exception.ErrorType;
import org.fatihcetin.exception.WhoMIException;
import org.fatihcetin.mapper.ISoruMapper;
import org.fatihcetin.repository.ISoruRepository;
import org.fatihcetin.repository.entity.Soru;
import org.fatihcetin.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoruService extends ServiceManager<Soru,Long> {

    private final ISoruRepository soruRepository;
    
    public  SoruService(ISoruRepository soruRepository){
        super(soruRepository);
        this.soruRepository = soruRepository;
 
    }
    public void save(SoruSaveRequestDto dto){
        Soru soru= ISoruMapper.INSTANCE.soru(dto);
        if(soru == null)
            throw new WhoMIException(ErrorType.KULLANICI_BULUNAMADI,"soru zaten mevcut");

        save(soru);
    }
    public List<SoruResponseDto> findAllDto(){
        List<SoruResponseDto> dtoList=new ArrayList<>();
        for (Soru soru : findAll()){
            SoruResponseDto dto= ISoruMapper.INSTANCE.toDto(soru);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
