package aden.dev.site.fly_note.repository;

import aden.dev.site.fly_note.entity.NoteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<NoteEntity, String> {}
