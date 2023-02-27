package org.fatihcetin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SoruResponseDto {

    String soru;
    String imagenameblur;
    String imagename;
    int tahminsayısı;
    int puan;


}
