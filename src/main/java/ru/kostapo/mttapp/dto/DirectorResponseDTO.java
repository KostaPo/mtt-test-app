package ru.kostapo.mttapp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DirectorResponseDTO {
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
