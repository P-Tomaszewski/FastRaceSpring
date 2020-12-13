package p.tomaszewski.FastRace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import p.tomaszewski.FastRace.model.Driver;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private
    @GetMapping
    String showProjects(Model model){
        var driverToEdit = new Driver();
        driverToEdit.setFirstName("test");
        model.addAttribute("driver", driverToEdit);
        return "addDriver";
    }

//    @PostMapping
//    String addProject(@ModelAttribute("addDriver") Driver driver, Model model){
////
//    }


}
