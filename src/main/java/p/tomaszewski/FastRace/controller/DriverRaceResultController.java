package p.tomaszewski.FastRace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.logic.DriverRaceResultService;
import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.DriverRaceResultRepository;
import p.tomaszewski.FastRace.model.projection.DriverRaceResultWriteModel;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/addScore")
public class DriverRaceResultController {
    private static final Logger logger = LoggerFactory.getLogger(DriverRaceResultController.class);
    private final DriverRaceResultRepository repository;
    private final DriverRaceResultService service;


    public DriverRaceResultController(final DriverRaceResultRepository repository, DriverRaceResultService service) {
        this.repository = repository;
        this.service = service;
    }


    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    String showProjects(Model model){
        var driverRaceResult = new DriverRaceResult();
        model.addAttribute("driverraceresult", driverRaceResult);
        return "addScore";
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String addRace(@Valid
                   @ModelAttribute("driverraceresult") DriverRaceResultWriteModel current,
                   BindingResult bindingResult,
                   Model model) {
        if (bindingResult.hasErrors()) {
            return "addScore";
        }
        service.createDriverRaceResultService(current);
        model.addAttribute("driverraceresult", new DriverRaceResultWriteModel());
//        model.addAttribute("message", "dodano kierowce");
        return "addScore";
    }

//    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
//    String showRaces(Model model){
//        model.addAttribute("result", new DriverRaceResultWriteModel());
//        return "addScore";
//    }

    @ResponseBody
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DriverRaceResult> createDriverRaceResult(@RequestBody @Valid DriverRaceResult toCreate) {
        DriverRaceResult result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<DriverRaceResult>> readAllDriverRaceResult() {
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }



//    @ResponseBody
//    @GetMapping("/{id}")
//    ResponseEntity<DriverRaceResult> readDriverRaceResult(@PathVariable int id) {
//        return repository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @ResponseBody
//    @PutMapping("/{id}")
//    ResponseEntity<?> updateDriverRaceResult(@PathVariable int id, @RequestBody @Valid DriverRaceResult toUpdate) { //PathVariable = id z sciezki
//        if (!repository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        toUpdate.setId(id);
//        repository.save(toUpdate);
//        return ResponseEntity.noContent().build();
//    }
//
//    @ResponseBody
//    @Transactional
//    @PatchMapping("/{id}") //zmiana
//    public ResponseEntity<?> toggleDriverRaceResult(@PathVariable int id) { //PathVariable = id z sciezki
//        if (!repository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        repository.findById(id)
//                .ifPresent(driverRaceResult -> driverRaceResult.setScore(5));
//        return ResponseEntity.noContent().build();
//    }
}
