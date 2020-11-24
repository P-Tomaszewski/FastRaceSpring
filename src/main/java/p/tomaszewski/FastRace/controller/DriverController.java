package p.tomaszewski.FastRace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DriverController {
    private static final Logger logger= LoggerFactory.getLogger(DriverController.class);
    private final DriverRepository repository;

    public DriverController(final DriverRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/drivers")
    ResponseEntity<List<Driver>> readAllDrivers(){
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/drivers/{id}")
    ResponseEntity<?> updateDriver(@PathVariable int id, @RequestBody @Valid Driver toUpdate){ //PathVariable = id z sciezki
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
}
