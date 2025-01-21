package aden.dev.site.fly_note.dto;

import lombok.Data;

@Data
public class NoteMessage {
    private String type;  // e.g., "CREATE", "UPDATE", "DELETE"
    private String noteId;
    private String content;
    private String timestamp;
}