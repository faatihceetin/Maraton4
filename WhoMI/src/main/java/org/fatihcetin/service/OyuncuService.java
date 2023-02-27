package org.fatihcetin.service;


import org.fatihcetin.dto.request.OyuncuRequestSave;
import org.fatihcetin.dto.response.OyuncuResponseDto;
import org.fatihcetin.exception.ErrorType;
import org.fatihcetin.exception.WhoMIException;
import org.fatihcetin.mapper.IOyuncuMapper;
import org.fatihcetin.repository.IOyuncuRepository;
import org.fatihcetin.repository.entity.Oyuncu;
import org.fatihcetin.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OyuncuService extends ServiceManager<Oyuncu,Long> {
    private final IOyuncuRepository oyuncuRepository;
    public OyuncuService(IOyuncuRepository oyuncuRepository){
        super(oyuncuRepository);
        this.oyuncuRepository = oyuncuRepository;
    }

    public void save(OyuncuRequestSave oyuncuRequestSave){
        Oyuncu oyuncu = IOyuncuMapper.INSTANCE.toOyuncu(oyuncuRequestSave);
        if(oyuncu == null ){throw new WhoMIException(ErrorType.INTERNAL_ERROR);

        }save(oyuncu);

    }
    public List<OyuncuResponseDto> findAllDto(){
        List<OyuncuResponseDto> dtoList=new ArrayList<>();
        for (Oyuncu oyuncu : findAll()){
            OyuncuResponseDto dto= IOyuncuMapper.INSTANCE.toDto(oyuncu);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public void updateDto(OyuncuRequestSave dto){
        Oyuncu oyuncu= IOyuncuMapper.INSTANCE.toOyuncu(dto);

        save(oyuncu);
    }
}
