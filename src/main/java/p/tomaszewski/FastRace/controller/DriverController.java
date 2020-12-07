package p.tomaszewski.FastRace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class DriverController {
    private static final Logger logger= LoggerFactory.getLogger(DriverController.class);
    private final DriverRepository repository;

    public DriverController(final DriverRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/drivers")
    ResponseEntity<Driver> creatDriver(@RequestBody @Valid Driver toCreate){
        Driver result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/drivers")
    ResponseEntity<List<Driver>> readAllDrivers(){
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/drivers/{id}")
        ResponseEntity<Driver> readDriver(@PathVariable int id){
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
