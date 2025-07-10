package com.example.api;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@Jacksonized
public class PersonDto extends EditPersonDto {

    String id;
}
