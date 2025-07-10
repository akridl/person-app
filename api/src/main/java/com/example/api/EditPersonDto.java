package com.example.api;

import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Value
@SuperBuilder(toBuilder = true)
@NonFinal
@Jacksonized
public class EditPersonDto {

    String givenName;
    String familyName;
    LocalDate birthDate;
}
