package ru.kostapo.mttapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.kostapo.mttapp.dto.DirectorResponseDTO;
import ru.kostapo.mttapp.entity.Director;

@Mapper
public interface DirectorMapper {
    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "dob", target = "dob")
    DirectorResponseDTO directorToDirectorResponseDTO(Director director);
}