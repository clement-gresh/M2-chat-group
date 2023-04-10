package com.example.linker.controller;

import com.example.linker.dto.GenericDto;
import com.example.linker.model.GenericModel;
import com.example.linker.payload.GenericPayload;
import com.example.linker.service.GenericService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TO DO :
// - spring security
// - put it online so that it can be accessed from another computer (like for DAAR)
// - login: send empty DTO if username is not in DB (same result as if wrong pwd)
// - register: if fail, indicate whether the username or email already exists
// - Tests
// - Check that the way the registration and login are done is correct
// - Use the swagger to show what routes can be used (add the dependencies for the swagger in pom.xml)

// What could be added
// - Utiliser ResponseEntity comme intermédiaire pour renvoyer des résultats au front
// (permet de complètement définir la réponse HTTP)

public abstract class GenericController<MODEL extends GenericModel, DTO extends GenericDto,
        PAYLOAD extends GenericPayload, T> {

    protected final GenericService<MODEL, DTO, PAYLOAD, T> service;

    public GenericController(GenericService<MODEL, DTO, PAYLOAD, T> service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<DTO> getAll(){ return service.getAll(); }

    @GetMapping("/{id}")
    public DTO getById(@PathVariable("id") final T id) { return service.get(id); }

    // The same road is used for creation and update.
    // debug : for update, we expect the front to do a getUser(id), then change some User attributes,
    // then update the user. Most of the work is done by the frontend.
    @PostMapping("/")
    public DTO save(@RequestBody PAYLOAD payload) { return service.save(payload); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final T id) {
        service.delete(id);
    }
}