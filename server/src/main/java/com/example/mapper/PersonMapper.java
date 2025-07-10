package com.example.mapper;

import com.example.api.EditPersonDto;
import com.example.api.PersonDto;
import com.example.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CommonMapperConfig.class)
public interface PersonMapper extends GenericMapper<EditPersonDto, PersonDto, Person> {

    @Override
    PersonDto toDto(Person entity);

    @Override
    @Mapping(target = "id", ignore = true)
    Person toEntity(EditPersonDto editPersonDto);
}
