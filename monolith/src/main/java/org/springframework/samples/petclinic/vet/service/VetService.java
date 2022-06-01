package org.springframework.samples.petclinic.vet.service;

import org.springframework.samples.petclinic.vet.db.VetRepository;
import org.springframework.samples.petclinic.vet.dto.VetDto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class VetService {
    private final VetRepository vets;

    public VetService(
            VetRepository vets
    ) {
        this.vets = vets;
    }

    public Collection<VetDto> allVets() {
        return this.vets.findAll().stream().map(vet -> new VetDto(vet.getFirstName(), vet.getLastName(), vet.getSpecialties().stream().map((specialty -> specialty.getName())).collect(Collectors.toList()))).collect(Collectors.toList());
    }

}
