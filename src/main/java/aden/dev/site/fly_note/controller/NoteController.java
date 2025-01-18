package aden.dev.site.fly_note.controller;

import aden.dev.site.fly_note.dto.NoteReqDto;
import aden.dev.site.fly_note.entity.NoteEntity;
import aden.dev.site.fly_note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/v1/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/add")
    public NoteEntity addNote(@RequestBody NoteReqDto req) {
        return noteService.createNote(req.getTitle(), req.getContent());
    }
}
