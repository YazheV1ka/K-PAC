package controller;

import entity.KPac;
import entity.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.KPacService;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

    @Autowired
    public KPacService kPacService;

    @GetMapping("/kpacs")
    public String getAllKPacs(Model model) {
        model.addAttribute("kpacs", kPacService.findAll());
        return "kpacsList";
    }

    @GetMapping("/sets")
    public String getAllSets(Model model) {
        model.addAttribute("sets", kPacService.findAll());
        return "setsList";
    }

    @RequestMapping(value = "/kpacs/add", method = RequestMethod.POST)
    public String addKPac(@ModelAttribute("kPac") KPac kPac){
        if(kPac.getId() == 0){
            this.kPacService.addBook(kPac);
        }
        return "redirect:/kpacs";
    }

    @RequestMapping(value = "/sets/add", method = RequestMethod.POST)
    public String addKPac(@ModelAttribute("set") Set set){
        if(set.getId() == 0){
            this.setService.addBook(set);
        }
        return "redirect:/sets";
    }
    /*@Autowired(required = true)
    @Qualifier(value = "kPacService")
    public void setBookService(kPacService kpacService) {
        this.kpacService = bookService;
    }*/

    /*@RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book){
        if(book.getId() == 0){
            this.bookService.addBook(book);
        }else {
            this.bookService.updateBook(book);
        }

        return "redirect:/books";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.bookService.removeBook(id);

        return "redirect:/books";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }*/

}
