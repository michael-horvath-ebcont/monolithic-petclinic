package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.db.OwnerRepository;
import org.springframework.samples.petclinic.db.PetRepository;
import org.springframework.samples.petclinic.db.RevenueRepository;
import org.springframework.samples.petclinic.vet.db.VetRepository;
import org.springframework.samples.petclinic.db.VisitRepository;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.vet.dto.VetDto;
import org.springframework.samples.petclinic.vet.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.model.YearlyRevenue;
import org.springframework.samples.petclinic.vet.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ClinicService {

    private final OwnerRepository owners;
    private final PetRepository pets;
    private final VisitRepository visits;
    private final RevenueRepository revenueRepository;
    private final VetService vets;

    public ClinicService(
        OwnerRepository owners,
        PetRepository pets,
        VisitRepository visits,
        VetService vets,
        RevenueRepository revenueRepository
    ) {
        this.owners = owners;
        this.pets = pets;
        this.visits = visits;
        this.vets = vets;
        this.revenueRepository = revenueRepository;
    }


    public Collection<Owner> ownerByLastName(String lastName) {
        return owners.findByLastName(lastName);
    }

    public Owner ownerById(int i) {
        return owners.findById(i);
    }

    public Pet petById(int id) {
        return pets.findById(id);
    }

    public List<PetType> petTypes() {
        return pets.findPetTypes();
    }

    public List<Visit> visitsByPetId(int petId) {
        return visits.findByPetId(petId);
    }

    public Collection<VetDto> allVets() {
        return this.vets.allVets();
    }

    public void save(Owner owner) {
        owners.save(owner);
    }

    public void save(Pet pet) {
        pets.save(pet);
    }

    public void save(Visit visit) {
        visits.save(visit);
    }

    public List<YearlyRevenue> listYearlyRevenue() {
        return revenueRepository.listYearlyRevenue();
    }
}
