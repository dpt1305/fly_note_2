package aden.dev.site.fly_note.service;

import aden.dev.site.fly_note.entity.NoteEntity;
import aden.dev.site.fly_note.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public NoteEntity createNote(String title, String content) {
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setContent(content);
        noteEntity.setTitle(title);

        noteRepository.save(noteEntity);
        return noteEntity;
    }
}
