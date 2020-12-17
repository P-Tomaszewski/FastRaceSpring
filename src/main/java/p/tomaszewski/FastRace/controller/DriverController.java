package p.tomaszewski.FastRace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.logic.DriverService;
import p.tomaszewski.FastRace.logic.RaceService;
import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRepository;
import p.tomaszewski.FastRace.model.projection.DriverWriteModel;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/addDriver")
public class DriverController {
    private static final Logger logger= LoggerFactory.getLogger(DriverController.class);
    private final DriverRepository repository;
    private final DriverService service;

    public DriverController(final DriverRepository repository, DriverService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    String showProjects(Model model){
        var driverToEdit = new Driver();
        driverToEdit.setFirstName("test");
        model.addAttribute("driver", driverToEdit);
        return "addDriver";
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String addProject(@Valid
                      @ModelAttribute("driver") DriverWriteModel current,
                      BindingResult bindingResult,
                      Model model){
        if(bindingResult.hasErrors()){
            return "addDriver";
        }
        service.createDriver(current);
        model.addAttribute("driver", new DriverWriteModel());
        return "addDriver";


    }

    @ResponseBody
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Driver> creatDriver(@RequestBody @Valid Driver toCreate){
        Driver result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Driver>> readAllDrivers(){
        logger.warn("Exposing all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

//    @ResponseBody
//    @GetMapping("/{id}")
//        ResponseEntity<Driver> readDriver(@PathVariable int id){
//        return repository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//        }
//
//    @ResponseBody
//    @PutMapping("/{id}")
//    ResponseEntity<?> updateDriver(@PathVariable int id, @RequestBody @Valid Driver toUpdate){ //PathVariable = id z sciezki
//        if(!repository.existsById(id)){
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
//   public ResponseEntity<?> toggleDriver(@PathVariable int id){ //PathVariable = id z sciezki
//        if(!repository.existsById(id)){
//            return ResponseEntity.notFound().build();
//        }
//        repository.findById(id)
//                .ifPresent(driver -> driver.setCar("Brabus"));
//        return ResponseEntity.noContent().build();
//    }
}
