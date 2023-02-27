package org.fatihcetin.mapper;

import org.fatihcetin.dto.request.OyunCevapRequestDto;
import org.fatihcetin.repository.entity.Oyun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOyunMapper {
    IOyunMapper INSTANCE = Mappers.getMapper(IOyunMapper.class);
    Oyun toOyun(final OyunCevapRequestDto dto);


}
