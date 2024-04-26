package ru.kostapo.mttapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.kostapo.mttapp.dto.OrganizationResponseDTO;
import ru.kostapo.mttapp.entity.Organization;

import java.util.List;

@Mapper(uses = {AddressMapper.class, DirectorMapper.class}) public interface OrganizationMapper { OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);


    @Mapping(source = "post", target = "postAddress")
    @Mapping(source = "fact", target = "factAddress")
    @Mapping(source = "director", target = "director")
    @Mapping(source = "branches", target = "branches")
    OrganizationResponseDTO organizationToOrganizationResponseDTO(Organization organization);

    List<OrganizationResponseDTO> organizationsToOrganizationResponseDTOs(List<Organization> organizations);
}