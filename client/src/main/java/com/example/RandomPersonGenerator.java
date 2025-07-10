package com.example;

import com.example.api.EditPersonDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class RandomPersonGenerator {

    @Inject
    Random random;

    private static final List<String> GIVEN_NAMES = List.of("John", "Jane", "Scott", "Ralph", "Emily", "Aileen");
    private static final List<String> FAMILY_NAMES = List.of("Doe", "Smith", "MacArthur");

    public EditPersonDto generateRandomPerson() {
        return EditPersonDto.builder()
                .givenName(getRandomGivenName())
                .familyName(getRandomFamilyName())
                .birthDate(getRandomBirthDate())
                .build();
    }

    private String getRandomGivenName() {
        return getRandomName(GIVEN_NAMES);
    }

    private String getRandomFamilyName() {
        return getRandomName(FAMILY_NAMES);
    }

    private String getRandomName(List<String> names) {
        return names.get(random.nextInt(names.size()));
    }

    private LocalDate getRandomBirthDate() {
        return LocalDate.now().minusYears(random.nextInt(100));
    }
}
