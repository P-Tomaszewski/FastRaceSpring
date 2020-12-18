package p.tomaszewski.FastRace.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.logic.DriverRaceResultService;
import p.tomaszewski.FastRace.logic.DriverService;
import p.tomaszewski.FastRace.logic.RaceService;
import p.tomaszewski.FastRace.model.*;
import p.tomaszewski.FastRace.model.projection.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/result")
public class DriverResultController {
    private final DriverService service;
    private final RaceService raceService;
    private final DriverRaceResultService driverRaceResultService;
    private final DriverRepository repository;



    public DriverResultController(DriverService service, RaceService raceService, DriverRaceResultService driverRaceResultService, DriverRepository repository) {
        this.service = service;
        this.raceService = raceService;
        this.driverRaceResultService = driverRaceResultService;
        this.repository = repository;
    }


    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    String showResultToDriver(Model model){
        model.getAttribute("result2");
        var drivers = new DriverResult();
        model.addAttribute("result2", drivers);
        return "result";
    }



    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String addProject(@Valid @ModelAttribute("result2") DriverResult currency, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "result";
        }

        return "result";
    }


    @ModelAttribute("drivers")
    List<DriverReadModel> getDrivers(){
        return service.readAll();
    }

    @ModelAttribute("races")
    List<RaceReadModel> getRaces(){
        return raceService.readAll();
    }

    @ModelAttribute("results")
    List<DriverRaceResultReadModel> getResults(){
        return driverRaceResultService.readAll();
    }


}
