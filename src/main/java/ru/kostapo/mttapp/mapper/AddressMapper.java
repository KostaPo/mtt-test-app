package ru.kostapo.mttapp.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.kostapo.mttapp.dto.AddressResponseDTO;
import ru.kostapo.mttapp.entity.Address;

@Mapper
public interface AddressMapper {

    @Mapping(target = "address", source = "address")
    AddressResponseDTO addressToAddressResponseDTO(Address address);

    @AfterMapping
    default void trimAddress(Address address, @MappingTarget AddressResponseDTO addressResponseDTO) {
        addressResponseDTO.setAddress(address.getAddress().substring(7));
    }
}