package org.springframework.samples.vetservice.vet.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.vetservice.vet.dto.VetDto;
import org.springframework.samples.vetservice.vet.service.VetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class VetApi {

    @Autowired
    VetService service;

    @GetMapping("/vets")
    public Collection<VetDto> allVets() {
        return service.allVets();
    }

}
