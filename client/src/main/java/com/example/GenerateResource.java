package com.example;

import com.example.api.PersonDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/generate")
@Produces(MediaType.APPLICATION_JSON)
public class GenerateResource {

    @RestClient
    PersonService personService;

    @Inject
    RandomPersonGenerator personGenerator;

    @POST
    public PersonDto generatePerson() {
        return personService.createPerson(personGenerator.generateRandomPerson());
    }

    @GET
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }
}
