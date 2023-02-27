package org.fatihcetin.mapper;


import org.fatihcetin.dto.request.SoruSaveRequestDto;
import org.fatihcetin.dto.response.SoruResponseDto;
import org.fatihcetin.repository.entity.Soru;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISoruMapper {
    ISoruMapper INSTANCE = Mappers.getMapper(ISoruMapper.class);

    Soru soru(final SoruSaveRequestDto dto);

    SoruResponseDto toDto(final Soru soru);

}
