package controller;

import entity.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.SetService;

@Controller
@RequestMapping("/sets")
public class SetController {

    @Autowired
    public SetService setService;


    @GetMapping("/sets")
    public String getAllSets(Model model) {
        model.addAttribute("sets", setService.findAll());
        return "setsList";
    }

  /*  @GetMapping("/set/{id}")
    public String getSetById(@PathVariable("id") int id, Model model) {
        model.addAttribute("set",setService.getById(id));

        return "showSet";
    }*/

    @PostMapping("/createSet")
    public String createSet(@ModelAttribute("set") Set set) {
        setService.create(set);

        return "redirect: /sets";
    }

    @GetMapping("/create")
    public String create(){
        return "createSet";
    }

    @GetMapping("/removeSet/{id}")
    public String deleteSet(@PathVariable("id") int id) {
        this.setService.delete(id);

        return "redirect:/sets";
    }

    @GetMapping("/kPacsToSet/{id}")
    public String viewKPacsToSet(@PathVariable("id") int id) {
        this.setService.findAttachedKPacs(id);

        return "kPacsToSetList";
    }

    /*@RequestMapping(value = "/sets/add", method = RequestMethod.POST)
    public String createSet(@ModelAttribute("set") Set set) {
        this.setService.create(set);

        return "redirect:/sets";
    }

    @RequestMapping("/removeSet/{id}")
    public String removeSet(@PathVariable("id") int id) {
        this.setService.delete(id);

        return "redirect:/sets";
    }

    @RequestMapping("/kPacsToSet/{id}")
    public String viewKPacsToSet(@PathVariable("id") int id) {
        this.setService.findAttachedKPacs(id);

        return "kPacsToSetList";
    }*/

}
