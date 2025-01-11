package aden.dev.site.fly_note.controller;

import aden.dev.site.fly_note.dto.NoteReqDto;
import aden.dev.site.fly_note.dto.UserReqDto;
import aden.dev.site.fly_note.entity.NoteEntity;
import aden.dev.site.fly_note.entity.UserEntity;
import aden.dev.site.fly_note.service.NoteService;
import aden.dev.site.fly_note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;
    private final NoteService noteService;

    @Autowired
    public UserController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @PostMapping("/addUser")
    public UserEntity addUser(@RequestBody UserReqDto req) {
        return userService.createUser(req.getName());
    }

    @PostMapping("/addNote")
    public NoteEntity addNote(@RequestBody NoteReqDto req) {
        NoteEntity note = new NoteEntity();
        note.setTitle(req.getTitle());
        note.setContent(req.getContent());

        return noteService.createNote(req.getTitle(), req.getContent());
    }
}
