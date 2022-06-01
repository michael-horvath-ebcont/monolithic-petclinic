package org.springframework.samples.vetservice.vet.dto;

import java.util.List;

public class VetDto {
    private String firstName;
    private String lastName;
    private int nrOfSpecialties;
    private List<String> specialties;

    public VetDto(String firstname, String lastname, List<String> specialties) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.specialties = specialties;
        this.nrOfSpecialties = specialties.size();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public int getNrOfSpecialties() {
        return nrOfSpecialties;
    }
}
