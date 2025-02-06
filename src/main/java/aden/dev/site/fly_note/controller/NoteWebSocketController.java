package aden.dev.site.fly_note.controller;

import aden.dev.site.fly_note.dto.NoteMessage;
import org.apache.tomcat.util.json.JSONFilter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class NoteWebSocketController {

    @MessageMapping("/hello")  // Client sends to /app/hello
    @SendTo("/topic/notes")         // Server broadcasts to /topic/notes
    public NoteMessage handleNoteUpdate(NoteMessage message) {
        System.out.println("Message received: " + message.toString());
        message.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return message;
    }
} 