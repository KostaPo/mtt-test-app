package ru.kostapo.mttapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrganizationResponseDTO {
    private String fullName;
    private DirectorResponseDTO director;
    private AddressResponseDTO postAddress;
    private AddressResponseDTO factAddress;
    private List<OrganizationResponseDTO> branches;
}
