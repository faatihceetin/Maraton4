package org.fatihcetin.dto.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SoruSaveRequestDto {

    String soru;
    String imagenameblur;
    String imagename;
    int tahminsayısı;
    int puan;
    String dogruCevap;

}
