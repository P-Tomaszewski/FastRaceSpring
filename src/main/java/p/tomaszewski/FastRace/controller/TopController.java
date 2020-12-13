package p.tomaszewski.FastRace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import p.tomaszewski.FastRace.logic.DriverService;
import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.projection.DriverReadModel;
import p.tomaszewski.FastRace.model.projection.DriverWriteModel;

import java.util.List;

@Controller
@RequestMapping("/top")
public class TopController {
    private final DriverService service;

    public TopController(DriverService service) {
        this.service = service;
    }


    @GetMapping
    String showTopDrivers(Model model){
        var drivers = new Driver();
        model.addAttribute("driver", drivers);
        return "top";
    }

    @PostMapping
    String addProject(@ModelAttribute("driver") DriverWriteModel current, Model model){
        service.createDriver(current);
        model.addAttribute("driver", new DriverWriteModel());
//        model.addAttribute("message", "dodano kierowce");
        return "top";
    }

    @ModelAttribute("drivers")
    List<DriverReadModel> getDrivers(){
        return service.readAll();
    }


}