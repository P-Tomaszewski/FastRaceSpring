package p.tomaszewski.FastRace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.model.Race;
import p.tomaszewski.FastRace.model.RaceRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class RaceController {
    private static final Logger logger= LoggerFactory.getLogger(DriverController.class);
    private final RaceRepository repository;

    public RaceController(final RaceRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/races")
    ResponseEntity<Race> createRace(@RequestBody @Valid Race toCreate){
        Race result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/races")
    ResponseEntity<List<Race>> readAllRaces(){
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/races/{id}")
    ResponseEntity<Race> readRaces(@PathVariable int id){
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/races/{id}")
    ResponseEntity<?> updateRace(@PathVariable int id, @RequestBody @Valid Race toUpdate){ //PathVariable = id z sciezki
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
    @Transactional
    @PatchMapping("/races/{id}") //zmiana
    public ResponseEntity<?> toggleDriver(@PathVariable int id){ //PathVariable = id z sciezki
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(driver -> driver.setSurface("Brabus"));
        return ResponseEntity.noContent().build();
    }
}
