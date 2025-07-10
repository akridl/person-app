package com.example;

import com.example.api.EditPersonDto;
import com.example.api.PersonDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient
@Path("/persons")
public interface PersonService {

    @POST
    PersonDto createPerson(EditPersonDto createPersonDto);

    @GET
    List<PersonDto> getAllPersons();
}
