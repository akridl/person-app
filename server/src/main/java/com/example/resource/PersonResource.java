package com.example.resource;

import com.example.api.EditPersonDto;
import com.example.api.PersonDto;
import com.example.mapper.PersonMapper;
import com.example.model.Person;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonMapper personMapper;

    @POST
    @Transactional
    public PersonDto createPerson(EditPersonDto createPersonDto) {
        Person newPerson = personMapper.toEntity(createPersonDto);
        Person.persist(newPerson);
        Person.flush();
        return personMapper.toDto(newPerson);
    }

    @GET
    public List<PersonDto> getAllPersons() {
        List<Person> personEntities = Person.listAll();
        return personEntities.stream().map(personMapper::toDto).toList();
    }

    @GET
    @Path("/{id}")
    public PersonDto getSpecificPerson(@PathParam("id") String id) {
        Person person = Person.findById(Long.valueOf(id));
        return personMapper.toDto(person);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void deletePerson(@PathParam("id") String id) {
        Person.deleteById(Long.valueOf(id));
    }
}
