package org.fatihcetin.service;


import org.fatihcetin.dto.request.OyunCevapRequestDto;
import org.fatihcetin.mapper.IOyunMapper;
import org.fatihcetin.repository.IOyunRepository;
import org.fatihcetin.repository.entity.Oyun;
import org.fatihcetin.repository.entity.Oyuncu;
import org.fatihcetin.repository.entity.Soru;
import org.fatihcetin.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class OyunService extends ServiceManager<Oyun,Long> {
    private final IOyunRepository oyunRepository;
    private final OyuncuService oyuncuService;
    private final SoruService soruService;


    public OyunService(IOyunRepository oyunRepository, OyuncuService oyuncuService, SoruService soruService){
        super(oyunRepository);
        this.oyunRepository = oyunRepository;
        this.oyuncuService = oyuncuService;
        this.soruService = soruService;

    }

    public  String OyunveCevap(OyunCevapRequestDto dto){
        Oyuncu oyuncu = oyuncuService.findById(dto.getUserId()).get();
        Soru soru = soruService.findById(dto.getSoruId()).get();
        Oyun oyun = IOyunMapper.INSTANCE.toOyun(dto);
        oyun.setHak(5);
        while(soru.getDogruCevap() == dto.getCevap() || oyun.getHak() > 0){
            oyuncu.setPuan(oyuncu.getPuan() + soru.getPuan());
            return "doğru cevap punanın " + soru.getPuan() + " arttı " ;

        }
        while (soru.getDogruCevap() != dto.getCevap() || oyun.getHak() > 0) {
            oyun.setHak(oyun.getHak()-1);
            return "yanlış cevap verdiniz hakkınız bir azaldı";
        }




    }

}
