package org.fatihcetin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OyunCevapRequestDto {
    Long userId;
    Long soruId;
    String cevap;
    int hak;

}
