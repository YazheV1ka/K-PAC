package controller;

import entity.KPac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.KPacService;


@Controller
@RequestMapping("/kpacs")
public class KPacController {

    @Autowired
    public KPacService kPacService;

    @GetMapping()
    public String getAllKPacs(Model model) {
        model.addAttribute("kpacs", kPacService.findAll());
        return "kpacsList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createKPac(@ModelAttribute("kPac") KPac kPac) {
        this.kPacService.create(kPac);
        return "redirect: /kpacs";
    }

    @GetMapping("/create")
    public String create(){
        return "createkPac";
    }

    @RequestMapping("/removeKPac/{id}")
    public String removeKPac(@PathVariable("id") int id) {
        this.kPacService.delete(id);

        return "redirect:/kpacs";
    }
}
