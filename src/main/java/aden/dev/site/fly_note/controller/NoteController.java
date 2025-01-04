package aden.dev.site.fly_note.controller;

import aden.dev.site.fly_note.dto.NoteReqDto;
import aden.dev.site.fly_note.dto.UserReqDto;
import aden.dev.site.fly_note.entity.NoteEntity;
import aden.dev.site.fly_note.entity.UserEntity;
import aden.dev.site.fly_note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class NoteController {
//    @Autowired
//    private NoteService noteService;
//
//    @PostMapping("/addUser")
//    public NoteEntity addNote(@RequestBody NoteReqDto req) {
////        UserEntity user = new UserEntity();
////        note.setTitle(req.getTitle());
////        note.setContent(req.getContent());
//
//        return noteService.createNote(req.getTitle(), req.getContent());
//    }
}
