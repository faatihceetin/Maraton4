package org.fatihcetin.mapper;

import org.fatihcetin.dto.request.OyuncuRequestSave;
import org.fatihcetin.dto.response.OyuncuResponseDto;
import org.fatihcetin.repository.entity.Oyuncu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOyuncuMapper {
    IOyuncuMapper INSTANCE = Mappers.getMapper(IOyuncuMapper.class);
    Oyuncu toOyuncu(final OyuncuRequestSave dto);
    OyuncuResponseDto toDto(final Oyuncu oyuncu);
}
