package com.example.jdbctemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    @JsonProperty
    private int id;

    @NotBlank
    @JsonProperty("First Name")
    private String firstName;

    @NotBlank
    @JsonProperty("Last Name")
    private String lastName;

    @NotBlank
    @JsonProperty("Email")
    private String email;
}
