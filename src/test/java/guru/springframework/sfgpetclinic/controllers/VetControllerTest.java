package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest implements ControllerTests {
    SpecialtyService specialtyService;
    VetController controller;
    VetMapService service;


    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        service = new VetMapService(specialtyService);
        controller = new VetController(service);
        Vet aVet = new Vet(1L, "Jed", "Clampett", null);
        Vet bVet = new Vet(2L, "Monty", "Hall", null);
        service.save(aVet);
        service.save(bVet);
    }

    @Test
    void listVets() {
        ModelMapImpl mimpl = new ModelMapImpl();
        String view = controller.listVets(mimpl);
        assertThat("vets/index").isEqualTo(view);
        Set modAttr = (Set)((ModelMapImpl)mimpl).getMap().get("vets");
        assertThat(modAttr.size()).isEqualTo(2);
    }
}