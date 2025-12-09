package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled(value = "Disabled until we can mock")
class OwnerSDJpaServiceTest {

    OwnerSDJpaService testService;
    OwnerRepository ownerRepository;
    PetRepository petRepository;
    PetTypeRepository petTypeRepository;

    @BeforeEach
    void setUp() {
        testService = new OwnerSDJpaService(
            ownerRepository,
            petRepository,
            petTypeRepository);
    }

    @Disabled
    @Test
    void findByLastName() {
        assertEquals(new Owner(1L, "j", "Black"), testService.findByLastName("Buck"), "What a mess!");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}