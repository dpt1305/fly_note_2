package aden.dev.site.fly_note.service;

import aden.dev.site.fly_note.dto.NoteMessage;
import aden.dev.site.fly_note.dto.NoteReqDto;
import aden.dev.site.fly_note.entity.NoteEntity;
import aden.dev.site.fly_note.repository.NoteRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final SimpMessagingTemplate messagingTemplate;


    @Autowired
    public NoteService(NoteRepository noteRepository, SimpMessagingTemplate messagingTemplate) {
        this.noteRepository = noteRepository;
        this.messagingTemplate = messagingTemplate;
    }

    public NoteEntity createNote(String title, String content) {
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setContent(content);
        noteEntity.setTitle(title);

        noteRepository.save(noteEntity);
        return noteEntity;
    }

    // Example method for updating a note
    public NoteEntity updateNote(ObjectId id, NoteReqDto request) {
        NoteEntity updatedNote = noteRepository.findById(id.toString())
            .orElseThrow(() -> new RuntimeException("Note not found"));
        
        // Broadcast the update
        NoteMessage message = new NoteMessage();
        message.setType("UPDATE");
        message.setNoteId(id.toString());
        message.setContent(request.getContent());
        message.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        
        messagingTemplate.convertAndSend("/topic/notes", message);
        
        return updatedNote;
    }
}
