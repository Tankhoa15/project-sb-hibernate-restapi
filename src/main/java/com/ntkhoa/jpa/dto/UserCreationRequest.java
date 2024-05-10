package com.ntkhoa.jpa.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserCreationRequest {

    private String username;

    @Size(min = 8, message = "Password must be at least 8 character!")
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
