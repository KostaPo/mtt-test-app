package ru.kostapo.mttapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

@Entity
@Table(name = "organizations", indexes = {
        @Index(name = "inn_index", columnList = "inn", unique = true),
        @Index(name = "ogrn_index", columnList = "ogrn", unique = true)})
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String fullName;
    @NotBlank
    private String shortName;
    @NotBlank
    private String inn;
    @NotBlank
    private String ogrn;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Address post;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Address fact;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Director director;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private List<Organization> branches;
}
