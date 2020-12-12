package p.tomaszewski.FastRace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.DriverRaceResultRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/driverraceresults")
public class DriverRaceResultController {
    private static final Logger logger = LoggerFactory.getLogger(DriverRaceResultController.class);
    private final DriverRaceResultRepository repository;

    public DriverRaceResultController(final DriverRaceResultRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    ResponseEntity<DriverRaceResult> createDriverRaceResult(@RequestBody @Valid DriverRaceResult toCreate) {
        DriverRaceResult result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping
    ResponseEntity<List<DriverRaceResult>> readAllDriverRaceResult() {
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<DriverRaceResult> readDriverRaceResult(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateDriverRaceResult(@PathVariable int id, @RequestBody @Valid DriverRaceResult toUpdate) { //PathVariable = id z sciezki
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PatchMapping("/{id}") //zmiana
    public ResponseEntity<?> toggleDriverRaceResult(@PathVariable int id) { //PathVariable = id z sciezki
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(driverRaceResult -> driverRaceResult.setPlace(5));
        return ResponseEntity.noContent().build();
    }
}
