package com.works.days2.controllers;

import com.works.days2.props.Notes;
import com.works.days2.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {

    NoteService noteService = new NoteService();

    @GetMapping("/noteshome")
    public String notesHome(Model model){

        model.addAttribute("notes",noteService.getNotes());

        return "noteshome";
    }

    @GetMapping("/noteDelete/{nid}")
    public String noteDelete(@PathVariable int nid, Model model){

        model.addAttribute("notes",noteService.deleteNote(nid));

        return "redirect:/noteshome";
    }



    @GetMapping("/notes")
    public String notes(){


        return "notes";
    }

    @PostMapping("/noteSave")
    public String noteSave(Notes notes){
        NoteService noteService = new NoteService();
        int status = noteService.noteSave(notes);

        if (status>0){
            return "redirect:/noteshome";
        }

        return "notes";
    }




}
