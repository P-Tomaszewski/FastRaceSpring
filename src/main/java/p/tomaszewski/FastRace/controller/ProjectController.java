package p.tomaszewski.FastRace.controller;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import p.tomaszewski.FastRace.logic.DriverService;
import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.projection.DriverWriteModel;

import javax.validation.Valid;


@Controller
@RequestMapping("/addDriver")
public class ProjectController {
    private final DriverService service;

    public ProjectController(DriverService service) {
        this.service = service;
    }


    @GetMapping
    String showProjects(Model model){
        var driverToEdit = new Driver();
        driverToEdit.setFirstName("test");
        model.addAttribute("driver", driverToEdit);
        return "addDriver";
    }

    @PostMapping
    String addProject(@Valid
            @ModelAttribute("driver") DriverWriteModel current,
            BindingResult bindingResult,
            Model model){
        if(bindingResult.hasErrors()){
            return "addDriver";
        }
        service.createDriver(current);
        model.addAttribute("driver", new DriverWriteModel());
//        model.addAttribute("message", "dodano kierowce");
        return "addDriver";


    }


}
